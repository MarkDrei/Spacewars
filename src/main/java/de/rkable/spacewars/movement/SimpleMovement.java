package de.rkable.spacewars.movement;

import de.rkable.spacewars.Movement;
import de.rkable.spacewars.Position;

public class SimpleMovement implements Movement {

	private Position position = new Position(0, 0);
	private double speed;
	private double direction;

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	@Override
	public void setDirection(double direction) {
		this.direction = direction;
	}

	@Override
	public void updatePosition(double elapsedTime) {
		double mathAngle = 90 - direction;
		double movementX = elapsedTime * speed * Math.cos(Math.toRadians(mathAngle));
		double movementY = elapsedTime * speed * Math.sin(Math.toRadians(mathAngle));
		position = new Position(position.x + movementX, position.y - movementY);
	}

	@Override
	public void setPosition(Position position) {
		this.position = position;
	}

}
