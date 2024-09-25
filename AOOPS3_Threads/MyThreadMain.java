class Check {
    public void print() {
        for (int i = 0; i < 10; i++)
            System.out.println("Hi all");
    }
}

class MyThread extends Thread {
    Check ch;

    public MyThread(Check ch) {
        this.ch = ch;
    }

    public void run() {
        ch.print();
    }
}

public class MyThreadMain {

    public static void main(String[] args) {
        Check ch = new Check();
        MyThread mt = new MyThread(ch);
        mt.start();
    }
}