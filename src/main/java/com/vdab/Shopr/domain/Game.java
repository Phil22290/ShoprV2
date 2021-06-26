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
@Table(name = "game")
@Entity

public class Game extends Article{

    @Column
    private String publisher;
    
    @Enumerated(EnumType.STRING)
    @Column
    private GameAge minAge;
    
    @Enumerated(EnumType.STRING)
    @Column
    private GameGenre gameGenre;

}
