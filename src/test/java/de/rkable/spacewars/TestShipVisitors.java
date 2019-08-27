package de.rkable.spacewars;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestShipVisitors {
	
	ArmorCalculator armorCalculator = new ArmorCalculator();

	@Test
	public void getArmorFromModules() {
		SpaceShip ship = new SpaceShipBuilder().build();
		
		armorCalculator.visit(ship);
		assertEquals(100, armorCalculator.getArmor());
	}
	
	@Test
	public void multipleVisitsLeadToTheSameResults() {
		SpaceShip ship = new SpaceShipBuilder().build();
		
		armorCalculator.visit(ship);
		assertEquals(100, armorCalculator.getArmor());
		armorCalculator.visit(ship);
		assertEquals(100, armorCalculator.getArmor());
	}
	
	@Test
	public void totalArmorIsTheSumOfAllModules() {
		ArmorModule armorModule = new ArmorModule(100);
		armorCalculator.visit(armorModule);
		armorModule = new ArmorModule(150);
		armorCalculator.visit(armorModule);
		
		assertEquals(250, armorCalculator.getArmor());
	}
	
	@Test
	public void noArmorForEmptyModules() {
		EmptyModule module = new EmptyModule();
		armorCalculator.visit(module);
		assertEquals(0, armorCalculator.getArmor());
	}

}
