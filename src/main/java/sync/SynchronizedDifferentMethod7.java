package sync;

/**
 * @author : renjiahui
 * @date : 2020/9/2 22:02
 * @desc : 同时访问一个类的不同的普通同步方法: 两个synchronized都生效 -- 七种情况中的第5种
 */
public class SynchronizedDifferentMethod7 implements Runnable {

    static SynchronizedDifferentMethod7 instance = new SynchronizedDifferentMethod7();

    public void run() {
        String thread0 = "Thread-0";
        if (Thread.currentThread().getName().equals(thread0)) {
            method1();
        } else {
            method2();
        }
    }

    public synchronized void method1() {
        System.out.println("我是加锁的方法1，我叫：" + Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public synchronized void method2() {
        System.out.println("我是加锁的方法2，我叫：" + Thread.currentThread().getName());

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
