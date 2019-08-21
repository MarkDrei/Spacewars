package de.rkable.spacewars;

/**
 * A movement which is restricted to a given rectangle. Any moves which go beyond that
 * rectangle will "teleport" to the adjacent side of that rectangle 
 */
public class RestrictedMovement implements Movement {

	private Movement decoratedMovement;
	private int width;
	private int height;

	/**
	 * 
	 * @param decoratedMovement Another movement, which will be given the 'restricted' property
	 * @param width The width of the restricted area
	 * @param height The height of the restricted area
	 */
	public RestrictedMovement(Movement decoratedMovement, int width, int height) {
		this.decoratedMovement = decoratedMovement;
		this.width = width;
		this.height = height;
	}

	@Override
	public Position getPosition() {
		return decoratedMovement.getPosition();
	}

	@Override
	public void setSpeed(double speed) {
		decoratedMovement.setSpeed(speed);
	}

	@Override
	public void setDirection(double direction) {
		decoratedMovement.setDirection(direction);
	}

	@Override
	public void updatePosition(double elapsedTime) {
		decoratedMovement.updatePosition(elapsedTime);
		Position correctedPosition = correctPosition();
		decoratedMovement.setPosition(correctedPosition);
	}

	private Position correctPosition() {
		Position position = decoratedMovement.getPosition();
		double restrictedY = correctYPosition(position);
		double restrictedX = correctXPosition(position);
		Position correctedPosition = new Position(restrictedX, Math.abs(restrictedY));
		return correctedPosition;
	}

	private double correctXPosition(Position position) {
		double restrictedX = position.x % width;
		if (restrictedX < 0)
			restrictedX += width;
		return restrictedX;
	}

	private double correctYPosition(Position position) {
		double restrictedY = position.y % height;
		if (restrictedY < 0)
			restrictedY += height;
		return restrictedY;
	}

	@Override
	public void setPosition(Position position) {
		decoratedMovement.setPosition(new Position(correctXPosition(position), correctYPosition(position)));
	}

}
