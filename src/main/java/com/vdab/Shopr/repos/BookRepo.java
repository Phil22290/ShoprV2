package com.vdab.Shopr.repos;

import com.vdab.Shopr.domain.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BookRepo {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<BookFiction> showFictionBooks(){
        return entityManager.createQuery("select b from BookFiction b", BookFiction.class).getResultList();
    }
    
    public List<BookNonFiction> showNonFictionBooks(){
        return entityManager.createQuery("select b from BookNonFiction b", BookNonFiction.class).getResultList();
    }
    
    @Transactional
    public void addFictionBookDb(BookFiction newFictionBook) {
        newFictionBook.setBookType(BookType.FICTION);
        entityManager.persist(newFictionBook);
    }
    
    @Transactional
    public void addNonFictionBookDb(BookNonFiction newNonFictionBook) {
        newNonFictionBook.setBookType(BookType.NONFICTION);
        entityManager.persist(newNonFictionBook);
    }
    
    public BookFiction findFictionBookById(Long articleId) {
        return entityManager.createQuery("select bf from BookFiction bf where bf.articleId = :articleId", BookFiction.class).setParameter("articleId",articleId).getSingleResult();
    }
    
    public BookNonFiction findNonFictionBookById(Long articleId) {
        return entityManager.createQuery("select nf from BookNonFiction nf where nf.articleId = :articleId", BookNonFiction.class).setParameter("articleId",articleId).getSingleResult();
    }
    
    @Transactional
    public void deleteFictionBook(long articleId) {
        BookFiction bf = findFictionBookById(articleId);
        entityManager.remove(bf);
    }
    
    @Transactional
    public void deleteNonFictionBook(long articleId) {
        BookNonFiction nf = findNonFictionBookById(articleId);
        entityManager.remove(nf);
    }
    
//            return entityManager.createNamedQuery("showFictionBooks", BookFiction.class).getResultList();
//
//    public List<BookNonFiction> showNonFictionBooks(){
//        return entityManager.createNamedQuery("showNonFictionBooks", BookNonFiction.class).getResultList();
//    }
    
//    @Transactional
//    public void addArticleToDb(Article article) {
//        entityManager.persist(article);
//
//    }
    
}
