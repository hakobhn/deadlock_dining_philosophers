package com.examples.deadlock.locks;

import com.examples.deadlock.Fork;
import com.examples.deadlock.Philosopher;

public class PhilosopherWithLockImpl extends Philosopher {
    private Fork leftFork;
    private Fork rightFork;

    public PhilosopherWithLockImpl(Fork leftFork, Fork rightFork, String name) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.name = name;
    }

    /**
     * Implementing process of eating with lock mechanism
     */
    @Override
    public void eat() {
// Try to get the left fork
        if (leftFork.tryLock()) {
            System.out.println(name + " picked up left fork: " + leftFork.getNumber()+", used: "+leftFork.isUsed());
            leftFork.setUsed(true);
            try {
// try to get the right fork
                if (rightFork.tryLock()) {
                    System.out.println(name + " picked up right fork: " + rightFork.getNumber()+", used: "+rightFork.isUsed());
                    rightFork.setUsed(true);
                    try {
// Got both forks. Eat now
                        System.out.println(name + " starting to eat...");
                        try {
                            Thread.sleep(sleep);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(name + " finished to eat...");
                    } finally {
// release the right fork
                        rightFork.unlock();
                        rightFork.setUsed(false);
                    }
                }
            } finally {
// release the left fork
                leftFork.unlock();
                leftFork.setUsed(false);
            }
        }
    }
}
