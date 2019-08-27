package de.rkable.spacewars;

import java.util.HashMap;
import java.util.Map;

public class ModuleCollectionShipHull implements ShipHull {
	
	private Map<IntPosition, ModuleSlot> modules;

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
		hull.modules.put(new IntPosition(0, 1), new EmptyModuleSlot());
		hull.modules.put(new IntPosition(1, 0), new EmptyModuleSlot());
		hull.modules.put(new IntPosition(1, 1), new EmptyModuleSlot());
		hull.modules.put(new IntPosition(2, 1), new EmptyModuleSlot());
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
	public static ShipHull generateOnePieceShipHull(double maxArmor) {
		ModuleCollectionShipHull hull = new ModuleCollectionShipHull();
		hull.modules.put(new IntPosition(0, 0), new ArmorModule(maxArmor));
		return hull;
	}

	private ModuleCollectionShipHull() {
		modules = new HashMap<>();
	}

	@Override
	public Map<IntPosition, ModuleSlot> getModuleSlots() {
		return modules;
	}

}
