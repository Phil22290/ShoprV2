package com.vdab.Shopr.controllers;

import com.vdab.Shopr.domain.Article;
import com.vdab.Shopr.domain.Book;
import com.vdab.Shopr.services.ArticleSvc;
import com.vdab.Shopr.services.GameSvc;
import com.vdab.Shopr.services.VinylSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//@Controller
public class ArticleController {
    
    
//    @Autowired
//    private VinylSvc vinylSvc;
//
//
//    // displays list of all vinyl in DB
//    @GetMapping("/showallitems")
//    public String showVinyl(Model model){
//        model.addAttribute("showvinyl",vinylSvc.showVinyl());
//        return "showallitems";
//    }
//
//    @Autowired
//    private GameSvc gameSvc;
//
//    // displays list of all games in DB
//    @GetMapping("/showallitems")
//    public String showGame(Model model){
//        model.addAttribute("showgames",gameSvc.showGames());
//        return "showallitems";
//    }

//
//    @Autowired
//    private ArticleSvc articleSvc;
//
//    @GetMapping(value = "/addarticle")
//    public String showAddPage(Model model){
//        model.addAttribute("newarticle", new Article());
//        return "addarticle";
//    }
//
//    @PostMapping(value = "/add")
//    public String add(@ModelAttribute Article newarticle) {
//        articleSvc.addArticleToDb((Book) newarticle);
//        return "redirect:/addarticle";
//    }
}
