package com.Tasks.ATM_Interface_Gui;

import javax.swing.*;
import java.awt.*;

public class inputPin extends JFrame {

    inputPin(){
        int balanceAmount = 3001;
        setLayout(null);
        setVisible(true);
        setBounds(200, 100, 825, 400);
        getContentPane().setBackground(new Color(14, 11, 58));

        JLabel heading = new JLabel(" ATM");
        heading.setBounds(60, 35, 100, 35);
        heading.setFont(new Font("Tahoma", Font.BOLD, 28));
        heading.setForeground(Color.WHITE);
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM4.png"));
        Image i2 = i1.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20, 35, 40, 40);
        add(image);

        JLabel pin = new JLabel("Enter your pin  : ");
        pin.setBounds(100, 150, 300, 35);
        pin.setFont(new Font("Tahoma", Font.PLAIN, 22));
        pin.setForeground(Color.WHITE);
        add(pin);

        JTextField pinNum = new JTextField();
        pinNum.setBounds(280, 150, 200, 35);
        pinNum.setFont(new Font("Tahoma", Font.PLAIN, 22));
        pinNum.setHorizontalAlignment(JTextField.CENTER);
        add(pinNum);

        JButton start = new JButton("Continue");
        start.setBounds(500, 150, 150, 35);
        start.setForeground(new Color(14, 11, 58));
        start.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(start);
        start.addActionListener(e -> {
            try {
                int input = Integer.parseInt(pinNum.getText());
                if (input == 1234) {
                    setVisible(false);
                    new Transactions(balanceAmount);
                }
                else{
                    JOptionPane.showMessageDialog(this, " Enter valid pin number..! ");
                }
            }
            catch(Exception exception){
                JOptionPane.showMessageDialog(this, " Enter valid pin number..! ");
            }
        });
    }
    public static void main(String[] args) {
        new inputPin();
    }
}
