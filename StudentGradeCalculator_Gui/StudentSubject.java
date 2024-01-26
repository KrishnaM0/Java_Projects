package com.Tasks.StudentGradeCalculator_Gui;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class StudentSubject extends JFrame {

    StudentSubject(String userName, int count){
        JTextField[] tfmark = new JTextField[count];
        int[] marks = new int[count];
        setLayout(null);
        setBounds(120, 50, 1000, 600);
        setVisible(true);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/gradecalculator2.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 400, 600);
        add(image);

        JLabel heading = new JLabel("Enter marks out of 100 for each subject : ");
        heading.setBounds(420, 10, 500, 25);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 22));
        add(heading);

        int y1 = 60;
        int y2 = 60;
        for (int i = 0; i < count; i++) {
            JLabel sub = new JLabel((i+1) + ". Enter Subject Marks : ");
            sub.setBounds(480, y1, 300, 25);
            sub.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            add(sub);

            tfmark[i] = new JTextField();
            tfmark[i].setBounds(720, y2, 50, 26);
            tfmark[i].setFont(new Font("Times New Roman", Font.PLAIN, 20));
            tfmark[i].setHorizontalAlignment(JTextField.CENTER);
            tfmark[i].setForeground(Color.BLUE);
            add(tfmark[i]);

            y1 = y1 + 50;
            y2 = y2 + 50;
        }
        JButton back = new JButton("Back");
        back.setBounds(828, 360, 100, 35);
        back.setBackground(ColorUIResource.RED);
        back.setForeground(Color.WHITE);
        add(back);
        back.addActionListener(e -> {
            setVisible(false);
            new Login();
        });

        JButton score = new JButton("Score");
        score.setBounds(828, 260, 100, 35);
        score.setBackground(ColorUIResource.blue);
        score.setForeground(Color.WHITE);
        add(score);
        score.addActionListener(e -> {
            int total = 0;
            for (int i = 0; i < count; i++) {
                try {
                    marks[i] = Integer.parseInt(tfmark[i].getText());
                    if(marks[i] > 100){
                        JOptionPane.showMessageDialog(this, "Please enter valid marks(<=100)..! ");
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter valid marks for all subjects..! ");
                    return; // Stop further execution if any mark is invalid
                }
            }
            for (int i = 0; i < count; i++) {
                total = total + marks[i];
            }

            setVisible(false);
            new Result(userName, total, count);
        });
    }

    public static void main(String[] args) {
        new StudentSubject("user", 0);
    }
}
