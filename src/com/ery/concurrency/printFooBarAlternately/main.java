package com.ery.concurrency.printFooBarAlternately;

import java.util.concurrent.Semaphore;

public class main {
    private static Semaphore semaphore1 = new Semaphore(1);
    private static Semaphore semaphore2 = new Semaphore(1);


    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).run();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    bar();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).run();

    }

    static void foo() throws InterruptedException {
        semaphore1.release();
        for (int a = 0; a < 100; a++) {
            semaphore1.acquire();
            System.out.print("foo");
            semaphore2.release();

        }
    }

    static void bar() throws InterruptedException {
        for (int a = 0; a < 100; a++) {
            semaphore2.acquire();
            System.out.println("bar");
            semaphore1.release();
        }
    }
}
