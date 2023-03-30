package chapter01;

/**
 * 并发
 */
public class ThreadTest01 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 10; i ++)
                System.out.printf("%s-%02d\n", Thread.currentThread().getName(), i);
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 10; i ++)
                System.out.printf("%s-%02d\n", Thread.currentThread().getName(), i);
        });
        thread1.start();
        thread2.start();
    }
}
