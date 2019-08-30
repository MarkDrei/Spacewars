package de.rkable.spacewars.modules;

import de.rkable.spacewars.ArmorCalculator;
import de.rkable.spacewars.Module;
import de.rkable.spacewars.ShipHull;

public class HullArmorCalculator implements ArmorCalculator {

	private ShipHull shipHull;

	public HullArmorCalculator(ShipHull shipHull) {
		this.shipHull = shipHull;
	}
	
	@Override
	public double getArmor() {
		
		double armor = 0;
		for (Module module : shipHull.getModuleSlots().values()) {
			if (module instanceof ArmorModule) {
				armor += ((ArmorModule) module).getArmor();
			}
		}
		return armor;
	}

}
