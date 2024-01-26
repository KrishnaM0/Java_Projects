package com.Tasks.NumberGuessing_Gui;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class NumberGuessing_Gui extends JFrame {
    JButton score, guess;
    String sc;             //string Count

    NumberGuessing_Gui() {
        AtomicInteger count = new AtomicInteger();
        setLayout(null);
        setVisible(true);
//        getContentPane().setBackground(Color.PINK);
        setBounds(125, 50, 1000, 600);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/guess.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 400, 600);
        add(image);

        JLabel title = new JLabel("Number Guessing Game(<100)");
        title.setBounds(500, 90, 500, 30);
        title.setFont(new Font("Times New Roman", Font.BOLD, 28));
        title.setForeground(Color.RED);
        add(title);

        Random rand = new Random();
        int randNum = rand.nextInt(100);

        JTextField inputField = new JTextField();
        inputField.setBounds(550, 170, 150, 30);
        inputField.setHorizontalAlignment(JTextField.CENTER);
        add(inputField);

        guess = new JButton("Guess");
        guess.setBounds(720, 170, 80, 30);
        add(guess);

        JLabel resultLabel = new JLabel();
        resultLabel.setBounds(580, 230, 500, 30);
        resultLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(resultLabel);

        guess.addActionListener(e -> {
            try {
                int guessedNum = Integer.parseInt(inputField.getText());
                if (guessedNum == randNum) {
                    resultLabel.setText("Your guess is correct..!");
                    count.getAndIncrement();
                    guess.setEnabled(false);
                    score.setEnabled(true);

                }
                else if (count.get() > 9) {
                    setVisible(false);
                    sc = count.toString();
                    new Score_Gui(sc);
                }
                else if (guessedNum > randNum) {
                    resultLabel.setText("Guess smaller number");
                    count.getAndIncrement();

                }
                else {
                    resultLabel.setText("Guess Larger Number");
                    count.getAndIncrement();
                }
            }
            catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input! Enter a number.");
            }
        });

        score = new JButton("Score");
        score.setBounds(615, 300, 100, 35);
        add(score);
        score.setEnabled(false);
        score.addActionListener(e ->{
            setVisible(false);
            sc = count.toString();
            new Score_Gui(sc);
        });
    }
    public static void main(String[] args) {
        new NumberGuessing_Gui();
    }
}