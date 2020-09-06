package sync;

/**
 * @author : renjiahui
 * @date : 2020/9/1 20:09
 * @desc : Synchronized对象锁，代码块形式
 */
public class SynchronizedObjectCodeBlock2 implements Runnable{

    static SynchronizedObjectCodeBlock2 instance = new SynchronizedObjectCodeBlock2();

    /**
     * 定义两把锁对象，当使用两把不同的锁对象时，所得到的结果也是非常不相同的。
     */
    Object lock = new Object();

    Object lock1 = new Object();

    public void run() {

        //代码块形式的锁
        synchronized (this) {
            System.out.println("我是对象锁的代码块形式。我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " 运行结束");
        }

        /**
         * 使用的锁不同，返回的结果也不同
         */
        synchronized (lock) {
            System.out.println("我是lock。我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " lock部分运行结束");
        }

        synchronized (lock1) {
            System.out.println("我是lock1。我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " lock1运行结束");
        }

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
