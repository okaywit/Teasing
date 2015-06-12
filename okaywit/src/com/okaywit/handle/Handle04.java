package com.okaywit.handle;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.okaywit.po.Cache;
import com.okaywit.po.GameSession;
import com.okaywit.util.Direction;
import com.okaywit.util.MessageType;

public class Handle04 extends AbstractHandle {
        static Logger logger = Logger.getLogger(Handle04.class);

        @Override
        public void onHandle(String message) {

                JSONObject changePosition = JSONObject.parseObject(message);
                int type = changePosition.getIntValue("type");

                int x = changePosition.getIntValue("x"), y = changePosition.getIntValue("y");
                if (type == MessageType.ATTACK.getId() && x < 795 && y < 795) {
                        int direction = changePosition.getIntValue("direction");

                        long targetPosition = 0;
                        if (direction == Direction.LEFT.getKey())
                                targetPosition = Cache.map[x - 10][y];
                        if (direction == Direction.UP.getKey())
                                targetPosition = Cache.map[x][y - 10];
                        if (direction == Direction.RIGHT.getKey())
                                targetPosition = Cache.map[x + 10][y];
                        if (direction == Direction.DOWN.getKey())
                                targetPosition = Cache.map[x][y + 10];

                        if (targetPosition > 0) {
                                GameSession session = Cache.sessionMap.get(targetPosition);

                                try {
                                        session.getSession().getBasicRemote().sendText(broadcast(targetPosition, 0, 0, 4, "Be killed!", 39));
                                } catch (IOException e) {
                                        e.printStackTrace();
                                }
                        }

                }

                System.out.println("------");

        }
}
