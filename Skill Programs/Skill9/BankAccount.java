public class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ", Balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ", Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + " but insufficient balance.");
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Runnable depositTask = () -> {
            for (int i = 0; i < 5; i++) {
                account.deposit(200);
                try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        };

        Runnable withdrawTask = () -> {
            for (int i = 0; i < 5; i++) {
                account.withdraw(300);
                try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        };

        Thread t1 = new Thread(depositTask, "Thread 1");
        Thread t2 = new Thread(withdrawTask, "Thread 2");
        Thread t3 = new Thread(depositTask, "Thread 3");
        Thread t4 = new Thread(withdrawTask, "Thread 4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

