package de.rkable.spacewars.movement;

import org.junit.jupiter.api.Test;

import de.rkable.spacewars.Position;
import de.rkable.spacewars.movement.SimpleMovement;

public class TestMovement extends MovementTests {
	
	public TestMovement() {
		super( new SimpleMovement());
	}
	
	@Test
	public void haltedMoveDoesNotChangePosition() {
		assertPositionsAreEqual(new Position(0, 0));
	}
	
	@Test
	public void movementEastwardsWithSpeed1() {
		movement.setSpeed(1);
		movement.setDirection(90);
		
		movement.updatePosition(1);
		assertPositionsAreEqual(new Position(1, 0));
	}
	
	@Test
	public void movementEastwardsWithSpeed2() {
		movement.setSpeed(2);
		movement.setDirection(90);
		
		movement.updatePosition(1);
		assertPositionsAreEqual(new Position(2, 0));
	}
	
	@Test
	public void movementEastwardsWithSpeed2Duration2() {
		movement.setSpeed(2);
		movement.setDirection(90);
		
		movement.updatePosition(2);
		assertPositionsAreEqual(new Position(4, 0));
	}
	
	@Test
	public void movementSouthwardsWithSpeed1() {
		movement.setSpeed(1);
		movement.setDirection(180);
		
		movement.updatePosition(1);
		assertPositionsAreEqual(new Position(0, 1));
	}
	
	@Test
	public void moveEastSouthWestNorth() {
		movement.setSpeed(1);
		movement.setDirection(90);
		movement.updatePosition(1);
		assertPositionsAreEqual(new Position(1, 0));
		
		movement.setDirection(180);
		movement.updatePosition(1);
		assertPositionsAreEqual(new Position(1, 1));
		
		movement.setDirection(270);
		movement.updatePosition(1);
		assertPositionsAreEqual(new Position(0, 1));
		
		movement.setDirection(360);
		movement.updatePosition(1);
		assertPositionsAreEqual(new Position(0, 0));
	}
	
	@Test
	public void moveSouthEast() {
		movement.setSpeed(1);
		movement.setDirection(135);
		movement.updatePosition(2);
		
		assertPositionsAreEqual(new Position(1.41, 1.41));
	}
	
	@Test
	public void moveSouthSouthEast() {
		movement.setSpeed(1);
		movement.setDirection(165);
		movement.updatePosition(2);
		
		assertPositionsAreEqual(new Position(0.51, 1.93));
	}
	
	@Test
	public void overwritePosition() {
		movement.setPosition(new Position(23, 42));
		assertPositionsAreEqual(new Position(23, 42));
	}

}
