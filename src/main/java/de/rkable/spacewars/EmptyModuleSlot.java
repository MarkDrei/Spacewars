package de.rkable.spacewars;

public class EmptyModuleSlot implements ModuleSlot {

	@Override
	public void accept(ShipVisitor visitor) {
		// nothing to be done here
	}
	
}
