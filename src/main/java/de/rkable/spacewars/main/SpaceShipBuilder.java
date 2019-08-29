package de.rkable.spacewars.main;

import java.util.ArrayList;
import java.util.List;

import de.rkable.spacewars.AttackBuilder;
import de.rkable.spacewars.ShipHull;
import de.rkable.spacewars.SpaceShip;
import de.rkable.spacewars.Weapon;
import de.rkable.spacewars.modules.ArmorCalculatingVisitor;
import de.rkable.spacewars.modules.ModuleCollectionShipHull;
import de.rkable.spacewars.modules.WeaponCollectingVisitor;
import de.rkable.spacewars.modules.WeaponModule;
import de.rkable.spacewars.movement.RestrictedMovement;
import de.rkable.spacewars.movement.SimpleMovement;

public class SpaceShipBuilder {

	private static final int DEFAULT_ARMOR = 100;
	private static final int DEFAULT_SHIELD = 0;
	private static final int WORLD_SIZE = 100;
	
	private double currentArmor = DEFAULT_ARMOR;
	private double maxArmor = DEFAULT_ARMOR;
	private double maxShieldCapacity = DEFAULT_SHIELD;
	private double currentShieldCapacity = DEFAULT_SHIELD;
	
	private List<Weapon> weapons = new ArrayList<>();
	
	public SpaceShip build() {
		SpaceShip spaceShip = new SpaceShip(
				buildMovement(), 
				new ArmorCalculatingVisitor(), 
				new WeaponCollectingVisitor());
		spaceShip.setShipHull(buildHull());
		spaceShip.setCurrentArmor(currentArmor);
		spaceShip.setMaxShieldCapacity(maxShieldCapacity);
		spaceShip.setCurrentShieldCapacity(currentShieldCapacity);
		
		return spaceShip;
	}

	private ShipHull buildHull() {
		ModuleCollectionShipHull hull = ModuleCollectionShipHull.generateOnePieceShipHull(maxArmor);
		for (Weapon weapon : weapons) {
			hull.addModule(new WeaponModule(weapon));
		}
		return hull;
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

	public SpaceShipBuilder addTurret() {
		weapons.add(new Weapon(new AttackBuilder().projectileDamage(2), 5.0));
		return this;
	}

	public SpaceShipBuilder addTurret(Weapon weapon) {
		weapons.add(weapon);
		return this;
	}

}
