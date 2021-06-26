package com.vdab.Shopr.controllers;


import com.vdab.Shopr.domain.Vinyl;
import com.vdab.Shopr.services.VinylSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VinylController {
    
    @Autowired
    private VinylSvc vinylSvc;
    
    // displays list of all vinyl in DB
    @GetMapping("/showvinyl")
    public String showVinyl(Model model){
        model.addAttribute("showvinyl",vinylSvc.showVinyl());
        return "showvinyl";
    }
    
    // shows form for adding vinyl
    @GetMapping("/addvinyl")
    public String addVinyl(Model model){
        model.addAttribute("newvinyl", new Vinyl());
        return "addvinyl";
    }
    
    // posts form data to DB
    @PostMapping("/addvinyldb")
    public String addVinylDb(@ModelAttribute Vinyl newVinyl){
        vinylSvc.addVinylDb(newVinyl);
        return "redirect:/showvinyl";
    }
    
    @GetMapping("/editvinyl/{article_id}")
    public String showEditVinyl(@PathVariable("article_id") long articleId, Model model){
        model.addAttribute("editvinyl", vinylSvc.getVinylById(articleId));
        return "editvinyl";
    }
    
    @PostMapping("/editvinyl/{article_id}")
    public String editVinylDb(@ModelAttribute Vinyl editVinyl) {
        vinylSvc.editVinylById(editVinyl);
        return "redirect:/showvinyl";
    }
    
    @GetMapping("/deletevinyl/{article_id}")
    public String deleteVinyl(@PathVariable("article_id") long articleId){
        vinylSvc.deleteVinyl(articleId);
        return "redirect:/showvinyl";
    }
    
}
