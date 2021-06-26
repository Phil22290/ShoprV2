package com.vdab.Shopr.controllers;


import com.vdab.Shopr.domain.*;
import com.vdab.Shopr.services.BookSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
    
    @Autowired
    private BookSvc bookSvc;
    
    // displays list of fictionbooks in DB
    @GetMapping("/showfictionbooks")
    public String showFictionBooks(Model model){
        model.addAttribute("showfictionbooks", bookSvc.showFictionBooks());
        return "showfictionbooks";
    }
    
    // shows form for adding fiction books
    @GetMapping("/addfictionbook")
    public String addFictionBook(Model model){
        model.addAttribute("newfictionbook", new BookFiction());
        return "addfictionbook";
    }
    
    // posts form data to DB
    @PostMapping("/addfictionbookdb")
    public String addFictionBookDb(@ModelAttribute BookFiction newFictionBook){
        bookSvc.addFictionBookDb(newFictionBook);
        return "redirect:/showfictionbooks";
    }
    
    // displays list of NONfictionbooks in DB
    @GetMapping("/shownonfictionbooks")
    public String showNonFictionBooks(Model model){
        model.addAttribute("shownonfictionbooks", bookSvc.showNonFictionBooks());
        return "shownonfictionbooks";
    }
    
    // shows form for adding nonfiction books
    @GetMapping("/addnonfictionbook")
    public String addNonFictionBook(Model model){
        model.addAttribute("newnonfictionbook", new BookNonFiction());
        return "addnonfictionbook";
    }
    
    // posts form data to DB
    @PostMapping("/addnonfictionbookdb")
    public String addNonFictionBookDb(@ModelAttribute BookNonFiction newNonFictionBook){
        bookSvc.addNonFictionBookDb(newNonFictionBook);
        return "redirect:/shownonfictionbooks";
    }
    
    // deletes from db
    @GetMapping("/deletefictionbook/{article_id}")
    public String deleteFictionBook(@PathVariable("article_id") long articleId){
        bookSvc.deleteFictionBook(articleId);
        return "redirect:/showfictionbooks";
    }
    
    // deletes from db
    @GetMapping("/deletenonfictionbook/{article_id}")
    public String deleteNonFictionBook(@PathVariable("article_id") long articleId){
        bookSvc.deleteNonFictionBook(articleId);
        return "redirect:/shownonfictionbooks";
    }
    
//    @GetMapping("/")
//    public String showNonFictionBooks(Model model){
//        model.addAttribute("showNonFictionBooks", bookSvc.showNonFictionBooks());
//        return "shownonfictionbooks";
//    }
    
}
