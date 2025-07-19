package io.github.potuta.poopmcmod;

public enum SoundNames {
    combo_fart_wet(2),
    diarrhea(5),
    fart_big_drop(3),
    long_fart(7),
    tiny_nugget_drop(1);

    private int durationSecs;
    SoundNames(int i) {
        this.durationSecs = i;
    }

    public int getDurationSecs() {
        return durationSecs;
    }
}
