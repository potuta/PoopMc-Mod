package io.github.potuta.poopmcmod;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.EntityPose;
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

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (poopKey.wasPressed()) {
				if (client.player != null) {
//					client.player.sendMessage(Text.literal("💩 You pooped!"), true);
					playRandomPoop(client);
				}
			}
		});
	}

	private void playRandomPoop(MinecraftClient client) {
		SoundNames[] poopSounds = SoundNames.values();
		int randIndex = new Random().nextInt(poopSounds.length);

		String randomSound = String.valueOf(poopSounds[randIndex]);
		Identifier soundId = Identifier.of(PoopMcMod.MOD_ID, randomSound);

		client.player.playSound(SoundEvent.of(soundId), 1.0f, 1.0f);
		setPlayerCrouch(client, poopSounds[randIndex].getDurationSecs() * 1000);
		shakeScreen(client, poopSounds[randIndex].getDurationSecs() * 1000);
	}

	private void setPlayerCrouch(MinecraftClient client, int durationMilis) {
		new Thread(() -> {
			client.options.sneakKey.setPressed(true);
			try {
				Thread.sleep(durationMilis);
			} catch (InterruptedException ignored) {}
			client.options.sneakKey.setPressed(false);
		}).start();
	}

	private void shakeScreen(MinecraftClient client, int durationMilis) {
		new Thread(() -> {
			long end = System.currentTimeMillis() + durationMilis;
			while (System.currentTimeMillis() < end) {
				client.execute(() -> {
					client.cameraEntity.setBodyYaw((float)(Math.random() - 0.5) * 2);
					client.cameraEntity.setPitch((float)(Math.random() - 0.5) * 2);
				});
				try {
					Thread.sleep(durationMilis);
				} catch (InterruptedException ignored) {}
			}
			client.execute(() -> {
				client.cameraEntity.setBodyYaw(0);
				client.cameraEntity.setPitch(0);
			});
		}).start();
	}
}