package de.rkable.spacewars;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSpaceShipBuilder {
	
	private SpaceShipBuilder builder;

	@BeforeEach
	public void setup() {
		builder = new SpaceShipBuilder();
	}

	@Test
	public void canGenerateDefaultSpaceShip() {
		assertNotNull(builder.build());
	}
	
	@Test
	public void builderIsRobustAgainstArmorOrder() {
		SpaceShip ship = new SpaceShipBuilder().maxArmor(1000).currentArmor(1500).build();
		assertEquals(1000, ship.getArmor());
		
		ship = new SpaceShipBuilder().currentArmor(1500).maxArmor(1000).build();
		assertEquals(1000, ship.getArmor());
	}
	
	@Test
	public void builderIsRobustAgainstShieldOrder() {
		SpaceShip ship = new SpaceShipBuilder().maxShieldCapacity(1000).currentShieldCapacity(1500).build();
		assertEquals(1000, ship.getShieldCapacity());
		
		ship = new SpaceShipBuilder().currentShieldCapacity(1500).maxShieldCapacity(1000).build();
		assertEquals(1000, ship.getShieldCapacity());
	}
}
