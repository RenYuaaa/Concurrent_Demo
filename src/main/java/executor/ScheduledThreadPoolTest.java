package executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author : renjiahui
 * @date : 2020/11/8 22:08
 * @desc : 带有定时或周期的线程池
 */
public class ScheduledThreadPoolTest {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        //每隔5秒运行一次线程
        scheduledExecutorService.schedule(new Task(), 5, TimeUnit.SECONDS);

        //刚开始1秒运行，之后每隔3秒运行一次
        scheduledExecutorService.scheduleAtFixedRate(new Task(), 1, 3, TimeUnit.SECONDS);
    }
}
