package de.rkable.spacewars;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestPosition {
	
	@Test
	public void toStringContainsCoordinates() {
		assertTrue(new Position(2, 4).toString().contains("2"));
		assertTrue(new Position(2, 4).toString().contains("4"));
	}

}
