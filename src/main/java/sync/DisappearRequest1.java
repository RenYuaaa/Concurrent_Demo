package sync;

/**
 * @author : renjiahui
 * @date : 2020/9/1 19:57
 * @desc : 消失的请求，两个线程同时进行i++，最后结果会比预计的少
 *
 * 结果比预计少的原因是：
 *  count++，看上去只有一个操作，实际上包含了三个动作：
 *      1、读取count
 *      2、将count加1
 *      3、将count的值写入到内存中
 *
 *      这三个操作如果不按原子性执行的话，那么就会产生并发问题
 */
public class DisappearRequest1 implements Runnable {
    static DisappearRequest1 instance = new DisappearRequest1();

    static int i = 0;


    /**
     * 不使用并发手段的后果
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(i);
    }


//    public void run() {
//        for (int j = 0; j < 1000; j++) {
//            i++;
//        }
//    }

    /**
     * synchronized修饰方法
     */
//    public synchronized void run() {
//        for (int j = 0; j < 1000; j++) {
//            i++;
//        }
//    }


    public void run() {
        //同步代码块形式
        synchronized (this) {
            for (int j = 0; j < 1000; j++) {
                i++;
            }
        }

    }
}
