package com.vdab.Shopr.services;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.vdab.Shopr.domain.BookFiction;
import com.vdab.Shopr.domain.BookGenre;
import com.vdab.Shopr.domain.BookNonFiction;
import com.vdab.Shopr.domain.BookSubject;
import com.vdab.Shopr.domain.BookType;
import com.vdab.Shopr.repos.BookRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BookSvc.class, BookRepo.class})
@ExtendWith(SpringExtension.class)
public class BookSvcTest {
    @MockBean
    private BookRepo bookRepo;
    
    @Autowired
    private BookSvc bookSvc;
    
    @Test
    public void testShowFictionBooks() {
        when(this.bookRepo.showFictionBooks()).thenReturn(null);
        assertNull(this.bookSvc.showFictionBooks());
        verify(this.bookRepo).showFictionBooks();
    }
    
    @Test
    public void testAddFictionBookDb() {
        doNothing().when(this.bookRepo).addFictionBookDb((BookFiction) any());
        this.bookSvc.addFictionBookDb(new BookFiction(BookGenre.CHOOSE, "Something"));
        verify(this.bookRepo).addFictionBookDb((BookFiction) any());
    }
    
    @Test
    public void testShowNonFictionBooks() {
        when(this.bookRepo.showNonFictionBooks()).thenReturn(null);
        assertNull(this.bookSvc.showNonFictionBooks());
        verify(this.bookRepo).showNonFictionBooks();
    }
    
    @Test
    public void testAddNonFictionBookDb() {
        doNothing().when(this.bookRepo).addNonFictionBookDb((BookNonFiction) any());
        this.bookSvc.addNonFictionBookDb(new BookNonFiction(BookSubject.CHOOSE));
        verify(this.bookRepo).addNonFictionBookDb((BookNonFiction) any());
    }
    
    @Test
    public void testGetFictionBookById() {
        BookFiction bookFiction = new BookFiction();
        bookFiction.setArticleId(123L);
        bookFiction.setSupplierId(123L);
        bookFiction.setPages(1);
        bookFiction.setBookType(BookType.FICTION);
        bookFiction.setIsbn("Isbn");
        bookFiction.setBookGenre(BookGenre.CHOOSE);
        bookFiction.setPrice(10.0);
        bookFiction.setAuthor("Test");
        bookFiction.setTitle("ABC");
        bookFiction.setDescription("something");
        when(this.bookRepo.findFictionBookById((Long) any())).thenReturn(bookFiction);
        assertSame(bookFiction, this.bookSvc.getFictionBookById(123L));
        verify(this.bookRepo).findFictionBookById((Long) any());
    }
    
    @Test
    public void testGetNonFictionBookById() {
        BookNonFiction bookNonFiction = new BookNonFiction();
        bookNonFiction.setArticleId(123L);
        bookNonFiction.setSupplierId(123L);
        bookNonFiction.setBookSubject(BookSubject.CHOOSE);
        bookNonFiction.setPages(1);
        bookNonFiction.setBookType(BookType.FICTION);
        bookNonFiction.setIsbn("Isbn");
        bookNonFiction.setPrice(10.0);
        bookNonFiction.setAuthor("JaneDoe");
        bookNonFiction.setTitle("Dr");
        when(this.bookRepo.findNonFictionBookById((Long) any())).thenReturn(bookNonFiction);
        assertSame(bookNonFiction, this.bookSvc.getNonFictionBookById(123L));
        verify(this.bookRepo).findNonFictionBookById((Long) any());
    }
    
    @Test
    public void testDeleteFictionBook() {
        doNothing().when(this.bookRepo).deleteFictionBook(anyLong());
        this.bookSvc.deleteFictionBook(123L);
        verify(this.bookRepo).deleteFictionBook(anyLong());
    }
    
    @Test
    public void testDeleteNonFictionBook() {
        doNothing().when(this.bookRepo).deleteNonFictionBook(anyLong());
        this.bookSvc.deleteNonFictionBook(123L);
        verify(this.bookRepo).deleteNonFictionBook(anyLong());
    }
}

