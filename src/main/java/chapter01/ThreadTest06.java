package chapter01;

<<<<<<< HEAD
/**
 * 死锁
 */
public class ThreadTest06 {

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
=======
public class ThreadTest06 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            while (!Thread.interrupted()) {
                System.out.println(Thread.currentThread().getName());
            }
            System.out.printf("%s's interrupt is %s\n", Thread.currentThread().getName(), Thread.currentThread().isInterrupted());
            System.out.printf("%s is shutdown!\n", Thread.currentThread().getName());
        });
        thread1.start();
        Thread.sleep(1000);
        thread1.interrupt();
        System.out.printf("%s is shutdown!\n", Thread.currentThread().getName());
>>>>>>> 14debf6094307c1d56b1114bd2123a3a0f370423
    }
}
