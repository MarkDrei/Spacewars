package de.rkable.spacewars;

public class Movement {

	private Position position = new Position(0, 0);
	private double speed;
	private double direction;

	public Position getPosition() {
		return position;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}

	public void update(double elapsedTime) {
		double mathAngle = 90 - direction;
		double movementX = elapsedTime * speed * Math.cos(Math.toRadians(mathAngle));
		double movementY = elapsedTime * speed * Math.sin(Math.toRadians(mathAngle));
		position = new Position(position.x + movementX, position.y - movementY);
	}

}
