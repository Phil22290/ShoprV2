package com.vdab.Shopr.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
//@DiscriminatorValue(value = "Fiction")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booksfiction")

//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // JPA Inheritance
//@PrimaryKeyJoinColumn(name = "articleId")

public class BookFiction extends Book {
    
    @Enumerated(EnumType.STRING)
    @Column
    private BookGenre bookGenre;
    
    @Column
    private String description;
    
    
    
}
