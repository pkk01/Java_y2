import java.util.Scanner;
import java.util.concurrent.Semaphore;

class H2O {
    private final Semaphore hydrogenSemaphore = new Semaphore(2);
    private final Semaphore oxygenSemaphore = new Semaphore(1);
    private int hydrogenCount = 0;

    public void releaseHydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSemaphore.acquire();
        synchronized (this) {
            hydrogenCount++;
            if (hydrogenCount == 2) {
                oxygenSemaphore.release();
            }
        }
        releaseHydrogen.run();
        synchronized (this) {
            if (hydrogenCount == 2) {
                hydrogenCount = 0;
                hydrogenSemaphore.release(2);
            }
        }
    }

    public void releaseOxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSemaphore.acquire();
        synchronized (this) {
            releaseOxygen.run();
            hydrogenCount = 0;
            hydrogenSemaphore.release(2);
        }
    }
}

public class WaterFormation {
    public static void main(String[] args) throws InterruptedException {
        H2O h2o = new H2O();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the water string (e.g., OOHHHH): ");
        String water = scanner.nextLine();

        Thread[] threads = new Thread[water.length()];

        for (int i = 0; i < water.length(); i++) {
            if (water.charAt(i) == 'H') {
                threads[i] = new Thread(() -> {
                    try {
                        h2o.releaseHydrogen(() -> System.out.print("H"));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            } else {
                threads[i] = new Thread(() -> {
                    try {
                        h2o.releaseOxygen(() -> System.out.print("O"));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
