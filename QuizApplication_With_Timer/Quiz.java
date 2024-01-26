package com.Tasks.QuizApplicationTimer;

import javax.swing.*;
import java.awt.*;

public class Quiz extends JFrame {

    JLabel queNo, question;
    JRadioButton option1, option2, option3, option4;
    ButtonGroup groupOptions;
    String[][] questions = new String[10][5];
    static String[][] answers = new String[10][1];
    static String[][] userAns = new String[10][1];
    JButton previous, next, submit;
    String countDown, user;
    int count = 0;
    int score = 0;
    int timeRemain = 20;
    Quiz(String user) {
        this.user = user;
        setLayout(null);
        setVisible(true);
        setBounds(125, 50, 1000, 600);
//        getContentPane().setBackground(Color.PINK);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz3.png"));
        Image i2 = i1.getImage().getScaledInstance(1000, 240, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1000, 250);
        add(image);

        queNo = new JLabel();
        queNo.setBounds(25, 260, 40, 30);
        queNo.setFont(new Font("Times New Roman", Font.BOLD, 22));
        add(queNo);

        question = new JLabel();
        question.setBounds(60, 260, 900, 30);
        question.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        add(question);

        option1 = new JRadioButton();
        option1.setBounds(35, 310, 300, 35);
        option1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(option1);

        option2 = new JRadioButton();
        option2.setBounds(35, 360, 300, 35);
        option2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(option2);

        option3 = new JRadioButton();
        option3.setBounds(35, 410, 300, 35);
        option3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(option3);

        option4 = new JRadioButton();
        option4.setBounds(35, 460, 300, 35);
        option4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(option4);

        groupOptions = new ButtonGroup();
        groupOptions.add(option1);
        groupOptions.add(option2);
        groupOptions.add(option3);
        groupOptions.add(option4);

        questions[0][0] = "Which component is used to compile, debug and execute the java programs?";
        questions[0][1] = "JRE";
        questions[0][2] = "JIT";
        questions[0][3] = "JDK";    // Ans
        questions[0][4] = "JVM";

        questions[1][0] = "Which one of the following is not a Java feature?";
        questions[1][1] = "Object-oriented";
        questions[1][2] = "Use of pointers";   // Ans
        questions[1][3] = "Portable";
        questions[1][4] = "Dynamic and Extensible";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";   // Ans
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "What is the extension of java code files?";
        questions[3][1] = ".js";
        questions[3][2] = ".txt";
        questions[3][3] = ".class";
        questions[3][4] = ".java";    // Ans

        questions[4][0] = "Which of the following is not an OOPS concept in Java?";
        questions[4][1] = "Polymorphism";
        questions[4][2] = "Inheritance";
        questions[4][3] = "Compilation";  // Ans
        questions[4][4] = "Encapsulation";

        questions[5][0] = "Which of the following is a type of polymorphism in Java Programming?";
        questions[5][1] = "Multiple polymorphism";
        questions[5][2] = "Compile time polymorphism";   // Ans
        questions[5][3] = "Multilevel polymorphism";
        questions[5][4] = "Execution time polymorphism";

        questions[6][0] = "What is the extension of compiled java classes?";
        questions[6][1] = ".txt";
        questions[6][2] = ".js";
        questions[6][3] = ".class";  // Ans
        questions[6][4] = ".java";

        questions[7][0] = "Which exception is thrown when java is out of memory?";
        questions[7][1] = "MemoryError";
        questions[7][2] = "OutOfMemoryError";    // Ans
        questions[7][3] = "MemoryOutOfBoundsException";
        questions[7][4] = "MemoryFullException";

        questions[8][0] = "Which of these are selection statements in Java?";
        questions[8][1] = "break";
        questions[8][2] = "continue";
        questions[8][3] = "for()";
        questions[8][4] = "if()";  //Ans

        questions[9][0] = "Which of these keywords is used to define interfaces in Java?";
        questions[9][1] = "inf";
        questions[9][2] = "Inf";
        questions[9][3] = "interface";   // Ans
        questions[9][4] = "Interface";

        answers[0][0] = "JDK";
        answers[1][0] = "Use of pointers";
        answers[2][0] = "java.util package";
        answers[3][0] = ".java";
        answers[4][0] = "Compilation";
        answers[5][0] = "Compile time polymorphism";
        answers[6][0] = ".class";
        answers[7][0] = "OutOfMemoryError";
        answers[8][0] = "if()";
        answers[9][0] = "interface";

        display(count);

        next = new JButton("Next");
        next.setBounds(800, 330, 100, 35);
        next.setBackground(Color.BLUE);
        next.setForeground(Color.WHITE);
        add(next);
        next.addActionListener(e -> {
            timeRemain = 20;
            repaint();
            if (groupOptions.getSelection() != null) {
                userAns[count][0] = groupOptions.getSelection().getActionCommand();
                count++;

                if(count == 9){
                    next.setEnabled(false);
                    submit.setEnabled(true);
                }
                if(count >= 1){
                    previous.setEnabled(true);
                }
                display(count);
            }
            else {
                // Handles the case where no option is selected
                JOptionPane.showMessageDialog(this, "Please select an option before submitting. ");
            }
        });

        previous = new JButton("Previous");
        previous.setBounds(800, 390, 100, 35);
        previous.setBackground(Color.BLUE);
        previous.setForeground(Color.WHITE);
        add(previous);
        previous.addActionListener(e -> {
            timeRemain = 10;
            repaint();
            if(count < 1) {
                previous.setEnabled(false);
            }
            if(count > 0) {
                count--;
                display(count);
                next.setEnabled(true);
                submit.setEnabled(false);
            }
        });

        submit = new JButton("Submit");
        submit.setBounds(800, 450, 100, 35);
        submit.setBackground(Color.getHSBColor(134, 450,52));
        submit.setForeground(Color.WHITE);
        add(submit);
        submit.setEnabled(false);
        submit.addActionListener(e -> {

            if (groupOptions.getSelection() != null) {
                userAns[count][0] = groupOptions.getSelection().getActionCommand();

                for (int que = 0; que < 10; que++) {
                    if (userAns[que][0].equals(answers[que][0])) {
                        score = score + 1;
                    }
                }
                setVisible(false);
                String[] ans = ansSummary();
                String[] useranswer = userans();
                new QuizResult(user, score, ans, useranswer);
            }
            else {
                // Handle the case where no option is selected
                JOptionPane.showMessageDialog(this, "Please select an option before submitting. ");
            }
        });
    }

