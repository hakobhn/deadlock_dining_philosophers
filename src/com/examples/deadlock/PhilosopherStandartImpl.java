package com.examples.deadlock;

public class PhilosopherStandartImpl extends Philosopher {

    private Fork leftFork;
    private Fork rightFork;

    public PhilosopherStandartImpl(Fork leftFork, Fork rightFork, String name) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.name = name;
    }

    @Override
    public void eat() {
        synchronized (leftFork) {
            System.out.println(name + " picked up left fork: " + leftFork.getNumber()+", used: "+leftFork.isUsed());
            leftFork.setUsed(true);
            synchronized (rightFork) {
                System.out.println(name + " picked up right fork: " + rightFork.getNumber()+", used: "+rightFork.isUsed());
                rightFork.setUsed(true);
                System.out.println(name + " start to eating...");
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + " end to eating...");
                leftFork.setUsed(false);
                rightFork.setUsed(false);
            }
        }
    }
}
