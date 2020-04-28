package com.examples.deadlock;

public class PhilosopherStandartImpl extends Philosopher {

    private Fork leftFork;
    private Fork rightFork;

    public PhilosopherStandartImpl(Fork leftFork, Fork rightFork, String name) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.name = name;
    }

    /**
     * Implementing process of eating using synchronization of critical sections: left aand right forks
     */
    @Override
    public void eat() {
        synchronized (leftFork) {
            System.out.println(name + " picked up left fork: " + leftFork.getNumber()+", used: "+leftFork.isUsed());
            leftFork.setUsed(true);
            synchronized (rightFork) {
                System.out.println(name + " picked up right fork: " + rightFork.getNumber()+", used: "+rightFork.isUsed());
                rightFork.setUsed(true);
                System.out.println(name + " starting to eat...");
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + " finished to eat...");
                rightFork.setUsed(false);
                leftFork.setUsed(false);
            }
        }
    }
}
