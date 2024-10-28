import java.sql.SQLException;
import java.util.Scanner;

public class ProductMain {
    public static void main(String[] pk) {
        ProductManager manager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nE-Commerce Product Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Sell Product");
            System.out.println("3. Apply Discounts based on stock");
            System.out.println("4. Apply Festival Discount (70%)");
            System.out.println("5. Delete Out-of-Stock Products");
            System.out.println("6. Show Available Products");
            System.out.println("7 Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Product ID: ");
                        String productId = scanner.nextLine();
                        System.out.print("Enter Product Name: ");
                        String productName = scanner.nextLine();
                        System.out.print("Enter Price: ");
                        double price = scanner.nextDouble();
                        System.out.print("Enter Quantity: ");
                        int quantity = scanner.nextInt();
                        manager.addProduct(productId, productName, price, quantity);
                        System.out.println("Product added successfully.");
                        break;

                    case 2:
                        System.out.print("Enter Product ID: ");
                        String productIdToSell = scanner.nextLine();
                        System.out.print("Enter Quantity Sold: ");
                        int quantitySold = scanner.nextInt();
                        manager.sellProduct(productIdToSell, quantitySold);
                        System.out.println("Product quantity updated successfully.");
                        break;

                    case 3:
                        manager.applyStockDiscounts();
                        System.out.println("Discounts on stock applied successfully.");
                        break;

                    case 4:
                        manager.applyFestiveDiscounts();
                        System.out.println("Festive Discounts applied successfully.");
                        break;

                    case 5:
                        manager.deleteOutOfStockProducts();
                        System.out.println("Out-of-stock products deleted successfully.");
                        break;

                    case 6:
                        manager.showAllProducts();

                        break;
                    case 7:
                        exit = true;
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (SQLException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
