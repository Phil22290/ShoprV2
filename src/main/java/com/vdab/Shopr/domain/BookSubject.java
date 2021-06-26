package com.vdab.Shopr.domain;

public enum BookSubject {
    CHOOSE("Choose a subject"),
    HISTORY("History"),
    COOKING("Cooking"),
    SCIENCE("Science"),
    SPORTS("Sports");
    
    private final String display;
    
    BookSubject(String display) {
        this.display = display;
    }
    
    public String getDisplay() {
        return display;
    }
    
}
