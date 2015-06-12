package com.okaywit.handle;

import java.util.Iterator;

import javax.websocket.Session;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.okaywit.po.Cache;
import com.okaywit.po.GameSession;

public class Handle03 extends AbstractHandle {
        static Logger logger = Logger.getLogger(Handle03.class);

        @Override
        public void onHandle(String message) {
                JSONObject changePosition = JSONObject.parseObject(message);

                for (Iterator<GameSession> it = Cache.sessionMap.values().iterator(); it.hasNext();) {
                        GameSession gameSession = it.next();
                        Session session = gameSession.getSession();

                        try {
                                if (changePosition.getLongValue("id") != gameSession.getId()) {
                                        session.getBasicRemote().sendText(message);

                                } else {
                                        //初始地图位置
                                        Cache.map[gameSession.getPlayer().getX()][gameSession.getPlayer().getY()] = 0;

                                        //更新自己信息缓存
                                        gameSession.getPlayer().setX(changePosition.getIntValue("x"));
                                        gameSession.getPlayer().setY(changePosition.getIntValue("y"));
                                        //
                                        Cache.map[gameSession.getPlayer().getX()][gameSession.getPlayer().getY()] = gameSession.getId();
                                }

                        } catch (Exception e) {
                                e.printStackTrace();
                                it.remove();
                        }
                }

        }
}
