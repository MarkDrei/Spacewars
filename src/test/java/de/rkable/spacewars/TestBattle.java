package de.rkable.spacewars;

import org.junit.jupiter.api.Test;

public class TestBattle {
	
	@Test
	public void twoShipsCanEnterBattle() {
		SpaceShip ship1 = new SpaceShipBuilder().build();
		SpaceShip ship2 = new SpaceShipBuilder().build();
		new Battle(ship1, ship2);
	}

}
