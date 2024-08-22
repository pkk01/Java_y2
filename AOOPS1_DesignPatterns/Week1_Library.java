class Library {
    private static String itemName;
    private static int itemNum;
    private static int price;

    public Library(String itemName, int itemNum, int price) {
        this.itemName = itemName;
        this.itemNum = itemNum;
        this.price = price;
    }

    void display() {
        System.out.println("Item name: " + itemName);
        System.out.println("Item number: " + itemNum);
        System.out.println("Item price: " + price);
    }
}

class Book extends Library {
    String AuthorName;

    public Book(String itemName, int itemNum, int price, String AuthorName) {
        super(itemName, itemNum, price);
        // AuthorName = a1;
        this.AuthorName = AuthorName;
    }

    void details() {
        super.display();
        System.out.println("Auther Name: " + AuthorName);

    }

}

class Magzines extends Library {
    String frequency;

    public Magzines(String itemName, int itemNum, int price, String frequency) {
        super(itemName, itemNum, price);
        this.frequency = frequency;
    }

    void details() {
        super.display();
        System.out.println("frequency: " + frequency);
    }
}

class DVD extends Library {
    int disksize;

    public DVD(String itemName, int itemNum, int price, int disksize) {
        super(itemName, itemNum, price);
        this.disksize = disksize;
    }

    void details() {
        super.display();
        System.out.println("disk size: " + disksize + "MB");
    }

}

public class Week1_Library {
    public static void main(String[] args) {
        Book b = new Book("test", 12, 12, "Ravindra nath tagore");
        b.details();
        System.out.println();
        Magzines m = new Magzines("Magzine name", 102, 300, "Frotnite");
        m.details();
        System.out.println();
        DVD d = new DVD("Intel", 3050, 5000, 500);
        d.details();

    }
}
