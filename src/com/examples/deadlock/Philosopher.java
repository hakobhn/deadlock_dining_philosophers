package com.examples.deadlock;

public abstract class Philosopher extends Thread {

    protected static final int sleep = 0;

    protected String name; // Philosopher's name

    public abstract void eat();

    public void think() {
        System.out.println(name + " start to thinking...");
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " end to thinking...");
    }

    @Override
    public void run() {
        while (true) {
            eat();
            think();
        }
    }
}
