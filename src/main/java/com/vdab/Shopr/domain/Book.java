package com.vdab.Shopr.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
//@DiscriminatorColumn(name = "type") - no more book table, so removed this
//@Table(name = "book") - no more book table, so removed this
//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Default SINGLE , Could be removed from annotations
@NamedQueries({
//        @NamedQuery(name = "showFictionBooks", query = "SELECT b FROM BookFiction b"),
        @NamedQuery(name = "showNonFictionBooks", query = "SELECT b FROM BookNonFiction b")
})

public abstract class Book extends Article  {
    
    @Column
    private String author;
    
    @Column
    private String isbn;
    
    @Column
    private Integer pages;
    
    @Column
    @Enumerated(EnumType.STRING)
    private BookType bookType;
    
    
    
    
    
    
//    private String bookType = DiscriminatorColumn;

    
    
//    protected Book(Long articleId, String title, Double price, Long supplierId, Long id, String author, String isbn, Integer pages) {
//        super(articleId, title, price, supplierId);
////        this.id = id;
//        this.author = author;
//        this.isbn = isbn;
//        this.pages = pages;
//    }
//
//    protected Book(String title, Double price, long supplierId, String author, String isbn, Integer pages) {
//        super(title, price, supplierId);
////        this.id = id;
//        this.author = author;
//        this.isbn = isbn;
//        this.pages = pages;
//    } CONSTRUCTOR NIET MEER NODIG
}
