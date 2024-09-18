//class extending implementing Running interface

class MyThreads implements Runnable{

	@Override
	public void run () {
		for (int i = 0; i < 5; i++)
			System.out.println("Hello I am first Thread");
	}
}

// clientCode

public class ThreadRunnableMain {
	public static void main (String[] pk) {
	
		MyThreads thread = new MyThreads();
		
		// Thread inteface is used
		Thread realThread = new Thread(thread);

		//.start method is used to envoke .run method
		realThread.start();
	}
}