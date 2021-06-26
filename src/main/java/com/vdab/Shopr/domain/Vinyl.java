package com.vdab.Shopr.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "vinyl")

@Entity

public class Vinyl extends Article{
    
    @Column
    private String artist;
    @Column
    @Enumerated(EnumType.STRING)
    private VinylGenre vinylGenre;
    @Column
//            (updatable = false,insertable = false)
    private String type = "Vinyl";
    
}
