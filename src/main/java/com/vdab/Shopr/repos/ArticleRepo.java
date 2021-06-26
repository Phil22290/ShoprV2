package com.vdab.Shopr.repos;

import com.vdab.Shopr.domain.Article;
import com.vdab.Shopr.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

//@Repository
public class ArticleRepo {
    
//    @PersistenceContext
//    private EntityManager entityManager;
    
//    public List<Article> showAllArticles(){
//        return entityManager.createNamedQuery("showAllArticles",Article.class).getResultList();
//    }
    
//    @Transactional
//    public void addArticleToDb(Article article) {
//        entityManager.persist(article);
//
//    }
    
    
}
