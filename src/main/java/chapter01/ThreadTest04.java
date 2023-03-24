package chapter01;

public class ThreadTest04 {

    private static Object lock = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i <= 10; i++) {
                    System.out.printf("%s-%02d\n", Thread.currentThread().getName(), i);
                    lock.notify();
//                    System.out.printf("%s-%s\n", Thread.currentThread().getName(), Thread.currentThread().getState());
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i <= 10; i++) {
                    System.out.printf("%s-%02d\n", Thread.currentThread().getName(), i);
                    lock.notify();
//                    System.out.printf("%s-%s\n", Thread.currentThread().getName(), Thread.currentThread().getState());
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
