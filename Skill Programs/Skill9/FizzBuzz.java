import java.util.concurrent.Semaphore;

public class FizzBuzz {
    private int n;
    private Semaphore semFizz = new Semaphore(0);
    private Semaphore semBuzz = new Semaphore(0);
    private Semaphore semFizzBuzz = new Semaphore(0);
    private Semaphore semNumber = new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                semFizz.acquire();
                printFizz.run();
                semNumber.release();
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0 && i % 3 != 0) {
                semBuzz.acquire();
                printBuzz.run();
                semNumber.release();
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                semFizzBuzz.acquire();
                printFizzBuzz.run();
                semNumber.release();
            }
        }
    }

    public void number(Runnable printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                semNumber.acquire();
                printNumber.run();
                semNumber.release();
            } else if (i % 3 == 0 && i % 5 == 0) {
                semNumber.acquire();
                semFizzBuzz.release();
            } else if (i % 3 == 0) {
                semNumber.acquire();
                semFizz.release();
            } else if (i % 5 == 0) {
                semNumber.acquire();
                semBuzz.release();
            }
        }
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);

        Runnable printFizz = () -> System.out.println("fizz ");
        Runnable printBuzz = () -> System.out.println("buzz ");
        Runnable printFizzBuzz = () -> System.out.println("fizzbuzz ");
        Runnable printNumber = () -> System.out.println(Thread.currentThread().getName() + " ");

        Thread t1 = new Thread(() -> {
            try {
                fizzBuzz.fizz(printFizz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread A");
        Thread t2 = new Thread(() -> {
            try {
                fizzBuzz.buzz(printBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread B");
        Thread t3 = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(printFizzBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread C");
        Thread t4 = new Thread(() -> {
            try {
                fizzBuzz.number(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread D");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
