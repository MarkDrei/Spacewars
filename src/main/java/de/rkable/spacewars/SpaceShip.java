package de.rkable.spacewars;

public class SpaceShip {
	
	private Position position = new Position(0, 0);
	private double speed;

	public Position getPosition() {
		return position;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void setDirection(int i) {
	}

	public void update(double elapsedTime) {
		position = new Position((int) speed, 0);
	}

}
