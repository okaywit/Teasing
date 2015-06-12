package com.okaywit.util;

import java.util.Timer;
import java.util.TimerTask;

public class TaskExecutor {
        public static void test() {
                Timer t = new Timer();
                t.schedule(new TimerTask() {

                        @Override
                        public void run() {
                                System.out.println("--");

                        }
                }, 1000, 1000);
        }

        public static void main(String[] args) {
                TaskExecutor.test();
        }
}
