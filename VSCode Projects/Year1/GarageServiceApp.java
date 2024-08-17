import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GarageServiceApp extends JFrame {
    private JComboBox<String> vehicleTypesComboBox;
    private JCheckBox premiumMembershipCheckBox;
    private JLabel costLabel;

    public GarageServiceApp() {
        setTitle("Garage Service Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        vehicleTypesComboBox = new JComboBox<>(new String[] { "2 Wheeler", "3 Wheeler", "4 Wheeler" });
        panel.add(vehicleTypesComboBox);
        premiumMembershipCheckBox = new JCheckBox("Premium Membership");
        panel.add(premiumMembershipCheckBox);
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateServiceCost();
            }
        });
        panel.add(calculateButton);
        costLabel = new JLabel("Service Cost: ");
        panel.add(costLabel);
        add(panel);
        setVisible(true);
    }

    private void calculateServiceCost() {
        String selectedVehicle = (String) vehicleTypesComboBox.getSelectedItem();
        boolean isPremiumMember = premiumMembershipCheckBox.isSelected();
        double cost;
        switch (selectedVehicle) {
            case "2 Wheeler":
                cost = 50;
                break;
            case "3 Wheeler":
                cost = 75;
                break;
            case "4 Wheeler":
                cost = 100;
                break;
            default:
                cost = 0;

        }
        if (isPremiumMember) {
            cost *= 0.9; // 10% discount for premium members
        }
        costLabel.setText("Service Cost: $" + String.format("%.2f", cost));
        // Store the cost in a file
        try (PrintWriter writer = new PrintWriter(new FileWriter("service_costs.txt", true))) {
            writer.println(
                    "Vehicle Type: " + selectedVehicle + ", Premium Member: " + isPremiumMember + ", Cost: " + cost);
            writer.flush();
            JOptionPane.showMessageDialog(this, "Service cost has been saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GarageServiceApp();
            }
        });
    }
}