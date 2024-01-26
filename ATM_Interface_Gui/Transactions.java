package com.Tasks.ATM_Interface_Gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Transactions extends JFrame {
    JTextField amountInput;
    JButton nextDeposit, nextWithdraw;
    double[] balanceAmount1 = {0};
    ArrayList<String> list = new ArrayList<>();
    int count = 0;
    Transactions(double balanceAmount){

        balanceAmount1[0] = balanceAmount;

        setLayout(null);
        setVisible(true);
        setBounds(20, 40, 1240, 600);
        getContentPane().setBackground(new Color(14, 11, 58));

        JLabel heading = new JLabel("ATM Services : ");
        heading.setBounds(25, 35, 400, 35);
        heading.setFont(new Font("Tahoma", Font.BOLD, 28));
        heading.setForeground(Color.WHITE);
        add(heading);

        JLabel name = new JLabel("Choose Your Transaction : -");
        name.setBounds(75, 210, 400, 35);
        name.setFont(new Font("Tahoma", Font.PLAIN, 22));
        name.setForeground(Color.WHITE);
        add(name);

        JLabel message = new JLabel();
        message.setForeground(Color.WHITE);
        message.setBounds(640, 150, 700, 30);
        message.setFont(new Font("Tahoma", Font.PLAIN, 22));
        add(message);

        amountInput = new JTextField();
        amountInput.setBounds(892, 150, 100, 35);
        amountInput.setFont(new Font("Tahoma", Font.PLAIN, 22));
        amountInput.setHorizontalAlignment(JTextField.CENTER);
        add(amountInput);
        amountInput.setVisible(false);

        nextDeposit = new JButton("Next");
        nextDeposit.setBounds(1020, 150, 100, 35);
        nextDeposit.setForeground(new Color(14, 11, 58));
        nextDeposit.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(nextDeposit);
        nextDeposit.setVisible(false);
        nextDeposit.addActionListener(e -> {
            try {
                int depositAmount = Integer.parseInt(amountInput.getText());

                if (depositAmount < 0) {
                    JOptionPane.showMessageDialog(this, "Enter a non-negative amount for deposit.");
                } else {
                    balanceAmount1[0] += depositAmount;
                    amountInput.setText("");
                    message.setText(" ->  Deposit successful. New balance : " + balanceAmount1[0] + " $");
                    list.add("   ->  Amount Deposited :   +" + depositAmount + " $");
                    count = count + 1;
                    nextDeposit.setVisible(false);
                    amountInput.setVisible(false);
                }
            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter a valid numeric amount for deposit.");
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "An error occurred while processing the deposit.");
            }
        });

        nextWithdraw = new JButton("Next");
        nextWithdraw.setBounds(1020, 150, 100, 35);
        nextWithdraw.setForeground(new Color(14, 11, 58));
        nextWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(nextWithdraw);
        nextWithdraw.setVisible(false);
        nextWithdraw.addActionListener(e ->{
            try {
                int withdrawAmount = Integer.parseInt(amountInput.getText());

                if (withdrawAmount < 0) {
                    JOptionPane.showMessageDialog(this, "Enter a non-negative amount for withdraw.");
                }

                else if (withdrawAmount > balanceAmount1[0]) {
                    JOptionPane.showMessageDialog(this, "Insufficient balance to withdraw..!");
                }
                else {
                    balanceAmount1[0] -= withdrawAmount;
                    amountInput.setText("");
                    message.setText(" ->  Withdrawal successful. New balance : " + balanceAmount1[0] + " $");
                    list.add("   ->  Amount Withdrew  :   -" + withdrawAmount + " $");
                    count = count + 1;
                    nextWithdraw.setVisible(false);
                    amountInput.setVisible(false);
                }
            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter a valid numeric amount for withdraw.");
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "An error occurred while processing the withdraw.");
            }
        });

        JButton balance = new JButton("Check Balance");
        balance.setBounds(420, 150, 200, 35);
        balance.setForeground(new Color(14, 11, 58));
        balance.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(balance);
        balance.addActionListener(e ->{
            amountInput.setVisible(false);
            nextDeposit.setVisible(false);
            nextWithdraw.setVisible(false);

            message.setText(" ->  Your Balance = " + balanceAmount1[0] + " $");
        });

        JButton deposit = new JButton("Deposit");
        deposit.setBounds(420, 210, 200, 35);
        deposit.setForeground(new Color(14, 11, 58));
        deposit.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(deposit);
        deposit.addActionListener(e -> {
            message.setText("Enter deposit amount  : ");
            amountInput.setForeground(new Color(16, 93, 236, 255));
            amountInput.setVisible(true);
            nextWithdraw.setVisible(false);
            nextDeposit.setVisible(true);
        });

        JButton Withdraw = new JButton("Withdraw");
        Withdraw.setBounds(420, 270, 200, 35);
        Withdraw.setForeground(new Color(14, 11, 58));
        Withdraw.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(Withdraw);
        Withdraw.addActionListener(e -> {
            message.setText("Enter withdraw amount : ");
            amountInput.setForeground(new Color(246, 4, 4));
            amountInput.setVisible(true);
            nextDeposit.setVisible(false);
            nextWithdraw.setVisible(true);
        });

        JButton exit = new JButton("Exit ATM");
        exit.setBounds(443, 360, 150, 35);
        exit.setBackground(new Color(10, 10, 10));
        exit.setForeground(new Color(248, 6, 6));
        exit.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(exit);
        exit.addActionListener(e ->{
            setVisible(false);
        });

        JButton history = new JButton("Transaction History");
        history.setBounds(700, 360, 230, 35);
        history.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(history);
        history.addActionListener(e -> {
            double initialBalance = balanceAmount1[0];
            setVisible(false);
            new TransactionHistory(list, initialBalance, count);
        });
    }

    public static void main(String[] args) {
        new Transactions(0);
    }
}
