package com.Tasks.StudentGradeCalculator_Gui;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class Login extends JFrame {

    Login(){
        setLayout(null);
        setBounds(120, 50, 1000, 600);
        setVisible(true);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Gradecalculator1.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 400, 600);
        add(image);

        JLabel heading = new JLabel("Student Grade Calculator");
        heading.setBounds(517, 50, 350, 40);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 30));
        heading.setForeground(Color.RED);
        add(heading);

        JLabel name = new JLabel("Enter your name : ");
        name.setBounds(480, 170, 300, 35);
        name.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        add(name);

        JTextField user = new JTextField();
        user.setBounds(650, 173, 240, 30);
        user.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        user.setHorizontalAlignment(JTextField.CENTER);
        user.setForeground(Color.BLUE);
        add(user);

        JLabel subject = new JLabel("No. of subjects    : ");
        subject.setBounds(480, 230, 300, 35);
        subject.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        add(subject);

        JTextField subCount = new JTextField();
        subCount.setBounds(650, 233, 240, 30);
        subCount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        subCount.setHorizontalAlignment(JTextField.CENTER);
        subCount.setForeground(Color.BLUE);
        add(subCount);

        JButton exit = new JButton("Exit");
        exit.setBounds(775, 400, 100, 35);
        exit.setBackground(ColorUIResource.RED);
        exit.setForeground(Color.WHITE);
        add(exit);
        exit.addActionListener(e -> setVisible(false));

        JButton start = new JButton("Continue");
        start.setBounds(500, 400, 100, 35);
        start.setBackground(ColorUIResource.blue);
        start.setForeground(Color.WHITE);
        add(start);
        start.addActionListener(e -> {
            int count;
            try {
                if (!user.getText().isEmpty() && !subCount.getText().isEmpty()) {
                    count = Integer.parseInt(subCount.getText());
                    if (count <= 9 && count > 1) {
                        String userName = user.getText();
                        setVisible(false);
                        new StudentSubject(userName, count);
                    } else {
                        JOptionPane.showMessageDialog(this, "Please enter Number of subjects (<=9 & >=2) ");
                    }
                } else if (subCount.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter Number of subjects..! ");
                } else if (user.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter your name..! ");
                }
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Please enter valid input..! ");
            }
        });

    }

    public static void main(String[] args) {
        new Login();
    }
}
