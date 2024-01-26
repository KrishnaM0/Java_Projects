package com.Tasks.ATM_Interface_Gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TransactionHistory extends JFrame{

    TransactionHistory(ArrayList<String> list, double intialBalance, int count){
        setLayout(null);
        setVisible(true);
        setBounds(20, 40, 1240, 600);
        getContentPane().setBackground(new Color(14, 11, 58));

        JLabel heading = new JLabel("ATM Services  :  Transaction History  -> ");
        heading.setBounds(25, 35, 600, 35);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setForeground(Color.WHITE);
        add(heading);

        JTextArea history = new JTextArea();
        history.setBounds(100, 130, 600, 550);
        history.setFont(new Font("Tahoma", Font.PLAIN, 22));
        history.setForeground(Color.WHITE);
        history.setBackground(new Color(14, 11, 58));
        history.setEditable(false);
        add(history);

        JScrollPane scrollPane = new JScrollPane(history);
        scrollPane.setBounds(100, 130, 600, 400);
        add(scrollPane);

        JLabel Tcount = new JLabel("Number of Transactions : ->  ");
        Tcount.setBounds(760, 160, 600, 26);
        Tcount.setFont(new Font("Tahoma", Font.PLAIN, 22));
        Tcount.setForeground(Color.WHITE);
        add(Tcount);

        JLabel runningBalance = new JLabel("Running Balance : ->  ");
        runningBalance.setBounds(760, 220, 600, 26);
        runningBalance.setFont(new Font("Tahoma", Font.PLAIN, 22));
        runningBalance.setForeground(Color.WHITE);
        add(runningBalance);

        JLabel Tcount1 = new JLabel(" " + count);
        Tcount1.setBounds(1045, 160, 200, 26);
        Tcount1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        Tcount1.setForeground(new Color(11, 228, 248, 255));
        add(Tcount1);

        JLabel runningBalance1 = new JLabel(" " + intialBalance + " $");
        runningBalance1.setBounds(975, 220, 200, 26);
        runningBalance1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        runningBalance1.setForeground(new Color(11, 228, 248, 255));
        add(runningBalance1);

        JButton back = new JButton("Back");
        back.setBounds(770, 310, 100, 35);
        back.setForeground(new Color(14, 11, 58));
        back.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(back);
        back.addActionListener(e -> {
            setVisible(false);
            new Transactions(intialBalance);
        });

        for (String str : list) {
            history.append("\n" + str + "\n");
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        new TransactionHistory(list, 0, 0);
    }
}
