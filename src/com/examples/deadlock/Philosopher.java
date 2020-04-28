package com.examples.deadlock;

public abstract class Philosopher extends Thread {

    protected static final int sleep = 0;

    protected String name; // Philosopher's name

    public abstract void eat();

    /**
     * Process of thinking
     */
    public void think() {
        System.out.println(name + " starting to think...");
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " finished to think...");
    }

    /**
     * Sequentially eating and thinking
     */
    @Override
    public void run() {
        while (true) {
            eat();
            think();
        }
    }
}
