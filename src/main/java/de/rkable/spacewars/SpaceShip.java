package de.rkable.spacewars;

public class SpaceShip implements Movement {
	
	private Movement movement;
	
	public SpaceShip(Movement movement) {
		this.movement = movement;
	}

	@Override
	public Position getPosition() {
		return movement.getPosition();
	}

	@Override
	public void setSpeed(double speed) {
		movement.setSpeed(speed);
	}

	@Override
	public void setDirection(double d) {
		movement.setDirection(d);
	}

	@Override
	public void update(double elapsedTime) {
		movement.update(elapsedTime);
	}

	@Override
	public void setPosition(Position position) {
		movement.setPosition(position);
	}

}
