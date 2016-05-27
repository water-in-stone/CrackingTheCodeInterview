package other;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockedATM {
    private Lock lock;
    private int balance = 100;

    LockedATM(){
        lock = new ReentrantLock();
    }
    private int withDraw(int val){
        lock.lock();
        try {
            Thread.sleep(300);
            balance -= val;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        return balance;
    }

    private int deposit(int val){
        try {
            lock.lock();
            Thread.sleep(300);
            balance += val;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        return balance;
    }
}


