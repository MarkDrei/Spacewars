package de.rkable.spacewars;

public interface ModuleSlot {

	void accept(ShipVisitor visitor);

}
