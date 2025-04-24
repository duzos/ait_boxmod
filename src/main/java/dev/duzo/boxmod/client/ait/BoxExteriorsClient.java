package dev.duzo.boxmod.client.ait;

import dev.duzo.boxmod.client.model.door.WarDoorModel;
import dev.duzo.boxmod.client.model.exterior.WarExteriorModel;

import static dev.duzo.boxmod.ait.BoxExteriors.*;

public class BoxExteriorsClient {
	public static void register() {
		WAR.setModel(new WarExteriorModel()).toClient().register();
		WAR.toDoor().setModel(new WarDoorModel()).toClient().register();
	}
}
