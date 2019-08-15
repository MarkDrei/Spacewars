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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(double elapsedTime) {
		decoratedMovement.update(elapsedTime);
		Position position = decoratedMovement.getPosition();
		double restrictedY = position.y % height;
		if (restrictedY < 0)
			restrictedY += height;
		decoratedMovement.setPosition(new Position(0, Math.abs(restrictedY)));
		
	}

	@Override
	public void setPosition(Position position) {
		// TODO Auto-generated method stub
		
	}

}
