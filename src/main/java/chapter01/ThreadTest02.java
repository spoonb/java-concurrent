package chapter01;

public class ThreadTest02 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 10; i ++) {
                System.out.printf("%s-%02d\n", Thread.currentThread().getName(), i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2 = new Thread(() -> {
           for (int i = 1; i <= 10 ; i ++) {
               System.out.printf("%s-%02d\n", Thread.currentThread().getName(), i);
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });
        thread1.start();
        thread2.start();
    }
}
