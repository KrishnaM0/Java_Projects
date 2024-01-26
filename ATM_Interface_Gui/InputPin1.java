package com.Tasks.ATM_Interface_Gui;

import javax.swing.*;
import java.awt.*;

public class InputPin1 extends JFrame {
    InputPin1(){
        int balanceAmount = 3001;
        setLayout(null);
        setVisible(true);
        setBounds(120, 70, 1000, 500);
        getContentPane().setBackground(new Color(14, 11, 58));

        JLabel heading = new JLabel(" Welcome to the ATM Interface");
        heading.setBounds(465, 50, 500, 35);
        heading.setFont(new Font("Tahoma", Font.BOLD, 28));
        heading.setForeground(Color.WHITE);
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM4.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 500, 450);
        add(image);

        JLabel pin = new JLabel("Enter your pin  : ");
        pin.setBounds(520, 160, 250, 35);
        pin.setFont(new Font("Tahoma", Font.PLAIN, 22));
        pin.setForeground(Color.WHITE);
        add(pin);

        JTextField pinNum = new JTextField();
        pinNum.setBounds(700, 160, 150, 35);
        pinNum.setFont(new Font("Tahoma", Font.PLAIN, 22));
        pinNum.setHorizontalAlignment(JTextField.CENTER);
        pinNum.setForeground(Color.BLUE);
        add(pinNum);

        JButton start = new JButton("Continue");
        start.setBounds(605, 290, 150, 35);
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
        new InputPin1();
    }
}
