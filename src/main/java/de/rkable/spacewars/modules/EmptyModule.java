package de.rkable.spacewars.modules;

import de.rkable.spacewars.Module;

public class EmptyModule implements Module {

	@Override
	public void accept(ShipModuleVisitor visitor) {
		// nothing to be done here
		visitor.visit(this);
	}
	
}
