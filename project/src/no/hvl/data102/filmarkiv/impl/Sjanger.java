package no.hvl.data102.filmarkiv.impl;

public enum Sjanger {
    DRAMA, ACTION, KOMEDIE, SCIFI, FANTASY, SKREKK, KRIG, ROMANSE, THRILLER, INGEN;

    public static Sjanger finnSjanger(String navn) {
        for (Sjanger s : Sjanger.values()) {
            if (s.toString().equals(navn.toUpperCase())) {
                return s;
            }
        }
        return INGEN;
    }
}
