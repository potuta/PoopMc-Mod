package io.github.potuta.poopmcmod;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.Resource;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class PoopMcModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		KeyBinding poopKey = KeyBindingHelper.registerKeyBinding(
				new KeyBinding("key.poopmc-mod.poop", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_P, "category.poopmc-mod")
		);

		// Key press handler
		SoundNames[] poopSounds = SoundNames.values();
		Random random = new Random();
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (poopKey.wasPressed()) {
				if (client.player != null) {
//					client.player.sendMessage(Text.literal("💩 You pooped!"), true);
					// Pick a random sound
					String randomSound = String.valueOf(poopSounds[random.nextInt(poopSounds.length)]);
					Identifier soundId = Identifier.of(PoopMcMod.MOD_ID, randomSound);

					client.player.playSound(SoundEvent.of(soundId), 1.0f, 1.0f);
				}
			}
		});
	}
}