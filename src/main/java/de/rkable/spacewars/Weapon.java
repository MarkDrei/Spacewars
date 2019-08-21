package de.rkable.spacewars;

import java.util.ArrayList;
import java.util.List;

public class Weapon {

	private final AttackBuilder attackBuilder;
	private final double attackInterval;
	
	private double timeUntilNextAttack = 0;

	public Weapon(AttackBuilder attackBuilder, double attackInterval) {
		this.attackBuilder = attackBuilder;
		this.attackInterval = attackInterval;
	}

	public double getTimeUntilNextAttack() {
		return timeUntilNextAttack;
	}

	public List<Attack> getNextAttacks(double elapsedTime) {
		List<Attack> attacks = new ArrayList<>();
		timeUntilNextAttack -= elapsedTime;
		while (timeUntilNextAttack <= 0) {
			attacks.add(attackBuilder.build());
			timeUntilNextAttack += attackInterval;
		}
		return attacks;
	}

}
