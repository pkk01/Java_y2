import java.util.concurrent.*;

// ArrayBlockingQueue

public class ProducerConsumerArrayBlock {

	// threshold limit
	private static final int max = 5;
	
	private static ArrayBlockingQueue<Integer> abq = new ArrayBlockingQueue <>(max);
	
	public static void main (String pk[]) {
		Thread producer = new Thread (new Producer());
		Thread consumer = new Thread (new Consumer());
		
		producer.start();
		consumer.start();
		
		try {
			producer.join();
			consumer.join();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}
	
	static class Producer implements Runnable {
		
		public void run () {
			try {
				for (int i = 1; i <= 10; i++) {
					abq.put(i);
					
					System.out.println("Produced: "+i);
					Thread.sleep(500);
				}
			} catch (InterruptedException e) {
			
				Thread.currentThread().interrupt();
			}
		}
	}
	
	static class Consumer implements Runnable {
		
		public void run() {
			
			try {
				
				for (int i = 1; i <= 10; i++) {
					
					int val = abq.take();
					System.out.println("Consumed: "+val);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
			
				Thread.currentThread().interrupt();
			}
		}
	}
}