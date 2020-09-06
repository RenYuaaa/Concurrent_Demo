package sync;

/**
 * @author : renjiahui
 * @date : 2020/9/1 20:47
 * @desc : 类锁：加在static上，两个线程访问的是Synchronized的静态方法-- 七种情况中的第三种
 *
 * 类锁的本质：所谓的类锁，不过是Class对象的锁而已
 * 用法和效果：类锁只能在同一时刻被一个对象拥有
 */
public class SynchronizedClassStatic4 implements Runnable {
    static SynchronizedClassStatic4 instance1 = new SynchronizedClassStatic4();

    static SynchronizedClassStatic4 instance2 = new SynchronizedClassStatic4();


    public void run() {
        method();
    }

    public static synchronized void method() {
        System.out.println("我是类锁的第一种形式：static形式。我叫：" + Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);

        t1.start();
        t2.start();

        while (t1.isAlive() || t2.isAlive()) {

        }

        System.out.println("finished");
    }
}
