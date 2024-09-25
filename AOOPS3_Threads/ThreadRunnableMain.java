//class extending implementing Running interface

class MyThreads1 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 50; i++)
			System.out.println("Hello I am first Thread");
	}
}

class MyThreads2 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 50; i++)
			System.out.println("Hello I am second Thread");
	}
}

// clientCode

public class ThreadRunnableMain {
	public static void main(String[] pk) {

		MyThreads1 thread1 = new MyThreads1();
		MyThreads2 thread2 = new MyThreads2();

		// Thread inteface is used
		Thread realThread1 = new Thread(thread1);
		Thread realThread2 = new Thread(thread2);

		// .start method is used to envoke .run method
		realThread1.start();
		realThread2.start();
	}
}