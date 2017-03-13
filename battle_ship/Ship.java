package battle_ship;

public class Ship {
	// Data field
	private String shipName;
	private boolean isDestroyed;
	private int shipLength;
	private int numberOfHits;

	public Ship(String shipName, int shipLength) {
		// Constructor
		this.shipName = shipName;
		this.shipLength = shipLength;
		isDestroyed = false;
		numberOfHits = 0;
	}

	// Methods for ship object
	public boolean isDestroyed() {
		return isDestroyed;
	}

	public void destroyed() {
		this.isDestroyed = true;
	}

	public int getNumberOfHits() {
		return numberOfHits;
	}

	public void hit() {
		this.numberOfHits++;
	}

	public String getShipName() {
		return shipName;
	}

	public int getShipLength() {
		return shipLength;
	}

}
