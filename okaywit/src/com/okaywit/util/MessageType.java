package com.okaywit.util;

public enum MessageType {
        JOIN(0), MOVE(1), LEAVE(2), ATTACK(3), KILL(4);
        private int id;

        public int getId() {
                return id;
        }

        private MessageType(int id) {
                this.id = id;
        }

        public static void main(String[] args) {
                System.out.println("---" + MessageType.JOIN.id);
        }
}
