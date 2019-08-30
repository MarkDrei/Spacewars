package de.rkable.spacewars.modules;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import de.rkable.spacewars.SpaceShip;
import de.rkable.spacewars.main.SpaceShipBuilder;

public class TestArmorCalculator {

	@Test
	public void getArmorFromModules() {
		SpaceShip ship = new SpaceShipBuilder().build();
		HullArmorCalculator armorCalculator = new HullArmorCalculator(ship.getShipHull());
		assertEquals(100, armorCalculator.getArmor());
	}
	
	@Test
	public void multipleVisitsLeadToTheSameResults() {
		SpaceShip ship = new SpaceShipBuilder().build();
		HullArmorCalculator armorCalculator = new HullArmorCalculator(ship.getShipHull());
		assertEquals(100, armorCalculator.getArmor());
		assertEquals(100, armorCalculator.getArmor());
	}
	
	@Test
	public void totalArmorIsTheSumOfAllModules() {
		ModuleCollectionShipHull hull = ModuleCollectionShipHull.generateOnePieceShipHull(130);
		HullArmorCalculator armorCalculator = new HullArmorCalculator(hull);
		assertEquals(130, armorCalculator.getArmor());
		
		hull.addModule(new ArmorModule(140));
		assertEquals(270, armorCalculator.getArmor());
	}
	
	@Test
	public void noArmorForEmptyModules() {
		ModuleCollectionShipHull hull = ModuleCollectionShipHull.generateOnePieceShipHull(0);
		hull.addModule(new EmptyModule());
		HullArmorCalculator armorCalculator = new HullArmorCalculator(hull);
		
		assertEquals(0, armorCalculator.getArmor());
	}
	
}
