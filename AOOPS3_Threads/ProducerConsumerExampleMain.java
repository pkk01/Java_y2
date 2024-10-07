class Resource {
	private int item;
	private boolean isAvailable = false;
	public synchronized void produce(int val) throws  InterruptedException{
		while (isAvailable) {
			wait(); // wait until item is consumed
		}
		item = val;
		isAvailable = true;
		System.out.println("Produced an Item: " + item);
		notify();
	}
	public synchronized int consume() throws InterruptedException {
		while (!isAvailable) {
			wait(); // wait until item is produced
		}
		isAvailable = false;
		System.out.println("Item is Consumeed: "+item);
		notify();
		return item;
	}
}

class Producer extends Thread {
	private Resource resource;
	public Producer (Resource resource) {
		this.resource = resource;
	}
	public void run () {
		try {
			for (int i = 1; i <= 5; i++) {
				resource.produce(i);
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}


class Consumer extends Thread {
	private Resource resource;
	public Consumer (Resource resource) {
		this.resource = resource;
	}
	public void run () {
		try {
			for (int i = 1; i <= 5; i++) {
				resource.consume();
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class ProducerConsumerExampleMain {
	public static void main (String pk[]) {
		
		Resource rs = new Resource ();
		Producer p = new Producer(rs);
		Consumer c = new Consumer(rs);
		
		p.start();
		c.start();
	}
}