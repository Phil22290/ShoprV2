package com.vdab.Shopr.repos;

import com.vdab.Shopr.domain.Game;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class GameRepo {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Game> showGames() {
        return entityManager.createQuery("select g from Game g", Game.class).getResultList();
    }
    
    @Transactional
    public void addGameDb(Game newGame) {
        entityManager.persist(newGame);
    }
    
    public Game findGameById(Long articleId) {
        return entityManager.createQuery("select v from Game v where v.articleId = :articleId", Game.class).setParameter("articleId",articleId).getSingleResult();
    }
    
    @Transactional
    public void editGameById(Game editGame){
        entityManager.merge(editGame);
    }
    
    @Transactional
    public void deleteGame(long articleId) {
        Game game = findGameById(articleId);
        entityManager.remove(game);
    }
}
