package cs347.backgammon.core.game;

import java.util.Random;

/**
 * Represents the current state of the game dice. 
 */
public class DiceState
{
	/**
	 * A six sided dice cannot be less than 1.
	 */
	private static final short MIN_DICE_VALUE = 0;
	
	/**
	 * A six sided dice cannot be greater than 6.
	 */
	private static final short MAX_DICE_VALUE = 6;
	
	/**
	 * Random number generator for rolling dice.
	 */
	private static Random random = new Random();
	
	private short dice1, dice2;
	
	/**
	 * Initializes the dice to 1.
	 */
	public DiceState()
	{
		dice1 = 1;
		dice2 = 1;
	}
	
	/**
	 * Copy constructor.
	 * @param toClone The DiceState to clone.
	 */
	public DiceState(DiceState toClone)
	{
		dice1 = toClone.dice1;
		dice2 = toClone.dice2;
	}
	
	/**
	 * Initialize the dice state with the given values.
	 * @param die1 The value for die 1.
	 * @param die2 The value for die 2.
	 * @throws RuntimeException Thrown if either die value is not between 1 and 6 inclusive.
	 */
	public DiceState(int die1, int die2)
	{
		setDice1Value(die1);
		setDice2Value(die2);
	}
	
	public int getDice1Value()
	{
		return dice1;
	}
	
	public int getDice2Value()
	{
		return dice2;
	}
	
	/**
	 * Sets the value of die 1.
	 * @param diceValue A value between 0 and 6 inclusive.
	 * @throws RuntimeException Thrown if diceValue is not between 1 and 6 inclusive.
	 */
	public void setDice1Value(int diceValue)
	{
		if(diceValue < MIN_DICE_VALUE)
			throw new RuntimeException("diceValue cannot be less than "+MIN_DICE_VALUE+".");
		else if(diceValue > MAX_DICE_VALUE)
			throw new RuntimeException("diceValue cannot be more than "+MAX_DICE_VALUE+".");
		dice1 = (short)diceValue;
	}
	
	/**
	 * Sets the value of die 2.
	 * @param diceValue A value between 0 and 6 inclusive.
	 * @throws RuntimeException Thrown if diceValue is not between 1 and 6 inclusive.
	 */
	public void setDice2Value(int diceValue)
	{
		if(diceValue < MIN_DICE_VALUE)
			throw new RuntimeException("diceValue cannot be less than "+MIN_DICE_VALUE+".");
		else if(diceValue > MAX_DICE_VALUE)
			throw new RuntimeException("diceValue cannot be more than "+MAX_DICE_VALUE+".");
		dice2 = (short)diceValue;
	}
	
	/**
	 * Generate a random set of dice.
	 * @return A random set of dice.
	 */
	public static DiceState randomDice()
	{
		int die1 = random.nextInt(MAX_DICE_VALUE) + MIN_DICE_VALUE;
		int die2 = random.nextInt(MAX_DICE_VALUE) + MIN_DICE_VALUE;
		return new DiceState(die1, die2);
	}
}
