package de.rkable.spacewars;

public class SpaceShipBuilder {

	private static final int DEFAULT_ARMOR = 100;
	private static final int WORLD_SIZE = 100;
	
	private double currentArmor = DEFAULT_ARMOR;
	private double maxArmor = 100;
	private double maxShieldCapacity;
	private double currentShieldCapacity;
	
	public SpaceShip build() {
		SpaceShip spaceShip = new SpaceShip(buildMovement());
		spaceShip.setMaxArmor(maxArmor);
		spaceShip.setCurrentArmor(currentArmor);
		spaceShip.setMaxShieldCapacity(maxShieldCapacity);
		spaceShip.setCurrentShieldCapacity(currentShieldCapacity);
		return spaceShip;
	}

	private RestrictedMovement buildMovement() {
		return new RestrictedMovement(new SimpleMovement(), WORLD_SIZE, WORLD_SIZE);
	}

	public SpaceShipBuilder armor(double armor) {
		return maxArmor(armor).currentArmor(armor);
	}

	public SpaceShipBuilder shieldCapacity(double shieldCapacity) {
		return maxShieldCapacity(shieldCapacity).currentShieldCapacity(shieldCapacity);
	}

	public SpaceShipBuilder maxArmor(double armor) {
		maxArmor = armor;
		return this;
	}

	public SpaceShipBuilder currentArmor(double armor) {
		currentArmor = armor;
		return this;
	}

	public SpaceShipBuilder maxShieldCapacity(double shieldCapacity) {
		maxShieldCapacity = shieldCapacity;
		return this;
	}

	public SpaceShipBuilder currentShieldCapacity(double shieldCapacity) {
		currentShieldCapacity = shieldCapacity;
		return this;
	}

}
