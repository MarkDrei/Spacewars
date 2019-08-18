package de.rkable.spacewars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestRestrictedMovement extends MovementTests {

	public TestRestrictedMovement() {
		super(new RestrictedMovement(new SimpleMovement(), 2, 3));
	}

	@BeforeEach
	public void setup() {
		movement.setSpeed(1);
	}
	
	@Test
	public void noRestrictedMove() {
		assertPositionsAreEqual(new Position(0, 0));
	}
	
	@Test
	public void testRestrictionTowardsNorth() {
		movement.update(1);
		assertPositionsAreEqual(new Position(0, 2));
		
		movement.update(3);
		assertPositionsAreEqual(new Position(0, 2));
	}
	
	@Test
	public void testRestrictionTowardsNorthMultipleOverruns() {
		movement.update(101);
		assertPositionsAreEqual(new Position(0, 1));
	}

	@Test
	public void testRestrictionTowardsEast() {
		movement.setDirection(90);
		movement.update(3);
		
		assertPositionsAreEqual(new Position(1, 0));
	}
	
	@Test
	public void testRestrictionTowardsWest() {
		movement.setDirection(270);
		movement.update(0.5);
		
		assertPositionsAreEqual(new Position(1.5, 0));
	}
	
	@Test
	public void testRestrictionTowardsSouth() {
		movement.setDirection(180);
		movement.update(2.99);
		assertPositionsAreEqual(new Position(0, 2.99));
		
		movement.update(0.02);
		assertPositionsAreEqual(new Position(0, 0.01));
	}
	
	@Test
	public void testRestrictionOnSetPosition() {
		movement.setPosition(new Position(18, 18));
		assertPositionsAreEqual(new Position(0, 0));
		
		movement.setPosition(new Position(19, 19));
		assertPositionsAreEqual(new Position(1, 1));
	}
}
