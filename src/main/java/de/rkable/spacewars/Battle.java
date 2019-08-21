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
		while (elapsedTime > 0) {
			double nextAttack1 = ship1.getTimeUntilNextAttack();
			double nextAttack2 = ship2.getTimeUntilNextAttack();
			
			double nextAttack = Math.min(nextAttack1, nextAttack2);
			if (elapsedTime < nextAttack) {
				ship1.getNextAttacks(elapsedTime);
				ship2.getNextAttacks(elapsedTime);
			} else {
				List<Attack> nextAttacks = ship1.getNextAttacks(nextAttack1);
				for (Attack attack : nextAttacks) {
					ship2.sufferAttack(attack);
					if (ship2.getArmor() <= 0) return;
				}
				nextAttacks = ship2.getNextAttacks(nextAttack1);
				for (Attack attack : nextAttacks) {
					ship1.sufferAttack(attack);
					if (ship1.getArmor() <= 0) return;
				}
				elapsedTime -= nextAttack;
			}
		}
	}

	public SpaceShip getWinner() {
		if (ship1.getArmor() <= 0) return ship2;
		if (ship2.getArmor() <= 0) return ship1;
		return null;
	}

}
