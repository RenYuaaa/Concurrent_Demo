package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author : renjiahui
 * @date : 2020/11/8 22:30
 * @desc : 停止线程池，shutdown方法--禁止新任务加入，原本线程池中的任务不受影响
 */
public class ShutDown {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new ShutDownTask());
        }

        Thread.sleep(1500);
        //线程池是否已经进入停止状态
        System.out.println(executorService.isShutdown());

        //shutdown方法--禁止新任务加入，原本线程池中的任务不受影响
        executorService.shutdown();
//        executorService.execute(new ShutDownTask());

        //线程池是否已经进入停止状态
        System.out.println(executorService.isShutdown());

        //判断线程池是否完全停止，包括队列中的任务
        System.out.println(executorService.isTerminated());

        Thread.sleep(10000);
        System.out.println(executorService.isTerminated());

        //在指定时间内线程池是否完全运行完毕
        executorService.awaitTermination(7L, TimeUnit.SECONDS);

        //直接停止线程池，队列中的任务直接返回结果（抛异常）
        executorService.shutdownNow();
    }
}

class ShutDownTask implements Runnable {

    public void run() {
        try {
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
