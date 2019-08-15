package de.rkable.spacewars;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestSpaceShip {
	
	private class MovementMock extends Movement {
		Position position = new Position(0, 0);
		double elapsedTime;
		double speed;
		public double direction;

		@Override
		public void update(double elapsedTime) {
			this.elapsedTime = elapsedTime;
		}
		
		
		@Override
		public void setSpeed(double speed) {
			this.speed = speed;
		}
		
		@Override
		public Position getPosition() {
			return position;
		}
		
		@Override
		public void setDirection(double directioni) {
			this.direction = directioni;
		}
	}
	
	@Test
	public void callsAreForwardedToMovement() {
		MovementMock movementMock = new MovementMock();
		SpaceShip ship = new SpaceShip(movementMock);
		ship.update(1.1);
		assertEquals(1.1, movementMock.elapsedTime);
		
		ship.setSpeed(2.2);
		assertEquals(2.2, movementMock.speed);
		
		ship.setDirection(42.42);
		assertEquals(42.42, movementMock.direction);
	}
	
	@Test
	public void gettersAreForwardedToMovement() {
		MovementMock movementMock = new MovementMock();
		SpaceShip ship = new SpaceShip(movementMock);
		
		assertTrue(movementMock.position == ship.getPosition());
	}

}