package de.rkable.spacewars;

public class ArmorModule implements Module {

	private double armor;

	public ArmorModule(double maxArmor) {
		this.armor = maxArmor;
	}

	@Override
	public void accept(ShipVisitor visitor) {
		visitor.visit(this);
	}
	
	public double getArmor() {
		return armor;
	}

	
}
