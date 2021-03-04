package edu.touro.cs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
enum GuessResponse{CORRECT,LOW,HIGH};
class ImpossibleResponseException extends RuntimeException
{
    // ToDo : add c-tor with message
}

interface HighLowGameHumanPicks {
    /**
     * @return the computer's guess using binary serach through the legal range
     */
    int getGuess();

    /**
     *  @param response - player's response to last guess whether it eas Correct, Low, or High
     *  @throws ImpossibleResponseException (inherits from RuntimeException)
     */
    void submitResponse(GuessResponse response);

    /**
     * Restarts game
     */
    void restart();
}
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

