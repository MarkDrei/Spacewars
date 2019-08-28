package de.rkable.spacewars;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestIntPosition {

	@Test
	public void hashCodeForEqualPositions() {
		assertEquals(new IntPosition(0, 2).hashCode(), new IntPosition(0, 2).hashCode());
		assertEquals(new IntPosition(1, 2).hashCode(), new IntPosition(1, 2).hashCode());
		assertEquals(new IntPosition(2, 1).hashCode(), new IntPosition(2, 1).hashCode());
	}

	@Test
	public void hashCodeForDifferentPositionsUsuallyDifferent() {
		assertNotEquals(new IntPosition(0, 2).hashCode(), new IntPosition(1, 2).hashCode());
		assertNotEquals(new IntPosition(2, 2).hashCode(), new IntPosition(1, 2).hashCode());
		assertNotEquals(new IntPosition(0, 1).hashCode(), new IntPosition(1, 2).hashCode());
	}

	@Test
	public void equalToItself() {
		IntPosition position = new IntPosition(0, 0);
		assertTrue(position.equals(position));
	}

	@Test
	public void sameCoordinateIsEqual() {
		assertEquals(new IntPosition(0, 0), new IntPosition(0, 0));
		assertEquals(new IntPosition(1, 2), new IntPosition(1, 2));
		assertEquals(new IntPosition(555, -123), new IntPosition(555, -123));
	}

	@Test
	public void notEquals() {
		IntPosition position = new IntPosition(2, 3);
		assertFalse(position.equals(new IntPosition(2, 2)));
		assertFalse(position.equals(new IntPosition(3, 3)));
		assertFalse(position.equals(new Object()));
		assertFalse(position.equals(null));
	}
}
