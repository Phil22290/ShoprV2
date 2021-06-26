package com.vdab.Shopr.domain;

public enum BookGenre {
    CHOOSE("Choose a genre"),
    THRILLER("Thriller"),
    FANTASY("Fantasy"),
    DETECTIVE("Detective"),
    ROMANCE("Romance"),
    SCIFI("Science-Fiction");
    
    private final String display;
    
    BookGenre(String display) {
        this.display = display;
    }
    
    public String getDisplay() {
        return display;
    }
}
