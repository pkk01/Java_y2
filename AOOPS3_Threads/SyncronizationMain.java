// program for Thread Syncronization
class Table {
	synchronized void printTable (int n) {
		for (int i = 1; i <= n; i++) {
			System.out.println ("Table of "+n+ " : "+n*i);
			try {
				Thread.sleep (100);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
class MyThread1 extends Thread {
	Table table;
	MyThread1 (Table table) {
		this.table = table;
	}
	public void run () {
		table.printTable(5);
	}
}

class MyThread2 extends Thread {
	Table table;
	MyThread2 (Table table) {
		this.table = table;
	}
	public void run () {
		table.printTable(10);
	}
}
public class SyncronizationMain {
	public static void main (String pk[]) {
		Table table = new  Table();
		MyThread1 myThread1 = new MyThread1(table);
		MyThread2 myThread2 = new MyThread2(table);
		
		myThread1.start();
		myThread2.start();
		
	}
}