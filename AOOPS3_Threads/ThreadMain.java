//class extending Thread Class

class MyThreads1 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 50; i++)
			System.out.println("Hello I am first Thread");
	}
}

class MyThreads2 extends Thread {
	public void run() {
		for (int i = 0; i < 50; i++)
			System.out.println("This is second thread");
	}
}
// clientCode

public class ThreadMain {
	public static void main(String[] pk) {

		MyThreads1 thread1 = new MyThreads1();
		MyThreads2 thread2 = new MyThreads2();

		// .start method is used to invoke .run method
		thread1.start();
		thread2.start();
	}
}