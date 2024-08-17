interface PaymentProcessor {
    void processPayment(double amount);
}
//  adaptee class 1
class Paypal {
    void payment(double amount) {
        System.out.println("Withdrawl amount from Paypal: " + amount);
    }
}
// adaptee class 2
class Stripe {
    void payment(double amount) {
        System.out.println("Withdrawl amount from Stripe: " + amount);
    }
}
// adaptor class 1
class PaypalAdapter implements PaymentProcessor {
    Paypal pp = new Paypal();

    public void processPayment(double amount) {
        pp.payment(amount);
    }
}
//  adapter class 2
class StripeAdapter implements PaymentProcessor {
    Stripe s = new Stripe();

    public void processPayment(double amount) {
        s.payment(amount);
    }
}

public class Skill3_1 {
    public static void main(String[] args) {

        PaypalAdapter pa = new PaypalAdapter();
        StripeAdapter sa = new StripeAdapter();
        pa.processPayment(100);
        sa.processPayment(43.5);
    }
}
