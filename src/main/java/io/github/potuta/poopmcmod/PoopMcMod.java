package io.github.potuta.poopmcmod;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PoopMcMod implements ModInitializer {
	public static final String MOD_ID = "poopmc-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.Initialize();
	}
}