package de.rkable.spacewars;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestBattle {
	
	SpaceShip ship1 = new SpaceShipBuilder().build();
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
		assertTrue(battle.getWinner() == ship2);
	}
	
	@Test
	public void battleIsOverWhenSecondShipHasZeroArmor() {
		ship2.setCurrentArmor(0);
		assertTrue(battle.isOver());
		assertTrue(battle.getWinner() == ship1);
	}
	
	@Disabled
	@Test
	public void battleEndsAfterSomeTime() {
		battle.update(0.0);
		assertFalse(battle.isOver());
		battle.update(5000);
		assertTrue(battle.isOver());
	}
	
	

}
