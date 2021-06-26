package com.vdab.Shopr.services;

import com.vdab.Shopr.domain.Game;
import com.vdab.Shopr.repos.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameSvc {
    
    @Autowired
    private GameRepo gameRepo;
    
    public List<Game> showGames() {
        return gameRepo.showGames();
    }
    
    public void addGameDb(Game newGame) {
        gameRepo.addGameDb(newGame);
    }
    
    public Game getGameById(Long articleId) {
        return gameRepo.findGameById(articleId);
    }
    
    public void editGameById(Game editGame) {
        gameRepo.editGameById(editGame);
    }
    
    public void deleteGame(long articleId) {
        gameRepo.deleteGame(articleId);
    }
}