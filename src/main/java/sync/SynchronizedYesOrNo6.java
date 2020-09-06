package sync;

/**
 * @author : renjiahui
 * @date : 2020/9/2 21:55
 * @desc : 同时访问同步方法和非同步方法: 非同步方法不受到影响-- 七种情况中的第四种
 */
public class SynchronizedYesOrNo6 implements Runnable {

    static SynchronizedYesOrNo6 instance = new SynchronizedYesOrNo6();

    public void run() {
        String thread0 = "Thread-0";
        if (Thread.currentThread().getName().equals(thread0)) {
            method1();
        } else {
            method2();
        }
    }

    public synchronized void method1() {
        System.out.println("我是加锁的方法，我叫：" + Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public void method2() {
        System.out.println("我是没有加锁的方法，我叫：" + Thread.currentThread().getName());

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
