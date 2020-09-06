package sync;

/**
 * @author : renjiahui
 * @date : 2020/9/2 23:27
 * @desc : 可重入粒度测试：调用父类的方法
 */
public class SynchronizedSuperClass {

    public synchronized void doSomething() {
        System.out.println("我是父类方法");
    }

}

class TestClass extends SynchronizedSuperClass {

    @Override
    public synchronized void  doSomething() {
        System.out.println("我是子类方法");
        super.doSomething();
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        testClass.doSomething();
    }
}
