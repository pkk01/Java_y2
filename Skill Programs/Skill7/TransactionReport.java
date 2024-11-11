import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

 class Transaction {
    private double amount;
    private String category;

    public Transaction(double amount, String category) {
        this.amount = amount;
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }
}

public class TransactionReport {

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
            new Transaction(5000.0, "groceries"),
            new Transaction(8000.0, "utilities"),
            new Transaction(3000.0, "groceries"),
            new Transaction(10000.0, "entertainment"),
            new Transaction(6000.0, "utilities")
        );

        Map<String, Double> totalByCategory = transactions.stream()
            .collect(Collectors.groupingBy(
                Transaction::getCategory, 
                Collectors.summingDouble(t -> t.getAmount())
            ));

        totalByCategory.forEach((category, totalAmount) -> 
            System.out.println("Category: " + category + ", Total: ₹" + totalAmount));
    }
}
