package de.rkable.spacewars;

public class SpaceShip implements Movement {
	
	private Movement movement;
	private double maxArmor;
	private double currentArmor;
	private double currentShieldCapacity;
	private double maxShieldCapacity;
	
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

	public double getArmor() {
		return currentArmor;
	}

	public double getShieldCapacity() {
		return currentShieldCapacity;
	}

	public void setMaxArmor(double armor) {
		this.maxArmor = armor;
	}

	public void setCurrentArmor(double armor) {
		currentArmor = armor;
		autocorrectArmor();
	}
	
	public void sufferAttack(Attack attack) {
		currentShieldCapacity -= 0.8 * attack.getEnergyDamage() / 2;
		double excessiveShieldDamage = 0;
		if (currentShieldCapacity < 0) {
			excessiveShieldDamage = -2 * currentShieldCapacity;
			currentShieldCapacity = 0;
		}
		currentArmor -=  0.2 * attack.getEnergyDamage();
		currentArmor -= excessiveShieldDamage;
		
		currentArmor -= 0.8 * attack.getProjectileDamage() / 2;
		currentShieldCapacity -= 0.2 * attack.getProjectileDamage();
		
		autocorrectArmor();
		autocorrectShieldCapacity();
	}

	private void autocorrectArmor() {
		currentArmor = Math.min(currentArmor, maxArmor);
		currentArmor = Math.max(0, currentArmor);
	}

	private void autocorrectShieldCapacity() {
		currentShieldCapacity = Math.min(currentShieldCapacity, maxShieldCapacity);
		currentShieldCapacity = Math.max(0, currentShieldCapacity);
	}

	public void repairAll() {
		currentArmor = maxArmor;
		currentShieldCapacity = maxShieldCapacity;
	}

	public void setMaxShieldCapacity(double shieldCapacity) {
		maxShieldCapacity = shieldCapacity;
	}

	public void setCurrentShieldCapacity(double shieldCapacity) {
		currentShieldCapacity = shieldCapacity;
		autocorrectShieldCapacity();
	}

}
