package com.okaywit.handle;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.alibaba.fastjson.JSONObject;
import com.okaywit.po.Cache;
import com.okaywit.po.GameSession;
import com.okaywit.po.Player;
import com.okaywit.util.Direction;
import com.okaywit.util.MapUtil;
import com.okaywit.util.MapUtil.Position;
import com.okaywit.util.MessageType;

@ServerEndpoint("/game")
public class AbstractHandle {

        private static AtomicLong playerIds = new AtomicLong();
        protected long id;

        @OnOpen
        public void start(Session session) {
                id = playerIds.getAndIncrement();

                GameSession gs = new GameSession();
                gs.setId(id);
                gs.setSession(session);
                Position pos = MapUtil.getPosition();
                //地图缓存
                Cache.map[pos.x][pos.y] = id;

                Player p = new Player();
                p.setX(pos.x);
                p.setY(pos.y);
                p.setDirection(Direction.RIGHT.getKey());
                gs.setPlayer(p);

                try {
                        //创建玩家自己的信息
                        session.getBasicRemote().sendText(broadcast(id, p.getX(), p.getY(), MessageType.JOIN.getId(), "welcome", p.getDirection()));

                        for (Iterator<GameSession> it = Cache.sessionMap.values().iterator(); it.hasNext();) {
                                //加载其他玩家信息
                                GameSession s = it.next();
                                Player player = s.getPlayer();
                                System.out.println(s.getId() + "--" + player.getX() + "---" + player.getY());
                                session.getBasicRemote().sendText(broadcast(s.getId(), player.getX(), player.getY(), MessageType.JOIN.getId(), "stay in", player.getDirection()));
                                //推送自己给其他玩家
                                s.getSession().getBasicRemote().sendText(broadcast(id, p.getX(), p.getY(), MessageType.JOIN.getId(), "new in", p.getDirection()));
                        }
                        Cache.sessionMap.put(id, gs);

                } catch (IOException e) {
                        e.printStackTrace();
                }

        }

        @OnClose
        public void end() {
                Player player = Cache.sessionMap.get(this.id).getPlayer();
                String str = broadcast(this.id, player.getX(), player.getY(), MessageType.LEAVE.getId(), "leave game", player.getDirection());
                Cache.sessionMap.remove(id);

                //初始地图位置
                Cache.map[player.getX()][player.getY()] = 0;

                for (Iterator<GameSession> it = Cache.sessionMap.values().iterator(); it.hasNext();) {
                        GameSession s = it.next();
                        try {
                                s.getSession().getBasicRemote().sendText(str);
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }

        }

        @OnMessage
        public void onHandle(String message) {
                JSONObject changePosition = JSONObject.parseObject(message);
                Cache.handleMap.get(changePosition.getIntValue("hId")).onHandle(message);
        }

        @OnError
        public void onError(Throwable t) throws Throwable {
                t.printStackTrace();

        }

        public String broadcast(long id, int x, int y, int type, String msg, int direction) {
                return "{\"id\":\"" + id + "\",\"x\":\"" + x + "\",\"y\":\"" + y + "\",\"type\":\"" + type + "\",\"msg\":\"" + msg + "\"}";

        }
}
