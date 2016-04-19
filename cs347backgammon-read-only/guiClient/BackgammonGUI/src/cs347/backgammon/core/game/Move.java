package cs347.backgammon.core.game;

/**
 * Immutable object representing the movement of a checker.
 */
public class Move// implements Comparable<Move>
{
	private static long MOVE_COUNT = 0L;
	private short fromID;
	private short toID;
	private long moveID;
	private boolean isScore;
	
	public static final short END_TURN = -1;
	/**
	 * Used as the "To ID" when bearing off a checker.
	 */
	public static final short NULL_ID = -2;
	
	/**
	 * Initialize the BoardCell ID values for this checker move. Initializes
	 * this move's ID.
	 * 
	 * @param fromID
	 *            The cell ID where the checker is moving from.
	 * @param toID
	 *            The cell ID where the checker is moving to.
	 * @see cs347.backgammon.core.game.board.BoardCell
	 */
	public Move(int fromID, int toID)
	{
		this.fromID = (short) fromID;
		this.toID = (short) toID;
		initID();
	}

	/**
	 * Initialize this move's unique ID. Move ID's start at zero. If enough
	 * moves have been generated to overflow the positive range of a Long type
	 * then the ID counter resets to zero and starts again.
	 */
	private void initID()
	{
		moveID = MOVE_COUNT;

		if (MOVE_COUNT + 1 == Long.MAX_VALUE)
			MOVE_COUNT = 0;
		else
			MOVE_COUNT++;
	}

	/**
	 * Get the BoardCell ID where this checker is moving from.
	 * 
	 * @return The originating cell ID for this move.
	 */
	public short getFromID()
	{
		return fromID;
	}

	/**
	 * Get the BoardCell ID where this checker is moving to.
	 * 
	 * @return The destination cell ID for this moving.
	 */
	public short getToID()
	{
		return toID;
	}

	/**
	 * Return the unique ID for this move.
	 * 
	 * @return The unique ID for this move.
	 */
	public long getMoveID()
	{
		return moveID;
	}

	public boolean isScore()
	{
		return isScore;
	}

	public void setIsScore(boolean isScore)
	{
		this.isScore = isScore;
	}
	
	
}
