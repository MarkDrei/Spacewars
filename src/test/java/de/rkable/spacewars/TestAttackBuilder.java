package de.rkable.spacewars;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestAttackBuilder {

	@Test
	public void testAttackBuilder() {
		Attack attack = new AttackBuilder().projectileDamage(2.8).energyDamage(1.1).build();
		assertEquals(2.8, attack.getProjectileDamage());
		assertEquals(1.1, attack.getEnergyDamage());
	}
}
