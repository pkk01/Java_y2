import java.util.concurrent.Semaphore;

class SharedResource {

	private final Semaphore semaphore;
	
	public SharedResource (int permits) {
		this.semaphore = new Semaphore (permits);
	}
	
	public void accessResource (String workerName) {
	
		try {
			System.out.println (workerName + " is trying to access the resource");
			semaphore.acquire();
			System.out.println(workerName + " has acquired the resource");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println(workerName + " has released the resource");
			semaphore.release();
		}
	}
}

class Worker extends Thread {
	
	private final SharedResource resource;
	private final String name;
	
	public Worker (SharedResource resource, String name) {
		this.resource = resource;
		this.name = name;
	}
	
	@Override 
	public void run () {
		resource.accessResource(name);
	}
}

public class SemaphoreMain {
	public static void main (String pk[]) {
		SharedResource resource = new SharedResource (2); // limit is set to 2 threads at a time
		
		Worker worker1 = new Worker(resource, "Worker-1");
		Worker worker2 = new Worker(resource, "Worker-2");
		Worker worker3 = new Worker(resource, "Worker-3");
		Worker worker4 = new Worker(resource, "Worker-4");
		
		worker1.start();
		worker2.start();
		worker3.start();
		worker4.start();
	}
}