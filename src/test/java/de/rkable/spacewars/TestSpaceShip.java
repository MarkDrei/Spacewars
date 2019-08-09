package de.rkable.spacewars;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestSpaceShip {
	
	@Test
	public void haltedShipDoesNotMove() {
		SpaceShip ship = new SpaceShip();
		assertEquals(new Position(0, 0), ship.getPosition());
		// give ship a pos, direction and speed
		// wait time x
		// check position
	}

}
