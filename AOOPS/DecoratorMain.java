import java.util.*;

interface Coffee {
    String getDes();

    double getCost();
}

class ColdCoffee implements Coffee {
    public String getDes() {
        return "Cold Coffee";
    }

    public double getCost() {
        return 200.75;
    }
}

abstract class CoffeeDecor implements Coffee {
    protected Coffee coffee;

    public CoffeeDecor(Coffee coffee) {
        this.coffee = coffee;

    }

    public double getCost() {
        return coffee.getCost();
    }

    public String getDes() {
        return coffee.getDes(); // note
    }
}

class CreamDecor extends CoffeeDecor {
    public CreamDecor(Coffee coffee) {
        super(coffee);
    }

    public String getDes() {
        return super.getDes() + ", Cream";
    }

    public double getCost() {
        return super.getCost() + 50.00;
    }
}

class SugarDecor extends CoffeeDecor {
    public SugarDecor(Coffee coffee) {
        super(coffee);
    }

    public String getDes() {
        return super.getDes() + ", Suger";
    }

    public double getCost() {
        return super.getCost() + 5.00;
    }
}

public class DecoratorMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Coffee co = new ColdCoffee();
        boolean display = true;
        while (display) {
            System.out.println("Default Coffee: " + co.getDes());
            System.out.println("Coffee cost: " + co.getCost());
            System.out.println("Add ons");
            System.out.println("1. Cream");
            System.out.println("2. Sugar");
            System.out.println("3. Finish and Checkout");
            System.out.println("4. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    co = new CreamDecor(co);
                    break;
                case 2:
                    co = new SugarDecor(co);
                    break;

                case 3:
                    System.out.println("Final Coffee: " + co.getDes());
                    System.out.println("Final Cost: " + co.getCost());
                    System.out.println("Thanks for visiting");
                    break;
                case 4:
                    System.out.println("Exit - Please visit again");
                    display = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        sc.close();
    }

}
