package trouble.junit.childthread;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i ++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
