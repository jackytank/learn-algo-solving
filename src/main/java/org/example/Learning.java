package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Learning {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Thread first = new Thread(c, "First");
        Thread second = new Thread(c, "Second");
        Thread third = new Thread(c, "Third");

        first.start();
        second.start();
        third.start();

        first.join();
        second.join();
        third.join();
        System.out.println(c.count);
        ExecutorService service = Executors.newVirtualThreadPerTaskExecutor();

    }
}

class Counter implements Runnable {

    AtomicInteger count;

    public Counter() {
        count = new AtomicInteger();
    }

    @Override
    public void run() {
        int max = 1_000_000;
        for (int i = 0; i < max; i++) {
            count.addAndGet(1);
        }
    }
}
