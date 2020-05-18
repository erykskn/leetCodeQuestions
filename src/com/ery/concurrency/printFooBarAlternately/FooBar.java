package com.ery.concurrency.printFooBarAlternately;

import java.util.concurrent.Semaphore;

public class FooBar {
    private int n;
    private Semaphore semaphore1;
    private Semaphore semaphore2;


    public FooBar(int n) {
        this.n = n;
        semaphore1 = new Semaphore(1);
        semaphore2 = new Semaphore(1);
        try {
            semaphore2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                semaphore1.acquire();
                printFoo.run();
            } finally {
                semaphore2.release();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                semaphore2.acquire();
                printBar.run();
            } finally {
                semaphore1.release();
            }

        }
    }
}