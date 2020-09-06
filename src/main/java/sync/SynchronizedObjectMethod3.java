package sync;

/**
 * @author : renjiahui
 * @date : 2020/9/1 20:30
 * @desc : 两个线程同时访问一个对象的同步方法-- 七种情况中的第一种情况
 */
public class SynchronizedObjectMethod3 implements Runnable {

    static SynchronizedObjectMethod3 instance = new SynchronizedObjectMethod3();

    /**
     * 两个线程访问两个对象的同步方法，synchroinzed是不起作用的
     */
    static SynchronizedObjectMethod3 instance1 = new SynchronizedObjectMethod3();

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);

        t1.start();
        t2.start();

        while (t1.isAlive() || t2.isAlive()) {

        }

        System.out.println("finished");
    }

    public void run() {
        method();
    }

    /**
     * 方法锁，当前synchronized锁对象是this
     */
    public synchronized void method() {
        System.out.println("我是对象锁的方法修饰符形式，我叫：" + Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "运行结束");
    }
}
