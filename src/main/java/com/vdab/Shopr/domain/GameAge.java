package com.vdab.Shopr.domain;

public enum GameAge {
    
    CHOOSE("Choose Age Rating"), // not ideal but to get form list placeholder in front end
    THREE("3 years old - and above"),
    SIX("6 years old - and above"),
    TWELVE("12 years old - and above"),
    SIXTEEN("16 years old - and above"),
    EIGHTEEN("18 years old - and above");
    
    private final String display;
    
    GameAge(String display) {
        this.display = display;
    }
    
    public String getDisplayAge() {
        return display;
    }
    
    
}
