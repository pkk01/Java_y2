import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

    public static void main(String[] args) {
        int numberOfPhilosophers = 5;
        Philosopher[] philosophers = new Philosopher[numberOfPhilosophers];
        Fork[] forks = new Fork[numberOfPhilosophers];

        for (int i = 0; i < numberOfPhilosophers; i++) {
            forks[i] = new Fork(i);
        }

        for (int i = 0; i < numberOfPhilosophers; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % numberOfPhilosophers];

            if (i == numberOfPhilosophers - 1) {

                philosophers[i] = new Philosopher(i, rightFork, leftFork);
            } else {
                philosophers[i] = new Philosopher(i, leftFork, rightFork);
            }

            new Thread(philosophers[i], "Philosopher " + (i + 1)).start();
        }
    }
}

class Fork {
    private final int id;
    private final Lock lock = new ReentrantLock();

    public Fork(int id) {
        this.id = id;
    }

    public boolean pickUp() {
        return lock.tryLock();
    }

    public void putDown() {
        lock.unlock();
    }

    @Override
    public String toString() {
        return "Fork " + id;
    }
}

class Philosopher implements Runnable {
    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void think() throws InterruptedException {
        System.out.println("Philosopher P" + (id + 1) + " is thinking");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void eat() throws InterruptedException {
        System.out.println("Philosopher P" + (id + 1) + " is eating");
        Thread.sleep((long) (Math.random() * 1000));
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();

                System.out.println("Philosopher P" + (id + 1) + " is hungry");

                if (leftFork.pickUp()) {
                    System.out.println("Philosopher P" + (id + 1) + " picked up " + leftFork);

                    if (rightFork.pickUp()) {
                        System.out.println("Philosopher P" + (id + 1) + " picked up " + rightFork);

                        eat();

                        rightFork.putDown();
                        System.out.println("Philosopher P" + (id + 1) + " put down " + rightFork);
                    }

                    leftFork.putDown();
                    System.out.println("Philosopher P" + (id + 1) + " put down " + leftFork);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
