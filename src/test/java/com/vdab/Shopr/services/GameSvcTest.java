package com.vdab.Shopr.services;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.vdab.Shopr.domain.Game;
import com.vdab.Shopr.domain.GameAge;
import com.vdab.Shopr.domain.GameGenre;
import com.vdab.Shopr.repos.GameRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {GameSvc.class, GameRepo.class})
@ExtendWith(SpringExtension.class)
public class GameSvcTest {
    @MockBean
    private GameRepo gameRepo;
    
    @Autowired
    private GameSvc gameSvc;
    
    @Test
    public void testShowGames() {
        when(this.gameRepo.showGames()).thenReturn(null);
        assertNull(this.gameSvc.showGames());
        verify(this.gameRepo).showGames();
    }
    
    @Test
    public void testAddGameDb() {
        doNothing().when(this.gameRepo).addGameDb((Game) any());
        this.gameSvc.addGameDb(new Game("Publisher", GameAge.CHOOSE, GameGenre.CHOOSE));
        verify(this.gameRepo).addGameDb((Game) any());
    }
    
    @Test
    public void testGetGameById() {
        Game game = new Game();
        game.setArticleId(123L);
        game.setSupplierId(123L);
        game.setPublisher("Publisher");
        game.setMinAge(GameAge.CHOOSE);
        game.setGameGenre(GameGenre.CHOOSE);
        game.setPrice(10.0);
        game.setTitle("abc");
        when(this.gameRepo.findGameById((Long) any())).thenReturn(game);
        assertSame(game, this.gameSvc.getGameById(123L));
        verify(this.gameRepo).findGameById((Long) any());
    }
    
    @Test
    public void testEditGameById() {
        doNothing().when(this.gameRepo).editGameById((Game) any());
        this.gameSvc.editGameById(new Game("Publisher", GameAge.CHOOSE, GameGenre.CHOOSE));
        verify(this.gameRepo).editGameById((Game) any());
    }
    
    @Test
    public void testDeleteGame() {
        doNothing().when(this.gameRepo).deleteGame(anyLong());
        this.gameSvc.deleteGame(123L);
        verify(this.gameRepo).deleteGame(anyLong());
    }
}

