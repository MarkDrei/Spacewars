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
	}
	
}
