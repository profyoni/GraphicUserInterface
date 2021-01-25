package edu.touro.cs;

import javax.swing.*;
import java.awt.*; // abstract windowing toolkit
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyWindow extends JFrame {
    private JTextField textField1, textField2;
    private JLabel sumLabel;

    MyWindow() {
        this.setTitle("First 364 GUI!!");
        this.setSize(400, 200);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.getContentPane().setBackground( Color.BLACK);
        this.getContentPane().setLayout(new FlowLayout());

        JButton button = new JButton("ADD");
        this.getContentPane().add(button);

        // registerimng the event listener
        button.addActionListener(new MyActionListener());

        textField1 = new JTextField(10);
        this.getContentPane().add(textField1);
        textField2 = new JTextField(10);
        this.getContentPane().add(textField2);

        sumLabel = new JLabel("Sum will go here");
        this.getContentPane().add(sumLabel);

        this.setVisible(true);
    }

    // event handler
    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text1 = textField1.getText();
            String text2 = textField2.getText();

            sumLabel.setText( (Integer.parseInt(text1) + Integer.parseInt(text2)) + "");

        }
    }
}

public class Temp {
    public static void main(String[] args) {
        new MyWindow();
    }
}
