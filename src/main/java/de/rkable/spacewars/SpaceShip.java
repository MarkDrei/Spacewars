package de.rkable.spacewars;

public class SpaceShip {
	
	private Movement movement = new Movement();
	
	public SpaceShip(Movement movement) {
		this.movement = movement;
	}

	public Position getPosition() {
		return movement.getPosition();
	}

	public void setSpeed(double speed) {
		movement.setSpeed(speed);
	}

	public void setDirection(double d) {
		movement.setDirection(d);
	}

	public void update(double elapsedTime) {
		movement.update(elapsedTime);
	}

}
