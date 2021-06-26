package com.vdab.Shopr.services;

import com.vdab.Shopr.domain.Vinyl;
import com.vdab.Shopr.repos.VinylRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VinylSvc {
    
    @Autowired
    private VinylRepo vinylRepo;
    
    public List<Vinyl> showVinyl() {
        return vinylRepo.showVinyl();
    }
    
    public void addVinylDb(Vinyl newVinyl) {
        vinylRepo.addVinylDb(newVinyl);
    }
    
    public Vinyl getVinylById(Long articleId) {
        return vinylRepo.findVinylById(articleId);
    }
    
    public void editVinylById(Vinyl editVinyl) {
        vinylRepo.editVinylById(editVinyl);
    }
    
    public void deleteVinyl(long articleId) {
        vinylRepo.deleteVinyl(articleId);
    }
}