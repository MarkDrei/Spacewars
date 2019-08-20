package de.rkable.spacewars;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSpaceShipHealthAspects {
	
	private SpaceShipBuilder builder;

	@BeforeEach
	public void initializeBuilder() {
		builder = new SpaceShipBuilder();
	}
	
	@Test
	public void testDefaultHealth() {
		SpaceShip ship = builder.build();
		assertEquals(100.0, ship.getArmor());
		assertEquals(0.0, ship.getShieldCapacity());
	}
	
	@Test
	public void testPredefinedHealth() {
		SpaceShip ship = builder.armor(123).shieldCapacity(234).build();
		assertEquals(123.0, ship.getArmor());
		assertEquals(234.0, ship.getShieldCapacity());
	}
	
	@Test
	public void shipCanHavePartialHealth() {
		SpaceShip ship = builder
				.maxArmor(100)
				.currentArmor(50)
				.maxShieldCapacity(200)
				.currentShieldCapacity(133)
				.build();
		
		assertEquals(50, ship.getArmor());
		assertEquals(133, ship.getShieldCapacity());
	}
	
	@Test
	public void shipCanFullyRegenerate() {
		SpaceShip ship = builder
				.maxArmor(100)
				.currentArmor(50)
				.maxShieldCapacity(200)
				.currentShieldCapacity(133)
				.build();
		ship.repairAll();
		
		assertEquals(100, ship.getArmor());
		assertEquals(200, ship.getShieldCapacity());
	}
	
	@Test
	public void armorCannotBeOvercharged() {
		SpaceShip ship = builder.maxArmor(100).build();
		ship.setCurrentArmor(150);
		assertEquals(100, ship.getArmor());
	}
	
	@Test
	public void shieldCannotBeOvercharged() {
		SpaceShip ship = builder.maxShieldCapacity(100).build();
		ship.setCurrentShieldCapacity(150);
		assertEquals(100, ship.getShieldCapacity());
	}

	@Test 
	public void energyDamageIsDistributed_80percentToShieldWithHalfAbsorbed() {
		SpaceShip ship = builder.armor(100).shieldCapacity(100).build();
		ship.sufferAttack(Attack.energyDamage(100));
		assertEquals(60, ship.getShieldCapacity());
	}
	
	@Test 
	public void energyDamageHitsArmorWith20Percent() {
		SpaceShip ship = builder.armor(100).shieldCapacity(100).build();
		ship.sufferAttack(Attack.energyDamage(100));
		assertEquals(80, ship.getArmor());
	}
	
	@Test
	public void energyDamageFullyHitsArmorWhenShieldIsDown() {
		SpaceShip ship = builder.armor(100).shieldCapacity(10).build();
		ship.sufferAttack(Attack.energyDamage(100));
		assertEquals(0, ship.getShieldCapacity());
		assertEquals(20, ship.getArmor());
	}
	
	@Test
	public void shieldAlwaysGreaterEqualZero() {
		SpaceShip ship = builder.armor(100).shieldCapacity(10).build();
		ship.sufferAttack(Attack.energyDamage(1000));
		ship.sufferAttack(Attack.projectileDamage(1000));
		assertEquals(0, ship.getShieldCapacity());
		
		ship.setCurrentShieldCapacity(-10);
		assertEquals(0, ship.getShieldCapacity());
	}
	
	@Test
	public void projectileDamageisDistributed_80PercentToArmorWithHalfAbsorbed() {
		SpaceShip ship = builder.armor(100).shieldCapacity(100).build();
		ship.sufferAttack(Attack.projectileDamage(100));
		assertEquals(60, ship.getArmor());
	}
	
	@Test
	public void projectileDamageHitsShieldsWith20Percent() {
		SpaceShip ship = builder.armor(100).shieldCapacity(100).build();
		ship.sufferAttack(Attack.projectileDamage(100));
		assertEquals(80, ship.getShieldCapacity());
	}
	
	@Test
	public void armorAlwaysGreaterEqualZero() {
		SpaceShip ship = builder.armor(100).shieldCapacity(0).build();
		ship.sufferAttack(Attack.projectileDamage(1000));
		assertEquals(0, ship.getArmor());
		
		ship.setCurrentArmor(-10);
		assertEquals(0, ship.getArmor());
	}

}
