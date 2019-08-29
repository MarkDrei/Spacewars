package de.rkable.spacewars.modules;

import java.util.ArrayList;
import java.util.List;

import de.rkable.spacewars.Weapon;
import de.rkable.spacewars.WeaponCollector;

public class WeaponCollectingVisitor extends NoOpShipModuleVisitor implements WeaponCollector {
	
	private List<Weapon> weapons = new ArrayList<>();
	
	@Override
	protected void initialize() {
		weapons = new ArrayList<>();
	}

	@Override
	public void visit(WeaponModule weaponModule) {
		weapons.add(weaponModule.getWeapon());
	}

	@Override
	public List<Weapon> getWeapons() {
		return weapons;
	}

}
