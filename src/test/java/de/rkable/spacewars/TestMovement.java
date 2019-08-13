package de.rkable.spacewars;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestMovement {
	
	@Test
	public void haltedMoveDoesNotChangePosition() {
		Movement m = new Movement();
		assertEquals(new Position(0, 0), m.getPosition());
	}
	
	@Test
	public void movementEastwardsWithSpeed1() {
		Movement m = new Movement();
		m.setSpeed(1);
		m.setDirection(90);
		
		m.update(1);
		assertEquals(new Position(1, 0), m.getPosition());
	}
	
	@Test
	public void movementEastwardsWithSpeed2() {
		Movement m = new Movement();
		m.setSpeed(2);
		m.setDirection(90);
		
		m.update(1);
		assertEquals(new Position(2, 0), m.getPosition());
	}


}
