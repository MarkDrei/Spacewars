package de.rkable.spacewars.modules;

import de.rkable.spacewars.ShipVisitor;

public interface ShipModuleVisitor extends ShipVisitor {
	
	void visit(ArmorModule armor);

	void visit(EmptyModule module);

	void visit(WeaponModule weaponModule);
	
}
