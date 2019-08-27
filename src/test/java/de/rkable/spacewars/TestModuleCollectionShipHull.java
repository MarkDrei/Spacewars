package de.rkable.spacewars;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

public class TestModuleCollectionShipHull {
	
	@Test
	public void getAvailableModulePositions() {
		ShipHull hull = ModuleCollectionShipHull.generateTriangleShipHull();
		Map<IntPosition, ModuleSlot> slots = hull.getModuleSlots();
		assertEquals(4, slots.size());
		assertTrue(slots.containsKey(new IntPosition(1, 0)));
		assertTrue(slots.containsKey(new IntPosition(0, 1)));
		assertTrue(slots.containsKey(new IntPosition(1, 1)));
		assertTrue(slots.containsKey(new IntPosition(2, 1)));
	}

}
