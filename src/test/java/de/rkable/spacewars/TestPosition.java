package de.rkable.spacewars;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestPosition {
	
	@Test
	public void positionsWithSameCoordinatesEqualEachOther() {
		assertEquals(new Position(0, 0), new Position(0, 0));
		assertEquals(new Position(1, 2), new Position(1, 2));
	}
	
	@Test
	public void equalToItself() {
		Position position = new Position(0, 0);
		assertEquals(position, position);
	}
	
	@Test
	public void positionsWithSameCoordinatesHaveSameHashcode() {
		assertEquals(new Position(0, 0).hashCode(), new Position(0, 0).hashCode());
		assertEquals(new Position(1, 2).hashCode(), new Position(1, 2).hashCode());
	}
	
	@Test
	public void positionsWithDifferentCoordinatesDontEachOther() {
		assertNotEquals(new Position(1, 0), new Position(0, 0));
		assertNotEquals(new Position(1, 0), new Position(1, 1));
	}
	
	@Test
	public void positionsWithDifferentCoordinateHaveDifferentHashcodesInGeneral() {
		assertNotEquals(new Position(1, 0).hashCode(), new Position(0, 0).hashCode());
		assertNotEquals(new Position(1, 0).hashCode(), new Position(0, 1).hashCode());
	}
	
	@Test
	public void differentClassesAreNotEqual() {
		assertFalse(new Position(1, 0).equals(new Object()));
		assertFalse(new Position(1, 0).equals(null));
	}

}
