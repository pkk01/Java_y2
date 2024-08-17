import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SimpleCalculator extends JFrame implements ActionListener {
    JTextField num1field, num2field, resultfield;
    JLabel num1label, num2label, resultlabel;
    JButton addButton, subButton, divButton, mulButton;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        num1field = new JTextField(10);
        num2field = new JTextField(10);
        resultfield = new JTextField(10);

        num1label = new JLabel("Enter 1st Number ");
        num2label = new JLabel("Enter 2nd Number ");
        resultlabel = new JLabel("Result ");

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("/");

        Container con = getContentPane();
        con.setLayout(new GridLayout(5, 3));

        con.add(num1field);
        con.add(num1label);
        con.add(num2field);
        con.add(num2label);
        con.add(resultfield);
        con.add(resultlabel);
        con.add(addButton);
        con.add(subButton);
        con.add(mulButton);
        con.add(divButton);

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addButton) {
            int num1 = Integer.parseInt(num1field.getText());
            int num2 = Integer.parseInt(num2field.getText());
            int result = num1 + num2;
            resultfield.setText(result + " ");
        }
        if (ae.getSource() == subButton) {
            int num1 = Integer.parseInt(num1field.getText());
            int num2 = Integer.parseInt(num2field.getText());
            int result = num1 - num2;
            resultfield.setText(result + " ");
        }
        if (ae.getSource() == mulButton) {
            int num1 = Integer.parseInt(num1field.getText());
            int num2 = Integer.parseInt(num2field.getText());
            int result = num1 * num2;
            resultfield.setText(result + " ");
        }
        if (ae.getSource() == divButton) {
            int num1 = Integer.parseInt(num1field.getText());
            int num2 = Integer.parseInt(num2field.getText());
            double result = num1 / num2;
            resultfield.setText(result + " ");
        }
    }

    public static void main(String[] args) {
        SimpleCalculator sc = new SimpleCalculator();
        sc.setVisible(true);
    }
}
