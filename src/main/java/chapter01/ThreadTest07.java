package chapter01;

/**
 * 死锁
 */
public class ThreadTest07 {

    private static Object lockA = new Object();
    private static Object lockB = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            while (true) {
                synchronized (lockA) {
                    System.out.printf("%s -> get lockA\n", Thread.currentThread().getName());
                    synchronized (lockB) {
                        System.out.println("get lockB");
                    }
                    System.out.println("release lockB");
                }
                System.out.println("release lockA");
            }
        });
        Thread threadB = new Thread(() -> {
            while (true) {
                synchronized (lockB) {
                    System.out.printf("%s -> get lockB\n", Thread.currentThread().getName());
                    synchronized (lockA) {
                        System.out.println("get lockA");
                    }
                    System.out.println("release lockA");
                }
                System.out.println("release lockB");
            }
        });
        threadA.start();
        threadB.start();
    }
}
