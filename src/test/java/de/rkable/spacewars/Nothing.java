package de.rkable.spacewars;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Nothing {

	@Test
	public void nothing() {
		new MainNothing();
		assertEquals(3, new MainNothing().coveredByTest());
	}
}
