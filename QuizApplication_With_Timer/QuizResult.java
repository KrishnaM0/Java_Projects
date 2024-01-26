package com.Tasks.QuizApplicationTimer;

import javax.swing.*;
import java.awt.*;

public class QuizResult extends JFrame {

    String[] check = new String[10];
    int height = 100;
    QuizResult(String user, int score, String[] ans, String[] userans){
        setLayout(null);
        setVisible(true);
        setBounds(150, 20, 900, 640);

        for (int i = 0; i < 10; i++) {
            if(ans[i].equals(userans[i])){
                check[i] = "Right";
            }
            else{
                check[i] = "  X";
            }
        }

        JLabel heading = new JLabel("Total score of " + user + " :");
        heading.setBounds(30, 10, 450, 40);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 25));
        add(heading);

        JLabel mark = new JLabel(score + "/" + "10");
        mark.setBounds(410, 10, 200, 40);
        mark.setFont(new Font("Times New Roman", Font.BOLD, 25));
        mark.setForeground(Color.BLUE);
        add(mark);

        JLabel line = new JLabel("   ----------------------------------------------------------------------------------------------------------------------------------------------");
        line.setBounds(0, 35, 1000, 40);
        line.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        add(line);

        JLabel summary = new JLabel("Quiz Answers : ");
        summary.setBounds(30, 60, 400, 30);
        summary.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(summary);

        JLabel usersummary = new JLabel("Your Answers : ");
        usersummary.setBounds(500, 60, 400, 30);
        usersummary.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(usersummary);

        for (int i = 0; i < 10; i++) {
            JLabel answer = new JLabel((i + 1) + ". " + ans[i]);
            answer.setBounds(40, height, 300, 30);
            answer.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            add(answer);
            height = height + 40;
        }
        height = 100;
        for (int i = 0; i < 10; i++) {
            JLabel check1 = new JLabel(check[i]);
            check1.setBounds(440, height, 500, 30);
            check1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            check1.setForeground(Color.RED);
            add(check1);
            height = height + 40;
        }
        height = 100;
        for (int i = 0; i < 10; i++) {
            JLabel uanswer1 = new JLabel("->  " + (i + 1) + ". " + userans[i]);
            uanswer1.setBounds(510, height, 500, 30);
            uanswer1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            add(uanswer1);
            height = height + 40;
        }

        JButton quiz = new JButton("Quiz");
        quiz.setBounds(200, 520, 100, 35);
        quiz.setBackground(Color.BLUE);
        quiz.setForeground(Color.WHITE);
        add(quiz);
        quiz.addActionListener(e -> {
            setVisible(false);
            new LoginPage();
        });

        JButton exit = new JButton("Exit");
        exit.setBounds(600, 520, 100, 35);
        exit.setBackground(Color.getHSBColor(134, 450,52));
        exit.setForeground(Color.WHITE);
        add(exit);
        exit.addActionListener(e -> setVisible(false));

    }

    public static void main(String[] args) {

        String[] ans = Quiz.ansSummary();
        String[] userans = Quiz.userans();
        new QuizResult("user", 0, ans, userans);
    }
}
