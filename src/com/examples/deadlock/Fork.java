package com.examples.deadlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Fork in standard synchronization implementation is used as simple objects
 * and do not need to extend Lock class. number and isUsed fields just added
 * for demonstration purpose.
 */
public class Fork extends ReentrantLock {
    private int number;
    private boolean isUsed;

    public Fork(int number, boolean isUsed) {
        super();
        this.number = number;
        this.isUsed = isUsed;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }
}
