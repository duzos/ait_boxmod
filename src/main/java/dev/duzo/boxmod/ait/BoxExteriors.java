package dev.duzo.boxmod.ait;

import dev.amble.ait.core.AITSounds;
import dev.amble.ait.data.schema.exterior.category.PoliceBoxCategory;
import dev.amble.ait.data.schema.exterior.variant.addon.AddonExterior;
import dev.duzo.boxmod.BoxMod;

public class BoxExteriors {
	public static AddonExterior WAR;

	public static void register() {
		WAR = new AddonExterior(PoliceBoxCategory.REFERENCE, BoxMod.MOD_ID, "war").register();
		WAR.setDoor(new AddonExterior.Door(
				WAR, true, AITSounds.POLICE_BOX_DOOR_OPEN, AITSounds.POLICE_BOX_DOOR_CLOSE
		)).toDoor().register();
	}
}
