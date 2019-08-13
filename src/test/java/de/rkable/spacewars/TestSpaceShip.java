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
	
	@Test
	public void spaceshipCanMoveEastWithSpeed1() {
		SpaceShip ship = new SpaceShip();
		ship.setSpeed(1);
		ship.setDirection(90);
		
		ship.update(1);
		assertEquals(new Position(1, 0), ship.getPosition());
	}
	
	@Test
	public void spaceshipCanMoveEastWithSpeed2() {
		SpaceShip ship = new SpaceShip();
		ship.setSpeed(2);
		ship.setDirection(90);
		
		ship.update(1);
		assertEquals(new Position(2, 0), ship.getPosition());
	}

}
