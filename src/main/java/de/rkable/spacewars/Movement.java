package de.rkable.spacewars;

public interface Movement {

	Position getPosition();

	void setSpeed(double speed);

	void setDirection(double direction);

	void updatePosition(double elapsedTime);

	void setPosition(Position position);

}