package de.rkable.spacewars;

public class Battle {

	private SpaceShip ship1;
	private SpaceShip ship2;

	public Battle(SpaceShip ship1, SpaceShip ship2) {
		this.ship1 = ship1;
		this.ship2 = ship2;
	}

	public boolean isOver() {
		return ship1.getArmor() <= 0 || ship2.getArmor() <= 0;
	}

	public void update(double elapsedTime) {
		
	}

	public SpaceShip getWinner() {
		if (ship1.getArmor() <= 0) return ship2;
		if (ship2.getArmor() <= 0) return ship1;
		return null;
	}

}
