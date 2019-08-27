package de.rkable.spacewars;

public interface ShipVisitor {

	void visit(SpaceShip ship);
	
	void visit(ArmorModule armor);

	void visit(EmptyModule module);

}