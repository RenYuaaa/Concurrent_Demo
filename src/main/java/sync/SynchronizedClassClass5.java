package sync;

/**
 * @author : renjiahui
 * @date : 2020/9/1 20:56
 * @desc :
 */
public class SynchronizedClassClass5 implements Runnable {
    static SynchronizedClassClass5 instance1 = new SynchronizedClassClass5();

    static SynchronizedClassClass5 instance2 = new SynchronizedClassClass5();

    public void run() {
        method();
    }

    private void method() {
        //此处如果放this，则锁不生效。因为：this指代当前类对象，比如：instance1进来，那么this指代的就是instance1的对象。但instance2进来，this指代的就是instance2的对象了。
        //此时锁指向了不同的对象，导致锁不生效了。--七种情况中的第二种
        synchronized (SynchronizedClassClass5.class) {
            System.out.println("我是类锁的第二种形式：synchronized（*.class）。我叫：" + Thread.currentThread().getName());

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "运行结束");
        }
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
