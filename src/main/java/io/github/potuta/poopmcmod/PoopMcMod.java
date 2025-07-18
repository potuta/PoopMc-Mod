package io.github.potuta.poopmcmod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PoopMcMod implements ModInitializer {
	public static final String MOD_ID = "poopmc-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.Initialize();
		PoopSounds.Initialize();

//		SoundNames[] poopSounds = SoundNames.values();
//		for (SoundNames sound : poopSounds) {
//			Identifier id = Identifier.of(PoopMcMod.MOD_ID, sound.toString());
//			Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
//		}
	}
}