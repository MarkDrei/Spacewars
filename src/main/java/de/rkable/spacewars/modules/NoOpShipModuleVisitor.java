package de.rkable.spacewars.modules;

import de.rkable.spacewars.Module;
import de.rkable.spacewars.SpaceShip;

public abstract class NoOpShipModuleVisitor implements ShipModuleVisitor {
	
	public NoOpShipModuleVisitor() {
		initialize();
	}

	@Override
	public final void visit(SpaceShip ship) {
		initialize();
		for (Module module : ship.getModuleSlots().values()) {
			module.accept(this);
		}
	}

	protected abstract void initialize();

	@Override
	public void visit(ArmorModule armor) {
		// no op by default
	}

	@Override
	public void visit(EmptyModule module) {
		// no op by default
	}

	@Override
	public void visit(WeaponModule weaponModule) {
		// no op by default
	}

}
