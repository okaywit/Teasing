package com.okaywit.util;

public enum Direction {
        LEFT(37), UP(38), RIGHT(39), DOWN(40);
        private int key;

        private Direction(int key) {
                this.key = key;
        }

        public int getKey() {
                return this.key;
        }
}
