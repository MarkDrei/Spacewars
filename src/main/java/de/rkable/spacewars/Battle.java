package de.rkable.spacewars;

import java.util.List;

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
		while (elapsedTime > 0 && getWinner() == null) {
			double nextAttack = getTimeUntilNextAttack();
			double timeToProcess = Math.min(elapsedTime, nextAttack);
			
			processAttacks(timeToProcess);
			elapsedTime -= timeToProcess;
		}
	}

	private void processAttacks(double processTime) {
		List<Attack> nextAttacks = ship1.getNextAttacks(processTime);
		for (Attack attack : nextAttacks) {
			ship2.sufferAttack(attack);
			if (ship2.getArmor() <= 0) return;
		}
		nextAttacks = ship2.getNextAttacks(processTime);
		for (Attack attack : nextAttacks) {
			ship1.sufferAttack(attack);
			if (ship1.getArmor() <= 0) return;
		}
	}

	private double getTimeUntilNextAttack() {
		return Math.min(ship1.getTimeUntilNextAttack(), ship2.getTimeUntilNextAttack());
	}

	public ShipHull getWinner() {
		if (ship1.getArmor() <= 0) return ship2;
		if (ship2.getArmor() <= 0) return ship1;
		return null;
	}

}
