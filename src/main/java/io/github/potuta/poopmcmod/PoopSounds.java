package io.github.potuta.poopmcmod;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class PoopSounds {
    private PoopSounds(){}

    public static final SoundEvent COMBO_FART_WET = registerSound(SoundNames.combo_fart_wet.toString());
    public static final SoundEvent DIARRHEA = registerSound(SoundNames.diarrhea.toString());
    public static final SoundEvent FART_BIG_DROP = registerSound(SoundNames.fart_big_drop.toString());
    public static final SoundEvent LONG_FART = registerSound(SoundNames.long_fart.toString());
    public static final SoundEvent TINY_NUGGET_DROP = registerSound(SoundNames.tiny_nugget_drop.toString());

    private static SoundEvent registerSound(String id) {
        Identifier identifier = Identifier.of(PoopMcMod.MOD_ID, id);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }


    public static void Initialize(){}
}
