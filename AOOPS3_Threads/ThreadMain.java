//class extending Thread Class

class MyThreads extends Thread {

	@Override
	public void run () {
		for (int i = 0; i < 5; i++)
			System.out.println("Hello I am first Thread");
	}
}

// clientCode

public class ThreadMain {
	public static void main (String[] pk) {
	
		MyThreads thread = new MyThreads();

		//.start method is used to envoke .run method
		thread.start();
	}
}