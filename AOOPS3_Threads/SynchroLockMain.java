// program for locking in threads
class SyncExample {
	private int counter = 0;
	public synchronized void increment () {
	//public void increment () {
		counter++;
		System.out.println(Thread.currentThread().getName()+" Counter Incremented to: "+counter);
	}
	public int getCounter() {
		return counter;
	}
} 

class Worker extends Thread {
	private final SyncExample syncExample;
	
	public Worker(SyncExample syncExample) {
		this.syncExample = syncExample;
	}
	
	@Override 
	public void run () {
		for (int i = 0; i < 5; i++) {
			syncExample.increment();
			try {
				// while current thread is in sleep next thread will access the resource
				Thread.sleep(1000);
			} catch(Exception e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}

public class SynchroLockMain {
	public static void main (String[] pk) {
		SyncExample syncExample = new SyncExample();
		Worker worker1 = new Worker(syncExample);
		Worker worker2 = new Worker(syncExample);
		Worker worker3 = new Worker(syncExample);
		
		worker1.start();
		worker2.start();
		worker3.start();
		
		try {
			worker1.join();
			worker2.join();
			worker3.join();
		} catch (InterruptedException e) {
			
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		
		System.out.println("Final Counter value: "+syncExample.getCounter());
	}
}