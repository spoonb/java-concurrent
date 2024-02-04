package trouble.junit.childthread;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * 现象：使用Junit的@Test测试带有子线程开启的方法时，子线程的任务被中断
 * 解决方案：使用CountDownLatch同步，使得主线程等待所有子线程执行完毕后结束
 */
public class ThreadTest {

    /**
     * 使用main方法测试子线程的开启，无问题
     * @param args 参数
     */
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();

        System.out.println("Main");
    }

    /**
     * 通过@Test测试子线程的开启，子线程被强制停止
     */
    @Test
    public void test01() {
        Thread thread = new Thread(new MyRunnable());
        thread.start();

        System.out.println("Main");
    }

    /**
     * 通过CountDownLatch强制让Test02的主线程等待其他子线程，无问题
     * @throws InterruptedException 拦截异常
     */
    @Test
    public void test02() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        Thread thread = new Thread(new MyRunnable());
        thread.start();

        System.out.println("Main");

        latch.await();
    }
}