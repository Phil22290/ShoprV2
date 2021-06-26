package com.vdab.Shopr.domain;

public enum VinylGenre {
    CHOOSE("Choose Genre"),
    CLASSICAL("Classical"),
    POP("Pop"),
    ROCK("Rock"),
    DANCE("Dance"),
    RNB("RnB"),
    HIPHOP("Hiphop");
    
    private final String display;
    
    VinylGenre(String display) {
        this.display = display;
    }
    
    public String getDisplay() {
        return display;
    }
    
}
