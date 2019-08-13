package de.rkable.spacewars;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestMovement {
	
	@Test
	public void haltedMoveDoesNotChangePosition() {
		Movement m = new Movement();
		assertPositionsAreEqual(new Position(0, 0), m.getPosition());
	}
	
	@Test
	public void movementEastwardsWithSpeed1() {
		Movement m = new Movement();
		m.setSpeed(1);
		m.setDirection(90);
		
		m.update(1);
		assertPositionsAreEqual(new Position(1, 0), m.getPosition());
	}
	
	@Test
	public void movementEastwardsWithSpeed2() {
		Movement m = new Movement();
		m.setSpeed(2);
		m.setDirection(90);
		
		m.update(1);
		assertPositionsAreEqual(new Position(2, 0), m.getPosition());
	}
	
	@Test
	public void movementEastwardsWithSpeed2Duration2() {
		Movement m = new Movement();
		m.setSpeed(2);
		m.setDirection(90);
		
		m.update(2);
		assertPositionsAreEqual(new Position(4, 0), m.getPosition());
	}
	
	@Test
	public void movementSouthwardsWithSpeed1() {
		Movement m = new Movement();
		m.setSpeed(1);
		m.setDirection(180);
		
		m.update(1);
		assertPositionsAreEqual(new Position(0, 1), m.getPosition());
	}
	
	@Test
	public void moveEastSouthWestNorth() {
		Movement m = new Movement();
		m.setSpeed(1);
		m.setDirection(90);
		m.update(1);
		assertPositionsAreEqual(new Position(1, 0), m.getPosition());
		
		m.setDirection(180);
		m.update(1);
		assertPositionsAreEqual(new Position(1, 1), m.getPosition());
		
		m.setDirection(270);
		m.update(1);
		assertPositionsAreEqual(new Position(0, 1), m.getPosition());
		
		m.setDirection(360);
		m.update(1);
		assertPositionsAreEqual(new Position(0, 0), m.getPosition());
	}
	
	private void assertPositionsAreEqual(Position expected, Position actual) {
		assertEquals(expected.x, actual.x, 0.01);
		assertEquals(expected.y, actual.y, 0.01);
	}


}
