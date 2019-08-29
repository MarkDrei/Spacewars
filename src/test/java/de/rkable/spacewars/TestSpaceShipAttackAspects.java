package de.rkable.spacewars;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.rkable.spacewars.main.SpaceShipBuilder;

public class TestSpaceShipAttackAspects {
	
	@Test
	public void noTurretNoAttacks() {
		SpaceShip ship = new SpaceShipBuilder().build();
		assertEquals(Double.POSITIVE_INFINITY, ship.getTimeUntilNextAttack());
	}

	@Test
	public void firstAttackIsDirectlyReady() {
		SpaceShip ship = new SpaceShipBuilder().addTurret().build();
		assertEquals(0.0, ship.getTimeUntilNextAttack());
	}
	
	@Test
	public void getAttack() {
		// attack interval is 5
		SpaceShip ship = new SpaceShipBuilder().addTurret().build();
		List<Attack> attacks = ship.getNextAttacks(3); // 3 in total - attack at 0
		assertEquals(1, attacks.size());
		
		attacks = ship.getNextAttacks(3); // 6 in total - attack at 5
		assertEquals(1, attacks.size());
		
		attacks = ship.getNextAttacks(3); // 9 in total - no attack (10 is next)
		assertEquals(0, attacks.size());
	}
	
	@Test
	public void getAttackFromTwoTurrets() {
		// attack interval is 5 and 4
		SpaceShip ship = new SpaceShipBuilder()
				.addTurret()
				.addTurret(new Weapon(new AttackBuilder().projectileDamage(2), 4.0))
				.build();
		
		List<Attack> attacks = ship.getNextAttacks(3); // 3 in total - attack at 0
		assertEquals(2, attacks.size());
		
		attacks = ship.getNextAttacks(3); // 6 in total - attack at 4 and 5
		assertEquals(2, attacks.size());
		
		attacks = ship.getNextAttacks(3); // 9 in total - attack at 8
		assertEquals(1, attacks.size());
		
		attacks = ship.getNextAttacks(3); // 12 in total - attack at 10 and 12
		assertEquals(2, attacks.size());
	}
	
	@Test
	public void testTimeUntilNextShotWithTwoTurrets() {
		// attack interval is 5 and 4
		SpaceShip ship = new SpaceShipBuilder()
				.addTurret()
				.addTurret(new Weapon(new AttackBuilder().projectileDamage(2), 4.0))
				.build();
		
		assertEquals(0, ship.getTimeUntilNextAttack());
		ship.getNextAttacks(0); // 0 in total - 2 attack at 0
		assertEquals(4, ship.getTimeUntilNextAttack());
		
		ship.getNextAttacks(3.5); // 3.5 in total
		assertEquals(0.5, ship.getTimeUntilNextAttack());
		
		ship.getNextAttacks(0.5); // 4 in total - 1 attack at 4
		assertEquals(1, ship.getTimeUntilNextAttack());
		
		ship.getNextAttacks(1); // 5 in total - 1 attack at 5
		assertEquals(3, ship.getTimeUntilNextAttack());
	}
	
}
