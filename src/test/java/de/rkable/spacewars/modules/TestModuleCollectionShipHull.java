package de.rkable.spacewars.modules;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import de.rkable.spacewars.IntPosition;
import de.rkable.spacewars.Module;
import de.rkable.spacewars.ShipHull;
import de.rkable.spacewars.modules.ModuleCollectionShipHull;

public class TestModuleCollectionShipHull {
	
	@Test
	public void getAvailableModulePositions() {
		ShipHull hull = ModuleCollectionShipHull.generateTriangleShipHull();
		Map<IntPosition, Module> slots = hull.getModuleSlots();
		assertEquals(4, slots.size());
		assertTrue(slots.containsKey(new IntPosition(1, 0)));
		assertTrue(slots.containsKey(new IntPosition(0, 1)));
		assertTrue(slots.containsKey(new IntPosition(1, 1)));
		assertTrue(slots.containsKey(new IntPosition(2, 1)));
	}

}
