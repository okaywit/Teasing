package com.okaywit.po;

import javax.websocket.Session;

public class GameSession {
        private long id;
        private Session session;
        private Player player;

        public Session getSession() {
                return session;
        }

        public void setSession(Session session) {
                this.session = session;
        }

        public Player getPlayer() {
                return player;
        }

        public void setPlayer(Player player) {
                this.player = player;
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

}
