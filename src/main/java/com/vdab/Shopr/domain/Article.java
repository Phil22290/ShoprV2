package com.vdab.Shopr.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
//@NamedQueries({
//        @NamedQuery(name = "showAllArticles", query = "SELECT a FROM  a")
//})

public abstract class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;
    @Column
    private String title;
    @Column
    private Double price;
    @Column
    private Long supplierId;
    
//    @Column(updatable = false,insertable = false)
//    private String type;
    
}
