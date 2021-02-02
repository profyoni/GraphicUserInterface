package edu.touro.cs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.Random;

// Read Effective Java Item 24: Static and nonStatic Inner Classes
// Inner class (defined inside another class) vs SubClass (derived class)
// nonstatic inner class has *access to outer class object* (2 this refernce, plain this, MyOuterClass.this
// new MyInnerClass() can only be instantituaed from the an instance of the OuterClass
// static inner classes does not have a reference to enclosing class implying it can be instantitaed from outside the OuterClass
// anonymous inner class - non-static inner class has no name - not need to instaiate more than once -
// throwaway one time use class

// take a screen shot of your GUI and add as comment in GitHub

// Model - hi lo game computer selects 1 to 1000 and human guesses it
class HiLoComputerPicks
{
    enum GuessResponse{CORRECT,LOW,HIGH};

    private Random random = new Random();
    int max, selectedNumber, guessCount;

    HiLoComputerPicks(int maximum)
    {
        max = maximum;
        selectedNumber = random.nextInt(max)+1;
    }

    String prompt()
    {
        return String.format("Try to guess my number. It is between 1 and %d", max);
    }

    GuessResponse submitGuess(int guess)
    {
        guessCount++;
        if (guess == selectedNumber)
            return GuessResponse.CORRECT;
        else if (guess < selectedNumber)
            return GuessResponse.LOW;
        else return GuessResponse.HIGH;
    }

    public int getGuessCount() {
        return guessCount;
    }

}

class MyWindow extends JFrame {
    private JTextField userGuess;
    private JLabel promptLabel;
    private HiLoComputerPicks game = new HiLoComputerPicks(100);


    MyWindow() {
        this.setTitle("First 364 GUI!!");
        this.setSize(400, 200);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel();

        JButton button = new JButton("Submit my guess"); // event source
        topPanel.add(button);




        // registering the event listener
ActionListener al = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {


        int guess = Integer.parseInt(userGuess.getText());

        HiLoComputerPicks.GuessResponse gr = game.submitGuess(guess);

        promptLabel.setText( "Your guess is too " + gr.toString() );
    }
};
        button.addActionListener(al);

        userGuess = new JTextField(10);
        topPanel.add(userGuess);

        promptLabel = new JLabel(game.prompt());
        topPanel.add(promptLabel);

        this.add(topPanel, BorderLayout.NORTH);

        this.setVisible(true);
    }




}