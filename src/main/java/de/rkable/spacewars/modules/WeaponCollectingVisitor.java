package de.rkable.spacewars.modules;

import java.util.ArrayList;
import java.util.List;

import de.rkable.spacewars.Module;
import de.rkable.spacewars.ShipHull;
import de.rkable.spacewars.Weapon;
import de.rkable.spacewars.WeaponCollector;

public class WeaponCollectingVisitor implements WeaponCollector {
	
	private final ShipHull shipHull;
	
	public WeaponCollectingVisitor(ShipHull shipHull) {
		this.shipHull = shipHull;
	}

	@Override
	public List<Weapon> getWeapons() {
		List<Weapon> weapons = new ArrayList<>();
		for (Module module : shipHull.getModuleSlots().values()) {
			if (module instanceof WeaponModule) {
				weapons.add(((WeaponModule) module).getWeapon());
			}
		}
		
		return weapons;
	}

}
