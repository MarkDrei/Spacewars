package de.rkable.spacewars;

public interface Module {

	void accept(ShipVisitor visitor);

}
