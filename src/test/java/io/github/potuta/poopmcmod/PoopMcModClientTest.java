package io.github.potuta.poopmcmod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PoopMcModClientTest {
    @Test
    public void testSoundNamesEnum() {
        SoundNames[] sounds = SoundNames.values();

        assertEquals(5, sounds.length); // assuming there are 5 in your enum

        for (SoundNames name : sounds) {
            System.out.println(name.toString()); // prints the name as a string
        }
    }
}
