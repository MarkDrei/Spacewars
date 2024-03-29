package de.rkable.spacewars;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import de.rkable.spacewars.main.SpaceShipBuilder;

public class TestBattle {
	
	SpaceShip ship1 = new SpaceShipBuilder().addTurret().build();
	SpaceShip ship2 = new SpaceShipBuilder().build();
	Battle battle = new Battle(ship1, ship2);
	
	@Test
	public void startedBattleIsNotOver() {
		assertFalse(battle.isOver());
		assertNull(battle.getWinner());
	}
	
	@Test
	public void battleIsOverWhenFirstShipHasZeroArmor() {
		ship1.setCurrentArmor(0);
		assertTrue(battle.isOver());
		assertSame(battle.getWinner(), ship2);
	}
	
	@Test
	public void battleIsOverWhenSecondShipHasZeroArmor() {
		ship2.setCurrentArmor(0);
		assertTrue(battle.isOver());
		assertSame(battle.getWinner(), ship1);
	}
	
	@Test
	public void battleUpdateIsReflectedCorrectlyInNextAttack() {
		assertEquals(0, ship1.getTimeUntilNextAttack());
		battle.update(1.0);
		assertEquals(4, ship1.getTimeUntilNextAttack());
	}
	
	@Test
	public void battleEndsAfterSomeTimeAndTheShipWithTheWeaponWins() {
		battle.update(0.0);
		assertFalse(battle.isOver());
		battle.update(1);
		battle.update(1);
		assertFalse(battle.isOver());
		battle.update(5000);
		assertTrue(battle.isOver());
		assertSame(battle.getWinner(), ship1);
	}
	
	@Test
	public void battleEndsAfterSomeTimeAndTheShipWithTwoWeaponWins() {
		ship2 = new SpaceShipBuilder().addTurret().addTurret().build();
		battle = new Battle(ship1, ship2);

		battle.update(5000);
		assertTrue(battle.isOver());
		assertSame(battle.getWinner(), ship2);
	}
	
	

}
