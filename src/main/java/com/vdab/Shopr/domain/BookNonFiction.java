package com.vdab.Shopr.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.security.auth.Subject;

@EqualsAndHashCode(callSuper = true)
//@DiscriminatorValue(value = "Non-Fiction")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booksnonfiction")


public class BookNonFiction extends Book {
    
    @Enumerated(EnumType.STRING)
    @Column
    private BookSubject bookSubject;
    
    
    
//    @Transient
//    public String getDiscriminatorValueNon() {
//        return this.getClass().getAnnotation(DiscriminatorValue.class).value();
//    }
    
    
}
