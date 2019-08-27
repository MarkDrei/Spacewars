package de.rkable.spacewars.modules;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import de.rkable.spacewars.AttackBuilder;
import de.rkable.spacewars.SpaceShip;
import de.rkable.spacewars.SpaceShipBuilder;
import de.rkable.spacewars.Weapon;

public class TestWeaponCollector {

	@Test
	public void testWeaponsAreCollected() {
		WeaponModule module = new WeaponModule(new Weapon(new AttackBuilder().projectileDamage(2), 5.0));
		WeaponCollector weaponCollector = new WeaponCollector();
		weaponCollector.visit(module);
		assertEquals(1, weaponCollector.getWeapons().size());
	}
	
	@Test
	public void testWeaponCollectionOnShip() {
		SpaceShip ship = new SpaceShipBuilder().addTurret().addTurret().build();
		WeaponCollector weaponCollector = new WeaponCollector();
		ship.accept(weaponCollector);
		assertEquals(2, weaponCollector.getWeapons().size());
	}
}
