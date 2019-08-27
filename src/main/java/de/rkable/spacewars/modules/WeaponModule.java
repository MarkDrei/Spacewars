package de.rkable.spacewars.modules;

import de.rkable.spacewars.Module;
import de.rkable.spacewars.Weapon;

public class WeaponModule implements Module {

	private final Weapon weapon;

	public WeaponModule(Weapon weapon) {
		this.weapon = weapon;
	}

	@Override
	public void accept(ShipModuleVisitor visitor) {
		visitor.visit(this);
	}

	public Weapon getWeapon() {
		return weapon;
	}
}
