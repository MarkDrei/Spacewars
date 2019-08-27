package de.rkable.spacewars.modules;

import de.rkable.spacewars.Module;

public class ArmorModule implements Module {

	private double armor;

	public ArmorModule(double maxArmor) {
		this.armor = maxArmor;
	}

	@Override
	public void accept(ShipModuleVisitor visitor) {
		visitor.visit(this);
	}
	
	public double getArmor() {
		return armor;
	}

	
}
