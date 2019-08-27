package de.rkable.spacewars;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SpaceShip implements Movement, ShipHull {
	
	private final Movement movement;
	private ShipHull hull;
	
	private List<Weapon> weapons = new ArrayList<>();
	
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
	public void updatePosition(double elapsedTime) {
		movement.updatePosition(elapsedTime);
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
	
	public void addWeapon(Weapon weapon) {
		weapons.add(weapon);
	}

	public double getTimeUntilNextAttack() {
		double timeUntilNextAttack = Double.POSITIVE_INFINITY;
		for (Weapon weapon : weapons) {
			timeUntilNextAttack = Math.min(timeUntilNextAttack, weapon.getTimeUntilNextAttack());
		}
		
		return timeUntilNextAttack;
	}

	public List<Attack> getNextAttacks(double elapsedTime) {
		List<Attack> attacks = new ArrayList<>();
		
		for (Weapon weapon : weapons) {
			attacks.addAll(weapon.getNextAttacks(elapsedTime));
		}
		
		return attacks;
	}

	@Override
	public Map<IntPosition, ModuleSlot> getModuleSlots() {
		return null;
	}

	// package visibility for testing only
	ShipHull getShipHull() {
		return hull;
	}

	public void setShipHull(ShipHull generateOnePieceShipHull) {
		this.hull = generateOnePieceShipHull;
	}

}
