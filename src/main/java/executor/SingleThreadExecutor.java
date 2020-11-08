package executor;

import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newSingleThreadExecutor;

/**
 * @author : renjiahui
 * @date : 2020/11/8 21:52
 * @desc : 单一线程的线程池
 * 这种线程池的弊端是：使用了LinkedBlockingQueue无界队列，会使任务无限的堆积，最后造成OOM异常
 */
public class SingleThreadExecutor {

    public static void main(String[] args) {
        ExecutorService executorService = newSingleThreadExecutor();

        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Task());
        }
    }
}
