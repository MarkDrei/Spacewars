package de.rkable.spacewars;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestMovement {
	
	Movement movement = new SimpleMovement();
	
	@Test
	public void haltedMoveDoesNotChangePosition() {
		assertPositionsAreEqual(new Position(0, 0), movement.getPosition());
	}
	
	@Test
	public void movementEastwardsWithSpeed1() {
		movement.setSpeed(1);
		movement.setDirection(90);
		
		movement.update(1);
		assertPositionsAreEqual(new Position(1, 0), movement.getPosition());
	}
	
	@Test
	public void movementEastwardsWithSpeed2() {
		movement.setSpeed(2);
		movement.setDirection(90);
		
		movement.update(1);
		assertPositionsAreEqual(new Position(2, 0), movement.getPosition());
	}
	
	@Test
	public void movementEastwardsWithSpeed2Duration2() {
		movement.setSpeed(2);
		movement.setDirection(90);
		
		movement.update(2);
		assertPositionsAreEqual(new Position(4, 0), movement.getPosition());
	}
	
	@Test
	public void movementSouthwardsWithSpeed1() {
		movement.setSpeed(1);
		movement.setDirection(180);
		
		movement.update(1);
		assertPositionsAreEqual(new Position(0, 1), movement.getPosition());
	}
	
	@Test
	public void moveEastSouthWestNorth() {
		movement.setSpeed(1);
		movement.setDirection(90);
		movement.update(1);
		assertPositionsAreEqual(new Position(1, 0), movement.getPosition());
		
		movement.setDirection(180);
		movement.update(1);
		assertPositionsAreEqual(new Position(1, 1), movement.getPosition());
		
		movement.setDirection(270);
		movement.update(1);
		assertPositionsAreEqual(new Position(0, 1), movement.getPosition());
		
		movement.setDirection(360);
		movement.update(1);
		assertPositionsAreEqual(new Position(0, 0), movement.getPosition());
	}
	
	@Test
	public void moveSouthEast() {
		movement.setSpeed(1);
		movement.setDirection(135);
		movement.update(2);
		
		assertPositionsAreEqual(new Position(1.41, 1.41), movement.getPosition());
	}
	
	@Test
	public void moveSouthSouthEast() {
		Movement m = new SimpleMovement();
		m.setSpeed(1);
		m.setDirection(165);
		m.update(2);
		
		assertPositionsAreEqual(new Position(0.51, 1.93), m.getPosition());
	}
	
	private void assertPositionsAreEqual(Position expected, Position actual) {
		assertEquals(expected.x, actual.x, 0.01, "Expected X coordinate of " + actual + " == " + expected);
		assertEquals(expected.y, actual.y, 0.01, "Expected Y coordinate of " + actual + " == " + expected);
	}

}
