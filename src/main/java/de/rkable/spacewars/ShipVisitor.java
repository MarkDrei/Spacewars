package de.rkable.spacewars;

import de.rkable.spacewars.modules.ArmorModule;
import de.rkable.spacewars.modules.EmptyModule;

public interface ShipVisitor {

	void visit(SpaceShip ship);
	
	void visit(ArmorModule armor);

	void visit(EmptyModule module);

}