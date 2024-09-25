class MyThread extends Thread {
    public void run() {
        try {
            System.out.println("Thread is running");
            Thread.sleep(10000);
            System.out.println("Thread is awake");
        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}

public class ThreadStatesMain {
    public static void main(String[] pk) throws InterruptedException {
        MyThread my = new MyThread();
        my.start();
        my.join();
        System.out.println("Thread executed successfully");

    }
}

