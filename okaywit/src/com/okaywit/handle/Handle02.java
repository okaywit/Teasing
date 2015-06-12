package com.okaywit.handle;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;

@ServerEndpoint("/phone")
public class Handle02 extends AbstractHandle {

        static Logger logger = Logger.getLogger(Handle02.class);

        @OnMessage
        @Override
        public void onHandle(String message) {
                /*String str = PhoneNumber.request("http://apis.baidu.com/apistore/mobilephoneservice/mobilephone", "tel=" + message);
                try {
                        sessionMap.get(this.sessionId).getBasicRemote().sendText(str);
                } catch (IOException e) {
                        e.printStackTrace();
                }*/

        }

}
