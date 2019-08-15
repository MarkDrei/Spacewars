package de.rkable.spacewars;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovementTests {
	
	protected Movement movement;
	
	public MovementTests(Movement movement) {
		this.movement = movement;
	}


	protected void assertPositionsAreEqual(Position expected) {
		Position actual = movement.getPosition();
		assertEquals(expected.x, actual.x, 0.01, "Expected X coordinate of " + actual + " == " + expected);
		assertEquals(expected.y, actual.y, 0.01, "Expected Y coordinate of " + actual + " == " + expected);
	}

}