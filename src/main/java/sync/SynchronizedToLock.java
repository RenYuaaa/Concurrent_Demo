package sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : renjiahui
 * @date : 2020/9/2 23:50
 * @desc :
 */
public class SynchronizedToLock {

    Lock lock = new ReentrantLock();

    public synchronized void method1() {
        System.out.println("我是Synchronized形式的锁");
    }

    public void method2() {
        lock.lock();
        try {
            System.out.println("我是lock形式的锁");
        } finally {
            lock.unlock();
        }

    }


    public static void main(String[] args) {
        SynchronizedToLock synchronizedToLock = new SynchronizedToLock();
        synchronizedToLock.method1();
        synchronizedToLock.method2();
    }
}
