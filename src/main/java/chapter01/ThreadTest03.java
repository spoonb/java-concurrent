package chapter01;

/**
 * wait
 */
public class ThreadTest03 {

    private static Object lock = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i <= 10; i++) {
                    System.out.printf("%s-%02d\n", Thread.currentThread().getName(), i);
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i <= 10; i++) {
                    System.out.printf("%s-%02d\n", Thread.currentThread().getName(), i);
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
//                lock.notify();
            }
        });
        thread1.start();
        thread2.start();
    }
}
