package com.Tasks.StudentGradeCalculator_Gui;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class Result extends JFrame {

    Result(String userName, int total, int count){
        setLayout(null);
        setBounds(120, 50, 1000, 600);
        setVisible(true);

        float avgPercent = (float) total / count;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/numgame.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 400, 600);
        add(image);

        JLabel heading = new JLabel("Result of ");
        heading.setBounds(420, 40, 500, 35);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 28));
        add(heading);

        JLabel showName = new JLabel(userName);
        showName.setBounds(535, 40, 500, 35);
        showName.setFont(new Font("Times New Roman", Font.BOLD, 28));
        showName.setForeground(Color.BLUE);
        add(showName);

        JLabel line = new JLabel("  ------------------------------------------------------------------------------------");
        line.setBounds(401, 75, 1000, 40);
        line.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        add(line);

        JLabel total1 = new JLabel("Total                   -> ");
        total1.setBounds(536, 150, 500, 25);
        total1.setFont(new Font("Times New Roman", Font.BOLD, 22));
        add(total1);

        JLabel showTotal = new JLabel(total + " / " + (count * 100));
        showTotal.setBounds(752, 150, 500, 25);
        showTotal.setFont(new Font("Times New Roman", Font.BOLD, 22));
        showTotal.setForeground(Color.RED);
        add(showTotal);


        JLabel score = new JLabel("Average percent       -> ");
        score.setBounds(495, 200, 500, 25);
        score.setFont(new Font("Times New Roman", Font.BOLD, 22));
        add(score);

        JLabel showPercent = new JLabel(String.format("%.2f", avgPercent));
        showPercent.setBounds(752, 200, 500, 25);
        showPercent.setFont(new Font("Times New Roman", Font.BOLD, 22));
        showPercent.setForeground(Color.RED);
        add(showPercent);

        char grades = grades(avgPercent);

        JLabel grade = new JLabel("Grade                 -> ");
        grade.setBounds(535, 250, 500, 25);
        grade.setFont(new Font("Times New Roman", Font.BOLD, 22));
        add(grade);

        JLabel showGrades = new JLabel(grades + "");
        showGrades.setBounds(754, 250, 500, 25);
        showGrades.setFont(new Font("Times New Roman", Font.BOLD, 22));
        showGrades.setForeground(Color.RED);
        add(showGrades);

        JButton again = new JButton("Again");
        again.setBounds(480, 400, 100, 35);
        again.setBackground(ColorUIResource.BLUE);
        again.setForeground(Color.WHITE);
        add(again);
        again.addActionListener(e -> {
            setVisible(false);
            new Login();
        });

        JButton exit = new JButton("Exit");
        exit.setBounds(810, 400, 100, 35);
        exit.setBackground(ColorUIResource.RED);
        exit.setForeground(Color.WHITE);
        add(exit);
        exit.addActionListener(e -> setVisible(false));
    }
    public char grades(float avgPercent){
        if(avgPercent >= 90){
            return 'A';
        }
        else if(avgPercent >= 80){
            return 'B';
        }
        else if(avgPercent >= 70) {
            return 'c';
        }
        else if(avgPercent >= 60) {
            return 'D';
        }
        else if(avgPercent >= 50) {
            return 'E';
        }
        if(avgPercent < 50) {
            return 'F';
        }
        return 0;
    }

    public static void main(String[] args) {
        new Result("user", 0, 0);
    }
}
