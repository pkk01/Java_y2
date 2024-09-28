// explicit lock using lock and reentrant lock

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class ReentrantLockExample {
	
	private final Lock rlock = new ReentrantLock();
	private int counter = 0;
	
	public void increment () {
		rlock.lock();
		
		try {
			counter++;
			System.out.println(Thread.currentThread().getName()+" Counter Incremented to: "+counter);
		}
		
		finally {
			rlock.unlock();
		}
	}
	public int getCounter() {
		return counter;
	}
} 

class Worker extends Thread {
	private final ReentrantLockExample reExample;
	
	public Worker(ReentrantLockExample reExample) {
		this.reExample = reExample;
	}
	
	@Override 
	public void run () {
		for (int i = 0; i < 5; i++) {
			reExample.increment();
			try {
				// while current thread is in sleep next thread will access the resource
				Thread.sleep(1000);
			} catch(Exception e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}

public class ReentrantLockMain {
	public static void main (String[] pk) {
		ReentrantLockExample retExample = new ReentrantLockExample();
		Worker worker1 = new Worker(retExample);
		Worker worker2 = new Worker(retExample);
		Worker worker3 = new Worker(retExample);
		
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
		System.out.println("Final Counter value: "+retExample.getCounter());
	}
}