package de.rkable.spacewars.modules;

import java.util.ArrayList;
import java.util.List;

import de.rkable.spacewars.Weapon;

public class WeaponCollector extends NoOpShipModuleVisitor {
	
	private List<Weapon> weapons = new ArrayList<>();
	
	@Override
	protected void initialize() {
		weapons = new ArrayList<>();
	}

	@Override
	public void visit(WeaponModule weaponModule) {
		weapons.add(weaponModule.getWeapon());
	}

	public List<Weapon> getWeapons() {
		return weapons;
	}

}
