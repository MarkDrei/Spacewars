package de.rkable.spacewars;

public class Attack {

	private final double energyDamage;
	private final double projectileDamage;

	public static Attack energyDamage(double damage) {
		return new Attack(damage, 0);
	}
	
	public static Attack projectileDamage(double damage) {
		return new Attack(0, damage);
	}

	public Attack(double energyDamage, double projectileDamage) {
		this.energyDamage = energyDamage;
		this.projectileDamage = projectileDamage;
	}

	public double getEnergyDamage() {
		return energyDamage;
	}
	
	public double getProjectileDamage() {
		return projectileDamage;
	}


}
