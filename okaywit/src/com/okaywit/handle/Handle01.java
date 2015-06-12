package com.okaywit.handle;

import java.util.Iterator;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;

import com.okaywit.po.Cache;
import com.okaywit.po.GameSession;

@ServerEndpoint("/chat")
public class Handle01 extends AbstractHandle {
        static Logger logger = Logger.getLogger(Handle01.class);

        @OnMessage
        @Override
        public void onHandle(String message) {
                System.out.println("---");
                for (Iterator<GameSession> it = Cache.sessionMap.values().iterator(); it.hasNext();) {
                        GameSession gameSession = it.next();
                        Session session = gameSession.getSession();

                        try {
                                session.getBasicRemote().sendText("343");

                        } catch (Exception e) {
                                e.printStackTrace();
                                it.remove();
                        }
                }
        }

}
