package de.rkable.spacewars;

public class ArmorCalculator implements ShipVisitor {
	
	private double overallArmor;
	
	public double getArmor() {
		return overallArmor;
	}

	@Override
	public void visit(SpaceShip ship) {
		overallArmor = 0;
		for (Module slot : ship.getModuleSlots().values()) {
			slot.accept(this);
		}
	}

	@Override
	public void visit(ArmorModule armor) {
		overallArmor += armor.getArmor();
	}

	@Override
	public void visit(EmptyModule module) {
		// no armor
	}

}
