// ReadWrite Lock
import java.util.concurrent.locks.ReentrantReadWriteLock;

class ReadWriteLock {
	
	//ReadWrite Lock
	private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	//Read Lock
	private final ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
	//Write Lock
	private final ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
	
	private int counter = 0;
	
	public void increment () {
		writeLock.lock();
		try {
			counter++;
			System.out.println(Thread.currentThread().getName() + " incremented counter to : "+counter);
		}
		finally {
			writeLock.unlock();
		}
	}
	public void read() {
		readLock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " read counter: " + counter);
		}
		finally {
			readLock.unlock();
		}
	}
	public int returnCounter () {
		return counter;
	}
}

class Worker extends Thread {
	private final ReadWriteLock rwl;
	private final boolean isWriter;
	
	public Worker (ReadWriteLock rwl, boolean isWriter) {
		this.rwl = rwl;
		this.isWriter = isWriter;
	}
	
	@Override 
	public void run() {
		for (int i = 0; i < 5; i++) {
			if (isWriter) {
				rwl.increment();
			} else {
				rwl.read();
			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
public class ReentrantReadWriteLockMain {
	public static void main (String[] pk) {
		ReadWriteLock rwl = new ReadWriteLock();
		Worker w = new Worker(rwl,true);
		Worker r1 = new Worker(rwl,false);
		Worker r2 = new Worker(rwl,false);
		
		w.start();
		r1.start();
		r2.start();
		
		try {
			w.join();
			r1.join();
			r2.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Final thread count: "+rwl.returnCounter());
	}
}