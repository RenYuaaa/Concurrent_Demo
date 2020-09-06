package sync;

/**
 * @author : renjiahui
 * @date : 2020/9/2 23:21
 * @desc : 可重入粒度测试：调用类内另外的方法
 */
public class SynchronizedOtherMethod11 {

    public synchronized void method1() {
        System.out.println("我是method1");

        method2();
    }

    private synchronized void method2() {
        System.out.println("我是method2");
    }

    public static void main(String[] args) {
        SynchronizedOtherMethod11 synchronizedOtherMethod = new SynchronizedOtherMethod11();

        synchronizedOtherMethod.method1();
    }
}
