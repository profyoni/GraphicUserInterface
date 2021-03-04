package edu.touro.cs;

public interface HighLowGameHumanPicksInterface {
    /**
     * @return the computer's guess using binary search through the legal range
     */
    int getGuess();

    /**
     *  @param response - player's response to last guess whether it eas Correct, Low, or High
     *  @throws InvalidResponseException (inherits from RuntimeException)
     */
    void submitResponse(GuessResponse response);

    /**
     * Restarts game
     */
    void restart();
}

