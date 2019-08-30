package de.rkable.spacewars;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SpaceShip implements Movement, ShipHull {
	
	private final Movement movement;
	private ShipHull hull;
	
	private double currentArmor;
	private double currentShieldCapacity;
	private double maxShieldCapacity;
	private ArmorCalculator armorCalculator;
	private WeaponCollector weaponCollector;
	
	public SpaceShip(Movement movement, ArmorCalculator armorCalculator, WeaponCollector weaponCollector) {
		this.movement = movement;
		this.armorCalculator = armorCalculator;
		this.weaponCollector = weaponCollector;
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

	private double getMaxArmor() {
		return armorCalculator.getArmor();
	}
	
	private void autocorrectArmor() {
		currentArmor = Math.min(currentArmor, getMaxArmor());
		currentArmor = Math.max(0, currentArmor);
	}

	private void autocorrectShieldCapacity() {
		currentShieldCapacity = Math.min(currentShieldCapacity, maxShieldCapacity);
		currentShieldCapacity = Math.max(0, currentShieldCapacity);
	}

	public void repairAll() {
		currentArmor = getMaxArmor();
		currentShieldCapacity = maxShieldCapacity;
	}

	public void setMaxShieldCapacity(double shieldCapacity) {
		maxShieldCapacity = shieldCapacity;
	}

	public void setCurrentShieldCapacity(double shieldCapacity) {
		currentShieldCapacity = shieldCapacity;
		autocorrectShieldCapacity();
	}
	
	public double getTimeUntilNextAttack() {
		double timeUntilNextAttack = Double.POSITIVE_INFINITY;
		for (Weapon weapon : getWeapons()) {
			timeUntilNextAttack = Math.min(timeUntilNextAttack, weapon.getTimeUntilNextAttack());
		}
		
		return timeUntilNextAttack;
	}
	
	private List<Weapon> getWeapons() {
		return weaponCollector.getWeapons();
	}

	public List<Attack> getNextAttacks(double elapsedTime) {
		List<Attack> attacks = new ArrayList<>();
		
		for (Weapon weapon : getWeapons()) {
			attacks.addAll(weapon.getNextAttacks(elapsedTime));
		}
		
		return attacks;
	}

	@Override
	public Map<IntPosition, Module> getModuleSlots() {
		return hull.getModuleSlots();
	}

	// public visibility for testing only
	public ShipHull getShipHull() {
		return hull;
	}

	public void setShipHull(ShipHull hull) {
		this.hull = hull;
	}

}
