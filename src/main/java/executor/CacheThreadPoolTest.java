package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : renjiahui
 * @date : 2020/11/8 22:02
 * @desc : 带有缓存的线程池
 * 这种线程池的弊端在于corePoolSize为Integer.MAX_VALUE，会造成OOM异常
 */
public class CacheThreadPoolTest {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Task());
        }
    }
}
