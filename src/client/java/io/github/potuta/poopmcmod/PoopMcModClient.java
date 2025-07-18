package io.github.potuta.poopmcmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class PoopMcModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		KeyBinding poopKey = KeyBindingHelper.registerKeyBinding(
				new KeyBinding("key.poopmc-mod.poop", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_P, "category.poopmc-mod")
		);

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (poopKey.wasPressed()) {
				if (client.player != null) {
					client.player.sendMessage(Text.literal("💩 You pooped!"), true);
					// Later: send a network packet to server to spawn poop
				}
			}
		});
	}
}