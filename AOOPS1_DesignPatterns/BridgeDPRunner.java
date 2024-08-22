interface Bank {
    void show();
}

interface Account {
    void display();
}

class SBI implements Bank {
    Account acc;

    SBI(Account ac1) {
        acc = ac1;
    }

    public void show() {
        acc.display();
        System.out.print(" in SBI");
    }
}

class HDFC implements Bank {
    Account acc;

    HDFC(Account ac1) {
        acc = ac1;
    }

    public void show() {
        acc.display();
        System.out.print(" in HDFC");
    }
}

class CurAcc implements Account {
    public void display() {
        System.out.println("Current Account Opened Successfully");
    }
}

class SavAcc implements Account {
    public void display() {
        System.out.print("Savings Account Opened Successfully");
    }
}

public class BridgeDPRunner {
    public static void main(String[] args) {
        Account ac;
        Bank bk;
        ac = new SavAcc();
        bk = new SBI(ac);
        bk.show();
    }
}
