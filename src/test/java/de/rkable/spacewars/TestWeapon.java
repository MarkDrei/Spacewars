package de.rkable.spacewars;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestWeapon {
	
	private Weapon weapon;
	
	@BeforeEach
	public void setup() {
		AttackBuilder attackBuilder = new AttackBuilder().projectileDamage(10);
		weapon = new Weapon(attackBuilder, 5.0);
	}

	@Test
	public void firstAttackIsDirectlyReady() {
		assertEquals(0.0, weapon.getTimeUntilNextAttack());
	}
	
	@Test
	public void attackIsPredefined() {
		List<Attack> attacks = weapon.getNextAttacks(0);
		assertEquals(1, attacks.size());
		assertEquals(10, attacks.get(0).getProjectileDamage());
		assertEquals(0, attacks.get(0).getEnergyDamage());
	}
	
	@Test
	public void timeUntilAttackResets() {
		weapon.getNextAttacks(0);
		assertEquals(5, weapon.getTimeUntilNextAttack());
	}
	
	@Test 
	public void timeUntilAttacksCountsDown() {
		List<Attack> nextAttacks = weapon.getNextAttacks(2);
		assertEquals(1, nextAttacks.size());
		assertEquals(3, weapon.getTimeUntilNextAttack());
		
		nextAttacks = weapon.getNextAttacks(2);
		assertEquals(0, nextAttacks.size());
		assertEquals(1, weapon.getTimeUntilNextAttack());
	}
	
	@Test
	public void multipleAttacks() {
		List<Attack> nextAttacks = weapon.getNextAttacks(5);
		assertEquals(2, nextAttacks.size());
		nextAttacks = weapon.getNextAttacks(4);
		assertEquals(0, nextAttacks.size());
		nextAttacks = weapon.getNextAttacks(25);
		assertEquals(5, nextAttacks.size());
	}
}
