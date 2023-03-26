package chapter01;

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
    }
}
