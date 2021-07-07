package com.vdab.Shopr.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.vdab.Shopr.domain.Game;
import com.vdab.Shopr.domain.GameAge;
import com.vdab.Shopr.domain.GameGenre;
import com.vdab.Shopr.services.GameSvc;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ConcurrentModel;

@ContextConfiguration(classes = {GameController.class})
@ExtendWith(SpringExtension.class)
public class GameControllerTest {
    @Autowired
    private GameController gameController;
    
    @MockBean
    private GameSvc gameSvc;
    
    @Test
    public void testAddGame() {
        GameController gameController = new GameController();
        assertEquals("addgame", gameController.addGame(new ConcurrentModel()));
    }
    
    @Test
    public void testAddGameDb() throws Exception {
        doNothing().when(this.gameSvc).addGameDb((com.vdab.Shopr.domain.Game) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addgamedb");
        MockMvcBuilders.standaloneSetup(this.gameController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("game"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/showgames"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/showgames"));
    }
    
    @Test
    public void testAddGameDb2() throws Exception {
        doNothing().when(this.gameSvc).addGameDb((com.vdab.Shopr.domain.Game) any());
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/addgamedb");
        postResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.gameController)
                .build()
                .perform(postResult)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("game"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/showgames"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/showgames"));
    }
    
    @Test
    public void testDeleteGame() throws Exception {
        doNothing().when(this.gameSvc).deleteGame(anyLong());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/deletegame/{article_id}", 1L);
        MockMvcBuilders.standaloneSetup(this.gameController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/showgames"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/showgames"));
    }
    
    @Test
    public void testDeleteGame2() throws Exception {
        doNothing().when(this.gameSvc).deleteGame(anyLong());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/deletegame/{article_id}", 1L);
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.gameController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/showgames"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/showgames"));
    }
    
    @Test
    public void testEditGameDb() throws Exception {
        doNothing().when(this.gameSvc).editGameById((com.vdab.Shopr.domain.Game) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/editgame/{article_id}", 1L);
        MockMvcBuilders.standaloneSetup(this.gameController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("game"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/showgames"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/showgames"));
    }
    
    @Test
    public void testEditGameDb2() throws Exception {
        doNothing().when(this.gameSvc).editGameById((com.vdab.Shopr.domain.Game) any());
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/editgame/{article_id}", 1L);
        postResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.gameController)
                .build()
                .perform(postResult)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("game"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/showgames"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/showgames"));
    }
    
    @Test
    public void testShowEditGame() throws Exception {
        Game game = new Game();
        game.setArticleId(123L);
        game.setSupplierId(123L);
        game.setPublisher("Publisher");
        game.setMinAge(GameAge.CHOOSE);
        game.setGameGenre(GameGenre.CHOOSE);
        game.setPrice(10.0);
        game.setTitle("Dr");
        when(this.gameSvc.getGameById((Long) any())).thenReturn(game);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/editgame/{article_id}", 1L);
        MockMvcBuilders.standaloneSetup(this.gameController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("editgame"))
                .andExpect(MockMvcResultMatchers.view().name("editgame"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("editgame"));
    }
}

