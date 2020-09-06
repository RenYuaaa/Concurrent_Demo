package sync;

/**
 * @author : renjiahui
 * @date : 2020/9/2 22:13
 * @desc : 方法抛出异常后，会释放锁。展示不抛出异常前和抛出异常后的对比
 *         一旦抛出了异常，第二个线程会立刻进入同步方法。意味着锁已经释放。
 *         七种情况中的第7种
 */
public class SynchronizedException8 implements Runnable {
    static SynchronizedException8 instance = new SynchronizedException8();

    public void run() {
        String thread0 = "Thread-0";
        if (Thread.currentThread().getName().equals(thread0)) {
            method1();
        } else {
            method2();
        }
    }

//    public synchronized void method1() {
//        System.out.println("我是加锁的方法1，我叫：" + Thread.currentThread().getName());
//
//        try {
//            Thread.sleep(3000);
//
//            throw new Exception();
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(Thread.currentThread().getName() + "运行结束");
//    }

    public synchronized void method1() {
        System.out.println("我是加锁的方法1，我叫：" + Thread.currentThread().getName());

        try {
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        throw new RuntimeException();

//        System.out.println(Thread.currentThread().getName() + "运行结束");
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
