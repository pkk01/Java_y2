import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.*;

import javax.swing.*;

public class StudentApplicationForm extends JFrame implements ActionListener {
    JTextField nameTextField, ageTextField;
    JLabel nameLabel, ageJLabel, genderLabel, branchJLabel;
    JButton submitButton;
    JComboBox genderBox, branchBox;
    String[] gender = { "Male", "Female", "Other" };
    String[] branch = { "CSE", "CSIT", "AIDS", "BCA", "MCA" };

    public StudentApplicationForm() {
        setTitle("Student Form");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nameTextField = new JTextField(20);
        ageTextField = new JTextField(3);
        nameLabel = new JLabel("Name");
        ageJLabel = new JLabel("Age");
        genderLabel = new JLabel("Gender");
        branchJLabel = new JLabel("Branch");
        genderBox = new JComboBox<>(gender);
        branchBox = new JComboBox<>(branch);
        submitButton = new JButton("Submit");

        Container con = getContentPane();
        con.setLayout(new GridLayout(5, 2));
        con.add(nameLabel);
        con.add(nameTextField);
        con.add(ageJLabel);
        con.add(ageTextField);
        con.add(genderLabel);
        con.add(genderBox);
        con.add(branchJLabel);
        con.add(branchBox);
        con.add(submitButton);

        submitButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submitButton) {
            String name = (nameTextField.getText());
            int age = Integer.parseInt(ageTextField.getText());
            String gen = (String) genderBox.getSelectedItem();
            String branc = (String) branchBox.getSelectedItem();
            JOptionPane.showMessageDialog(this, "Successfully registered");
            String details = "Name: " + name + "\nAge: " + age + "\nGender: " + gen + "\nBranch: " + branc;
            System.out.println(details);
            try {
                FileWriter fr = new FileWriter("Hello.txt");
                fr.write(details);
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        StudentApplicationForm form = new StudentApplicationForm();
        form.setVisible(true);

    }
}
