package com.dmm.controller;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/5/29 15:29
 * @motto The more learn, the more found his ignorance.
 */

public class NoVisibility {

    private static boolean ready;

    private static int number;

    public static class ReaderThread extends Thread{
        @Override
        public void run() {
            while (!ready){
                Thread.yield();
            }

            System.out.println(number);
        }
    }


    public static void main(String[] args) {
        new ReaderThread().start();
        number=42;
        ready=true;
    }
}

