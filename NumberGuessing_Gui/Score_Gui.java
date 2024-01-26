package com.Tasks.NumberGuessing_Gui;

import javax.swing.*;
import java.awt.*;

public class Score_Gui extends JFrame {
    Score_Gui(String sc){
        setLayout(null);
        setVisible(true);
        setBounds(125, 50, 1000, 600);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/numgame.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 400, 600);
        add(image);

        JLabel score1 = new JLabel("The Number Of Attempts Taken");
        score1.setBounds(500, 100, 500, 35);
        score1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        add(score1);

        JLabel display = new JLabel("-> " + sc + "/10");
        display.setBounds(625, 200, 300, 35);
        display.setFont(new Font("Times New Roman", Font.BOLD, 25));
        display.setForeground(Color.RED);
        add(display);

        JButton play = new JButton("Play Again");
        play.setBounds(525, 300, 100, 35);
        add(play);
        play.addActionListener(e ->{
            new NumberGuessing_Gui();
            setVisible(false);
        });

        JButton exit = new JButton("Exit");
        exit.setBounds(725, 300, 100, 35);
        add(exit);
        exit.addActionListener(e ->{
            setVisible(false);
        });
    }

    public static void main(String[] args) {
        new Score_Gui("0");
    }
}