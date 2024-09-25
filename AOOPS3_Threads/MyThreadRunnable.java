class Check {
    public void print() {
        for (int i = 0; i < 10; i++)
            System.out.println("Hi all");
    }
}

class MyThread implements Runnable {
    Check ch;

    public MyThread(Check ch) {
        this.ch = ch;
    }

    @Override
    public void run() {
        ch.print();
    }
}

public class MyThreadRunnable {
    public static void main(String[] args) {
        Check ch = new Check();
        MyThread mt = new MyThread(ch);
        Thread th = new Thread(mt);
        th.start();
    }
}
