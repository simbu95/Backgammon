package cs347.backgammon.core.game.players;

/**
 * Contains the identification information about a player.
 */
public class PlayerInfo
{
	private PlayerID playerID;
	private PlayerType playerType;

	// Time remaining?

	/**
	 * Initializes the everything as null. 
	 */
	public PlayerInfo()
	{
		//name = "";
	}
	
	/**
	 * Copy constructor.
	 * @param toClone The PlayerInfo to copy.
	 */
	public PlayerInfo(PlayerInfo toClone)
	{
		playerID = toClone.playerID;
		playerType = toClone.playerType;
	}

	/**
	 * Get the identification enumeration for the player.
	 * @return The player ID.
	 */
	public PlayerID getPlayerID()
	{
		return playerID;
	}

	/**
	 * Set the player ID for this player.
	 * @param playerID The new player ID for this player.
	 */
	public void setPlayerID(PlayerID playerID)
	{
		this.playerID = playerID;
	}


	/**
	 * Is this player a local GUI operator or a remote client?
	 * @return The type of player associated with this PlayerInfo.
	 */
	public PlayerType getPlayerType()
	{
		return playerType;
	}

	/**
	 * Set the type of player associated with this PlayerInfo.
	 * @param playerType The type of player associated with this PlayerInfo.
	 */
	public void setPlayerType(PlayerType playerType)
	{
		this.playerType = playerType;
	}

}
