package com.vdab.Shopr.services;

import com.vdab.Shopr.domain.BookFiction;
import com.vdab.Shopr.domain.BookNonFiction;
import com.vdab.Shopr.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookSvc {
    
    @Autowired
    private BookRepo bookRepo = new BookRepo();
    
    public List<BookFiction> showFictionBooks(){
        return bookRepo.showFictionBooks();
    }
    
    public void addFictionBookDb(BookFiction newFictionBook) {
        bookRepo.addFictionBookDb(newFictionBook);
    }
    
    public List<BookNonFiction> showNonFictionBooks(){
        return bookRepo.showNonFictionBooks();
    }
    
    public void addNonFictionBookDb(BookNonFiction newNonFictionBook) {
        bookRepo.addNonFictionBookDb(newNonFictionBook);
    }
    
    public BookFiction getFictionBookById(Long articleId) {
        return bookRepo.findFictionBookById(articleId);
    }
    
    public BookNonFiction getNonFictionBookById(Long articleId) {
        return bookRepo.findNonFictionBookById(articleId);
    }
    
    public void deleteFictionBook(long articleId) {
        bookRepo.deleteFictionBook(articleId);
    }
    
    public void deleteNonFictionBook(long articleId) {
        bookRepo.deleteNonFictionBook(articleId);
    }


//    public List<BookNonFiction> showNonFictionBooks(){ return bookRepo.showNonFictionBooks();
//    }
    
}
