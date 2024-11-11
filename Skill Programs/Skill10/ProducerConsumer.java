import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {
        int bufferSize = 3;
        int itemCount = 5;

        List<Integer> sharedBuffer = new ArrayList<>();
        Producer producer = new Producer(sharedBuffer, bufferSize, itemCount);
        Consumer consumer = new Consumer(sharedBuffer, itemCount);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
    }
}

class Producer implements Runnable {
    private final List<Integer> buffer;
    private final int maxSize;
    private final int totalItems;

    public Producer(List<Integer> buffer, int maxSize, int totalItems) {
        this.buffer = buffer;
        this.maxSize = maxSize;
        this.totalItems = totalItems;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= totalItems; i++) {
                synchronized (buffer) {

                    while (buffer.size() == maxSize) {
                        buffer.wait();
                    }

                    buffer.add(i);
                    System.out.println("Produced " + i);

                    buffer.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private final List<Integer> buffer;
    private final int totalItems;

    public Consumer(List<Integer> buffer, int totalItems) {
        this.buffer = buffer;
        this.totalItems = totalItems;
    }

    @Override
    public void run() {
        try {
            int consumedCount = 0;
            while (consumedCount < totalItems) {
                synchronized (buffer) {

                    while (buffer.isEmpty()) {
                        buffer.wait();
                    }

                    int data = buffer.remove(0);
                    System.out.println("Consumed " + data);
                    consumedCount++;

                    buffer.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
