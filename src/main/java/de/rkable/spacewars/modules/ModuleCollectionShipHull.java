package de.rkable.spacewars.modules;

import java.util.HashMap;
import java.util.Map;

import de.rkable.spacewars.IntPosition;
import de.rkable.spacewars.Module;
import de.rkable.spacewars.ShipHull;

public class ModuleCollectionShipHull implements ShipHull {
	
	private Map<IntPosition, Module> modules;

	/**
	 * A predefined Ship Hull: Shape of the hull:
	 * 
	 * <pre>
	 *   X
	 *  XXX
	 * </pre>
	 * 
	 */
	public static ShipHull generateTriangleShipHull() {
		ModuleCollectionShipHull hull = new ModuleCollectionShipHull();
		hull.modules.put(new IntPosition(0, 1), new EmptyModule());
		hull.modules.put(new IntPosition(1, 0), new EmptyModule());
		hull.modules.put(new IntPosition(1, 1), new EmptyModule());
		hull.modules.put(new IntPosition(2, 1), new EmptyModule());
		return hull;
	}
	
	/**
	 * A predefined Ship Hull: Shape of the hull with on module:
	 *  
	 * <pre>
	 *   X
	 * </pre>
	 *  
	 * @return
	 */
	public static ModuleCollectionShipHull generateOnePieceShipHull(double maxArmor) {
		ModuleCollectionShipHull hull = new ModuleCollectionShipHull();
		hull.modules.put(new IntPosition(0, 0), new ArmorModule(maxArmor));
		return hull;
	}

	private ModuleCollectionShipHull() {
		modules = new HashMap<>();
	}

	@Override
	public Map<IntPosition, Module> getModuleSlots() {
		return modules;
	}

	public void addModule(Module module) {
		int nextFreeX = 0;
		for (;;nextFreeX++) {
			if (!modules.containsKey(new IntPosition(nextFreeX, 0)))
				break;
		}
		modules.put(new IntPosition(nextFreeX, 0), module);
		
	}

}
