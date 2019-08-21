package de.rkable.spacewars;

public class SimpleAttack implements Attack {

	private final double energyDamage;
	private final double projectileDamage;

	public SimpleAttack(double energyDamage, double projectileDamage) {
		this.energyDamage = energyDamage;
		this.projectileDamage = projectileDamage;
	}

	@Override
	public double getEnergyDamage() {
		return energyDamage;
	}
	
	@Override
	public double getProjectileDamage() {
		return projectileDamage;
	}

}
