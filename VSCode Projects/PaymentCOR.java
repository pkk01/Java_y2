abstract class PaymentHandler {
    protected PaymentHandler next;

    public void setNext(PaymentHandler next) {
        this.next = next;
    }

    abstract void handlePayment(double amount);
}

class BankPaymentHandler extends PaymentHandler {
    void handlePayment(double amount) {
        if (amount <= 500) {
            System.out.println("Paid using Bank account: $" + amount);
        } else if (next != null) {
            next.handlePayment(amount);
        }
    }
}

class CreditCardHandler extends PaymentHandler {
    void handlePayment(double amount) {
        if (amount > 500 && amount <= 1000) {
            System.out.println("Paid using Credit Card: $" + amount);
        } else if (next != null) {
            next.handlePayment(amount);
        }
    }
}

class PayPalHandler extends PaymentHandler {
    void handlePayment(double amount) {
        if (amount > 1000) {
            System.out.println("Paid using PayPal: $" + amount);
        } else if (next != null) {
            next.handlePayment(amount);
        }
    }
}

class PaymentHandlerChain {
    // Static factory method to build and return the chain of handlers
    public static PaymentHandler paymentChain() {
        PaymentHandler bankHandler = new BankPaymentHandler();
        PaymentHandler creditCardHandler = new CreditCardHandler();
        PaymentHandler payPalHandler = new PayPalHandler();

        // Link the handlers
        bankHandler.setNext(creditCardHandler);
        creditCardHandler.setNext(payPalHandler);

        return bankHandler; // Return the start of the chain
    }
}

public class PaymentCOR {
    public static void main(String[] args) {
        // Get the start of the payment handler chain
        PaymentHandler paymentHandler = PaymentHandlerChain.paymentChain();

        // Process payments through the chain
        paymentHandler.handlePayment(20);
        paymentHandler.handlePayment(700);
        paymentHandler.handlePayment(1500);
    }
}
