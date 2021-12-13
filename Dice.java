package snakeandladders;

public class Dice {
    private int numberOfDice;

    public Dice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    int roll(){
        return ((int) (Math.random()*(6*numberOfDice - 1*numberOfDice))) + 1;
    }
}
