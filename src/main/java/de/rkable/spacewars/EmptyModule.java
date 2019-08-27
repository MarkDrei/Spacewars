package de.rkable.spacewars;

public class EmptyModule implements Module {

	@Override
	public void accept(ShipVisitor visitor) {
		// nothing to be done here
		visitor.visit(this);
	}
	
}
