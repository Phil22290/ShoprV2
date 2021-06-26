package com.vdab.Shopr.domain;

import lombok.Data;

public enum BookType {
    FICTION("Fiction"),
    NONFICTION("Non-Fiction");
    
    
    private final String display;
    
    BookType(String display) {
        this.display = display;
    }
    
    public String getDisplay() {
        return display;
    }
    
}
