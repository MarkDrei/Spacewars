package de.rkable.spacewars;

public class AttackBuilder {

	private double projectileDamage = 0;
	private double energyDamage = 0;
	
	public static Attack energyAttack(double damage) {
		return new SimpleAttack(damage, 0);
	}
	
	public static Attack projectileAttack(double damage) {
		return new SimpleAttack(0, damage);
	}

	public AttackBuilder projectileDamage(double damage) {
		projectileDamage = damage;
		return this;
	}

	public Attack build() {
		return new SimpleAttack(energyDamage, projectileDamage);
	}

	public AttackBuilder energyDamage(double damage) {
		this.energyDamage = damage;
		return this;
	}

}
