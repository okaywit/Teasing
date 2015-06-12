package com.okaywit.po;

import java.util.HashMap;
import java.util.Map;

import com.okaywit.handle.AbstractHandle;
import com.okaywit.handle.Handle03;
import com.okaywit.handle.Handle04;

public class Cache {
        /**
         * Map<Íæ¼ÒID£¬»á»°>
         */
        public static Map<Long, GameSession> sessionMap = new HashMap<Long, GameSession>();

        public static long[][] map = new long[800][800];

        public static Map<Integer, AbstractHandle> handleMap = new HashMap<Integer, AbstractHandle>();
        static {
                handleMap.put(3, new Handle03());
                handleMap.put(4, new Handle04());
        }
}
