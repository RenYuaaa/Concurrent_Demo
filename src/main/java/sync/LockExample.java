package sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : renjiahui
 * @date : 2020/9/3 0:29
 * @desc : 展示Lock的方法
 */
public class LockExample {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        //获取锁
        lock.lock();
        try {
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            //释放锁
            lock.unlock();
        }


        //尝试获取锁
        lock.tryLock();

        try {
            //指定时间内拿不到锁就放弃
            lock.tryLock(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
