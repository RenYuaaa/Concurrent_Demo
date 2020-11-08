package executor;

import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author : renjiahui
 * @date : 2020/11/8 21:44
 * @desc : 固定线程线程池造成内存溢出的情况
 */
public class FixedThreadPoolOOM {

    private static final ExecutorService executorService = newFixedThreadPool(1);

    public static void main(String[] args) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            executorService.execute(new SubThread());
        }
    }
}

class SubThread implements Runnable {

    public void run() {
        try {
            Thread.sleep(1000000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
