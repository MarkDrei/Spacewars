package de.rkable.spacewars.modules;

public class ArmorCalculator extends NoOpShipModuleVisitor {
	
	private double overallArmor;
	
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
