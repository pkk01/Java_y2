// java program to use sleep () method in Thread

class Check {
	public void display() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("Hi all");
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}

class MyThread implements Runnable {

	Check ch;

	MyThread(Check ch) {
		this.ch = ch;
	}

	@Override
	public void run() {
		ch.display();
	}
}

public class ThreadSleepMain {
	public static void main(String pk[]) {
		Check check = new Check();
		MyThread myThread = new MyThread(check);
		Thread thread = new Thread(myThread);
		System.out.println("is Thread alive?: " + thread.isAlive());
		thread.start();
		System.out.println("is Thread alive?: " + thread.isAlive());
		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("is Thread alive?: " + thread.isAlive());
	}
}
