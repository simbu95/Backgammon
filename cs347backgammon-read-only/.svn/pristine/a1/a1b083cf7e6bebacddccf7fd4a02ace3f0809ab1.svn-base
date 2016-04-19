package cs347.backgammon.core.game.board;

/**
 * The base unit of a backgammon game board.
 * 
 * A backgammon board has 24 normal cells for holding checkers, 2 more for the
 * "bar", and another 2 for scoring. Each cell can hold up to 15 checkers. Each
 * cell is controlled by one of the players or it is empty.
 */
public class BoardCell
{
	/**
	 * There are only 15 checkers in a backgammon game. Therefore no cell can
	 * hold more than 15 cells.
	 */
	public static final short MAX_CHECKER_COUNT = 15;

	/**
	 * A cell cannot have a negative number of checkers.
	 */
	public static final short MIN_CHECKER_COUNT = 0;

	/**
	 * Maintains who the current cell owner is.
	 */
	private CellOwner cellOwner;

	/**
	 * Unique number in order to identify a particular cell. It is up to the
	 * user to guarantee the uniqueness of this identification value.
	 */
	private short cellID;

	/**
	 * The number of checkers that reside in this cell.
	 */
	private short checkerCount;

	/**
	 * The listener for change events on this cell.
	 */
	private IBoardCellListener cellListener;

	/**
	 * Initializes the cell with no owner, no checkers, and with the given ID
	 * value.
	 * 
	 * @param cellID
	 *            Unique number in order to identify a particular cell. It is up
	 *            to the user to guarantee the uniqueness of this identification
	 *            value.
	 */
	public BoardCell(short cellID)
	{
		this.cellID = cellID;
		cellOwner = CellOwner.Empty;
		checkerCount = 0;
	}

	/**
	 * Copy constructor. Does not copy the listener;
	 * 
	 * @param toClone
	 *            The BoardCell to copy.
	 */
	public BoardCell(BoardCell toClone)
	{
		this.cellID = toClone.cellID;
		this.cellOwner = toClone.cellOwner;
		this.checkerCount = toClone.checkerCount;
	}

	/**
	 * Find out who the current cell owner is.
	 * 
	 * @return The current cell owner.
	 */
	public CellOwner getCellOwner()
	{
		return cellOwner;
	}

	/**
	 * Set the current cell owner. The cell listener will be notified.
	 * 
	 * @param cellOwner
	 *            The new cell owner.
	 */
	public void setCellOwner(CellOwner cellOwner)
	{
		this.cellOwner = cellOwner;
		notifyCellListener();
	}

	/**
	 * Get the unique ID value for this cell. It is up to the user to guarantee
	 * the uniqueness of this identification value via the constructor for this
	 * class.
	 * 
	 * @return The unique ID value for this cell.
	 * @see #BoardCell(short)
	 */
	public short getCellID()
	{
		return cellID;
	}

	/**
	 * How many checkers currently reside on this cell?
	 * 
	 * @return The number of checkers currently on this cell.
	 */
	public short getCheckerCount()
	{
		return checkerCount;
	}

	/**
	 * Set how many checkers currently reside on this cell. The cell listener
	 * will be notified.
	 * 
	 * @param checkerCount
	 *            The new number of checkers at this cell.
	 * @throws RuntimeException
	 *             Thrown if checkerCount is less than MIN_CHECKER_COUNT or
	 *             greater than MAX_CHECKER_COUNT.
	 * @see #MIN_CHECKER_COUNT
	 * @see #MAX_CHECKER_COUNT
	 */
	public void setCheckerCount(int checkerCount)
	{
		if (checkerCount < MIN_CHECKER_COUNT)
			throw new RuntimeException("New checker count cannot be less than " + MIN_CHECKER_COUNT + ".");
		else if (checkerCount > MAX_CHECKER_COUNT)
			throw new RuntimeException("New checker count cannot be more than " + MAX_CHECKER_COUNT + ".");

		this.checkerCount = (short) checkerCount;
		notifyCellListener();
	}

	/**
	 * A change has occurred in this BoardCell. Notify the listener.
	 */
	protected void notifyCellListener()
	{
		if(cellListener != null)
			cellListener.boardCellChanged(this);
	}

	/**
	 * Set the cell listener to be notified when the state of this cell changes.
	 * 
	 * @param listener
	 *            The receiver of change events on this cell.
	 */
	public void setBoardCellListener(IBoardCellListener listener)
	{
		cellListener = listener;
	}

	/**
	 * Get the listener attached to this BoardCell.
	 * 
	 * @return The listener attached to this cell or null if not yet set.
	 */
	public IBoardCellListener getBoardCellListener()
	{
		return cellListener;
	}
}
