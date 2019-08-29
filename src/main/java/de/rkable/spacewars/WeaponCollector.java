package de.rkable.spacewars;

import java.util.List;

public interface WeaponCollector extends ShipVisitor {

	List<Weapon> getWeapons();

}