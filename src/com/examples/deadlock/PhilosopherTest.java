package com.examples.deadlock;

import com.examples.deadlock.locks.PhilosopherWithLockImpl;

public class PhilosopherTest {
    public static void main(String[] args) {

        System.out.println("initializing forks...");
        Fork[] forks = new Fork[5];
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Fork(i, false);
        }

        System.out.println("initializing philosophers...");
        Philosopher[] philosophers = new Philosopher[5];
        String[] philosopherNames = {"John", "Wallace", "Adam", "Sam", "Charles"};

        for(int i = 0; i < philosophers.length; i++) {
//            philosophers[i] = new PhilosopherStandartImpl(forks[i], forks[(i + 1) % 5], philosopherNames[i]);
            philosophers[i] = new PhilosopherWithLockImpl(forks[i], forks[(i + 1) % 5], philosopherNames[i]);
        }

        for (int i = 0; i < philosophers.length; i++) {
            System.out.println(philosophers[i].name + " is starting...");
            philosophers[i].start();
        }
    }
}
