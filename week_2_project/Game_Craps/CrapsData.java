package Game_Craps;

public class CrapsData {

	//Data field for craps betting
	private double ammountOfMoney;

	public CrapsData() {
		//initializing
		this.ammountOfMoney = 1000.0;

	}

	public double getMoney() {
		return this.ammountOfMoney;
	}

	public void setMoney(double bet) {
		this.ammountOfMoney = bet;
	}

}
