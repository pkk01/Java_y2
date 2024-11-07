class Check {
	public void print (String x) {
		try {
			for (int i = 1; i <= 10; i++) {
				System.out.println("Hi I am Thread: "+x);
				Thread.sleep(1000);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

class PriorityThread extends Thread {
	Check ch;
	String tno;
	PriorityThread(Check ch, String tno) {
		this.ch = ch;
		this.tno = tno;
	}
	public void run() {
		ch.print(tno);
	}
}

public class ThreadPriorityMain {
	public static void main (String pk[]) {
		Check cc = new Check();
		PriorityThread pt1 = new PriorityThread(cc, "Thread1");
		PriorityThread pt2 = new PriorityThread(cc, "Thread2");
					
		// high priority 
					
		pt1.setPriority(2);
		pt2.setPriority(2);
		System.out.println(" Thread1 priority: "+pt1.getPriority());
		System.out.println(" Thread2 priority: "+pt2.getPriority());
					
		pt1.start();
		pt2.start();
					
	}				
}					