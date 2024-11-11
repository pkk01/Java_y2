import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ProducerConsumer {
    private final Queue<Integer> buffer;
    private final int bufferSize;
    private final Semaphore empty;
    private final Semaphore full;
    private final Semaphore mutex;

    public ProducerConsumer(int size) {
        buffer = new LinkedList<>();
        bufferSize = size;
        empty = new Semaphore(size);
        full = new Semaphore(0);
        mutex = new Semaphore(1);
    }

    public void producer() throws InterruptedException {
        int item = 0;
        while (true) {
            empty.acquire();
            mutex.acquire();
            buffer.add(++item);
            System.out.println("Produced: " + item);
            mutex.release();
            full.release();
            Thread.sleep(100); 
        }
    }

    public void consumer() throws InterruptedException {
        while (true) {
            full.acquire();
            mutex.acquire();
            int item = buffer.poll();
            System.out.println("Consumed: " + item);
            mutex.release();
            empty.release();
            Thread.sleep(150); 
        }
    }

    public static void main(String[] args) {
        int bufferSize = 5; 
        ProducerConsumer pc = new ProducerConsumer(bufferSize);
        
        Thread producerThread = new Thread(() -> {
            try {
                pc.producer();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                pc.consumer();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
