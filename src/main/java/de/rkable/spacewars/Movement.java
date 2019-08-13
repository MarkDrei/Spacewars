package de.rkable.spacewars;

public class Movement {

	private Position position = new Position(0, 0);
	private double speed;

	public Position getPosition() {
		return position;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void setDirection(double d) {
	}

	public void update(double elapsedTime) {
		position = new Position((int) speed, 0);
	}

}
