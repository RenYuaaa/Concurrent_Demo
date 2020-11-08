package executor;

import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author : renjiahui
 * @date : 2020/11/8 21:22
 * @desc : 固定线程数的线程池
 * 该线程池的弊端在于使用了LinkedBlockingQueue无界队列，会使任务无限的堆积，最后造成OOM异常
 */
public class FixedThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executorService = newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Task());
        }
    }
}

class Task implements Runnable {

    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
