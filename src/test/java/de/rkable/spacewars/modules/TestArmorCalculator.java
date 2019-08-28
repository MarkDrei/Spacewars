package de.rkable.spacewars.modules;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import de.rkable.spacewars.SpaceShip;
import de.rkable.spacewars.SpaceShipBuilder;

public class TestArmorCalculator {
	
	ArmorCalculator armorCalculator = new ArmorCalculator();

	@Test
	public void getArmorFromModules() {
		SpaceShip ship = new SpaceShipBuilder().build();
		ship.accept(armorCalculator);
		assertEquals(100, armorCalculator.getArmor());
	}
	
	@Test
	public void multipleVisitsLeadToTheSameResults() {
		SpaceShip ship = new SpaceShipBuilder().build();
		ship.accept(armorCalculator);
		assertEquals(100, armorCalculator.getArmor());
		ship.accept(armorCalculator);
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
		module.accept(armorCalculator);
		assertEquals(0, armorCalculator.getArmor());
	}

}
