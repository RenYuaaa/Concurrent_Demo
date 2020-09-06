package sync;

/**
 * @author : renjiahui
 * @date : 2020/9/2 22:07
 * @desc : 同时访问同一个静态的synchronized和一个非静态的synchroinzed方法 --七种情况种的第6个
 *  这是因为他们锁指定的锁对象不是同一个锁
 */
public class SynchronizedStaticOrNormal8 implements Runnable {

    static SynchronizedStaticOrNormal8 instance = new SynchronizedStaticOrNormal8();

    public void run() {
        String thread0 = "Thread-0";
        if (Thread.currentThread().getName().equals(thread0)) {
            method1();
        } else {
            method2();
        }
    }

    public static synchronized void method1() {
        System.out.println("我是静态的加锁的方法1，我叫：" + Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public synchronized void method2() {
        System.out.println("我是非静态的加锁的方法2，我叫：" + Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);

        t1.start();
        t2.start();

        while (t1.isAlive() || t2.isAlive()) {

        }

        System.out.println("finished");
    }
}
