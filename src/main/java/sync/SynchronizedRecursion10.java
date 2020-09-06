package sync;

/**
 * @author : renjiahui
 * @date : 2020/9/2 23:11
 * @desc : 可重入粒度测试：递归调用本方法
 *          同一个方法是可重入的，递归调用即可证明
 */
public class SynchronizedRecursion10 {

    int i = 0;


    public static void main(String[] args) {
        SynchronizedRecursion10 synchronizedRecursion = new SynchronizedRecursion10();

        synchronizedRecursion.method1();
    }

    private synchronized void method1() {
        System.out.println("这是method1，i = " + i);

        if (i == 0) {
            i++;
            method1();
        }
    }
}