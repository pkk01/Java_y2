import java.util.concurrunt.ArrayBlockingQueue;

// arrayBlockingQueue

class Producer implements Runnable {
	
	private final BlockingQueue <Integer> queue;
	
	public Producer (BlockingQueue <Integer> queue) {
		this.queue = queue;
	}
	
	@Override 
	public void run() {
		
		try {
		
				for (int i = 0; i < 5; i++) {
					System.out.println ("Producer produced: "+i);
					queue.put(i);
					Thread.sleep(1000);
				}
				
			} catch (InterreptedException e) {
				e.printStackTrace();
			}
	}
	
}

class Consumer implements Runnable {
	private final BlockingQueue<Integer> queue;
	
	public Consumer (BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	
	@Override 
	public void run() {
		try {
			while (true) {
				int item = queue.take();
				System.out.println("Consumed: "+item);
				Thread.sleep(1000);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

public class ArrayBlockingQueueMain2 {
	public static final int max = 5;
	public static void main (String args[]) {
		
		BlockingQueue<Integer> queue = new ArrayBlockingQueue <>(max);
		
		Producer produce = new Producer (queue);
		Consumer consume = new Consumer (queue);
		
		Thread producerThread = new Thread (produce , "ProducerThread");
		Thread consumerThread = new Thread (consume, "ConsumerThread");
		
		producerThread.start();
		consumerThread.start();
	}
}