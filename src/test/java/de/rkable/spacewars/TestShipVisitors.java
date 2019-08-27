package de.rkable.spacewars;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestShipVisitors {

	@Test
	public void getArmorFromModules() {
		SpaceShip ship = new SpaceShipBuilder().build();
		ArmorCalculator armorCalculator = new ArmorCalculator();
		
		armorCalculator.visit(ship);
		assertEquals(100, armorCalculator.getArmor());
	}

}
