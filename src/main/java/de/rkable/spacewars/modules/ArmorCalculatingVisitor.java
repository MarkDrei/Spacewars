package de.rkable.spacewars.modules;

import de.rkable.spacewars.ArmorCalculator;

public class ArmorCalculatingVisitor extends NoOpShipModuleVisitor implements ArmorCalculator {
	
	private double overallArmor;
	
	@Override
	public double getArmor() {
		return overallArmor;
	}
	
	@Override
	protected void initialize() {
		overallArmor = 0;
	}

	@Override
	public void visit(ArmorModule armor) {
		overallArmor += armor.getArmor();
	}

}
