package com.vdab.Shopr.domain;

public enum GameGenre {
    
    CHOOSE("Choose a genre"), // not ideal but to get form list placeholder in front end
    MMORPG("MMORPG"),
    RPG("RPG"),
    FPS("FPS"),
    RTS("RTS"),
    RACE("Race");
    
    private final String display;
    
    GameGenre(String display) {
        this.display = display;
    }
    
    public String getDisplay() {
        return display;
    }
    
}
