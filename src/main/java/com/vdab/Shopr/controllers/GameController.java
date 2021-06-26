package com.vdab.Shopr.controllers;


import com.vdab.Shopr.domain.Game;
import com.vdab.Shopr.domain.Vinyl;
import com.vdab.Shopr.services.GameSvc;
import com.vdab.Shopr.services.VinylSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GameController {
    
    @Autowired
    private GameSvc gameSvc;
    
    // displays list of all games in DB
    @GetMapping("/showgames")
    public String showGame(Model model){
        model.addAttribute("showgames",gameSvc.showGames());
        return "showgames";
    }
    
    // shows form for adding games
    @GetMapping("/addgame")
    public String addGame(Model model){
        model.addAttribute("newgame", new Game());
        return "addgame";
    }
    
    // posts form data to DB
    @PostMapping("/addgamedb")
    public String addGameDb(@ModelAttribute Game newGame){
        gameSvc.addGameDb(newGame);
        return "redirect:/showgames";
    }
    
    @GetMapping("/editgame/{article_id}")
    public String showEditGame(@PathVariable("article_id") long articleId, Model model){
        model.addAttribute("editgame", gameSvc.getGameById(articleId));
        return "editgame";
    }
    
    @PostMapping("/editgame/{article_id}")
    public String editGameDb(@ModelAttribute Game editGame) {
        gameSvc.editGameById(editGame);
        return "redirect:/showgames";
    }
    
    @GetMapping("/deletegame/{article_id}")
    public String deleteGame(@PathVariable("article_id") long articleId){
        gameSvc.deleteGame(articleId);
        return "redirect:/showgames";
    }
    
}
