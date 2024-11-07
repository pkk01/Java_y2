// ThreadPool In java
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

class Task implements Runnable {
	String task;
	
	public Task (String task) {
		this.task = task;
	}
	
	@Override 
	public void run() {
		try {
			
			for (int i = 0; i < 5; i++) {
				//System.out.println(" Thread -> ");
				System.out.println (task + " -> "+Thread.currentThread().getName());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class ThreadPoolMain {
	public static void main (String pk[]) {

		ExecutorService executor = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			Task task = new Task("thread "+i);
			executor.execute(task);
		}
		executor.shutdown();
	}
}