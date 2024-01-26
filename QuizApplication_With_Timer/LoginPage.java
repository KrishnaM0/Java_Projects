package com.Tasks.QuizApplicationTimer;

import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame {

    LoginPage(){
        setLayout(null);
        setVisible(true);
        setBounds(125, 100, 1000, 500);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));

        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 400, 500);
        add(image);

        JLabel heading = new JLabel("Quiz Application");
        heading.setBounds(585, 70, 400, 40);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(heading);

        JLabel name = new JLabel("Enter your name");
        name.setBounds(625, 150, 400, 40);
        name.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(name);

        JTextField userName = new JTextField();
        userName.setBounds(520, 210, 350, 35);
        userName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        userName.setHorizontalAlignment(JTextField.CENTER);
        userName.setForeground(Color.BLUE);
        add(userName);

        JButton quiz = new JButton("Start");
        quiz.setBounds(520, 320, 100, 30);
        quiz.setBackground(Color.BLUE);
        quiz.setForeground(Color.WHITE);
        add(quiz);
        quiz.addActionListener(e -> {
            if(!userName.getText().isEmpty()) {
                String user = userName.getText();
                setVisible(false);
                new Quiz(user);
            }
            else {
                JOptionPane.showMessageDialog(this, "Enter your name to attempt the quiz");
            }

        });

        JButton exit = new JButton("Exit");
        exit.setBounds(770, 320, 100, 30);
        exit.setBackground(Color.getHSBColor(134, 450,52));
        exit.setForeground(Color.WHITE);
        add(exit);
        exit.addActionListener(e -> setVisible(false));
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
