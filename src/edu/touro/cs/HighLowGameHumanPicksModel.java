package edu.touro.cs;

// Loosely coupled classes - classes depend on each other as little as possible
// -- make classes as independent as possible
// great flexibiity to change
// limit impact a change in one class has on other classes
// SOLID design
// S - SRP - Single Responsibility Principle- every class should have one and only one resposibility
//
//
//
// D - DIP - Dependency Inversion Principle. Classes should not be dependent on other classes.
//          Rather classes should be dependent on INTERFACES => loosely coiupled classes

// pUblic
// pROtected
// pAckage
// pRivate
public class HighLowGameHumanPicksModel implements HighLowGameHumanPicksInterface{

    int hi, lo = 1; // private package
    HighLowGameHumanPicksModel(int max){
        hi = max;
    }

    @Override
    public int getGuess() {
        return 0;
    }

    @Override
    public void submitResponse(GuessResponse response) {

    }

    @Override
    public void restart() {

    }
}

