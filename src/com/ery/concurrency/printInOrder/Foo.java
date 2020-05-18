package com.ery.concurrency.printInOrder;

import java.util.concurrent.CountDownLatch;

public class Foo {

    private final CountDownLatch L1 = new CountDownLatch(1);
    private final CountDownLatch L2 = new CountDownLatch(1);

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        L1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        L1.await();
        printSecond.run();
        L2.countDown();

    }

    public void third(Runnable printThird) throws InterruptedException {
        L2.await();
        printThird.run();
    }

}
