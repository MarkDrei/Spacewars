package de.rkable.spacewars;

import de.rkable.spacewars.modules.ShipModuleVisitor;

public interface Module {

	void accept(ShipModuleVisitor visitor);

}
