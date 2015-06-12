package com.okaywit.util;

import java.util.Random;

import com.okaywit.po.Cache;

public class MapUtil {
        private static Random r = new Random();

        public static Position getPosition() {
                int x = 10 * (r.nextInt(80)) + 5;
                int y = 10 * (r.nextInt(80)) + 5;
                if (Cache.map[x][y] > 0)
                        return getPosition();

                Position p = new Position();
                p.setPosition(x, y);

                return p;
        }

        public static class Position {
                public int x;
                public int y;

                public void setPosition(int x, int y) {
                        this.x = x;
                        this.y = y;
                }
        }
}
