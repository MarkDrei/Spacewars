package de.rkable.spacewars.modules;

import de.rkable.spacewars.Module;
import de.rkable.spacewars.ShipVisitor;

public class EmptyModule implements Module {

	@Override
	public void accept(ShipVisitor visitor) {
		// nothing to be done here
		visitor.visit(this);
	}
	
}