    public void display(int count){
        queNo.setText(" " + (count + 1) + ". ");
        question.setText(questions[count][0]);

        option1.setText((questions[count][1]));
        option1.setActionCommand(questions[count][1]);

        option2.setText((questions[count][2]));
        option2.setActionCommand(questions[count][2]);

        option3.setText((questions[count][3]));
        option3.setActionCommand(questions[count][3]);

        option4.setText((questions[count][4]));
        option4.setActionCommand(questions[count][4]);

        groupOptions.clearSelection();
    }

    public void paint(Graphics g) {
        super.paint(g);

        countDown = "Time left - " + timeRemain + " seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Times New Roman", Font.BOLD, 24));

        if (timeRemain > 0) {
            g.drawString(countDown, 760, 310);
        }
        else {
            g.drawString("Times up..!", 797, 310);
            timeRemain = 20;
            if(groupOptions.getSelection() != null) {
                userAns[count][0] = groupOptions.getSelection().getActionCommand();
            }
            else{
                userAns[count][0] = " ";
            }
            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count == 9){
                for (int que = 0; que < 10; que++) {
                    if (userAns[que][0].equals(answers[que][0])) {
                        score = score + 1;
                    }
                }
                setVisible(false);
                String[] ans = ansSummary();
                String[] useranswer = userans();
                new QuizResult(user, score, ans, useranswer);
            }
            else{
                count++;
                display(count);
            }
        }

        timeRemain--;

        try {
            Thread.sleep(1000);
            repaint();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static String[] ansSummary(){
        String[] ans = new String[10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 1; j++) {
                ans[i] = answers[i][j];
            }
        }
        return ans;
    }

    public static String[] userans(){
        String[] uanswer = new String[10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 1; j++) {
                uanswer[i] = userAns[i][j];
            }
        }
        return uanswer;
    }

    public static void main(String[] args) {
        new Quiz("user");
    }
}
