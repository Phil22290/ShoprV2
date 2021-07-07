package com.vdab.Shopr.services;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.vdab.Shopr.domain.Vinyl;
import com.vdab.Shopr.domain.VinylGenre;
import com.vdab.Shopr.repos.VinylRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {VinylRepo.class, VinylSvc.class})
@ExtendWith(SpringExtension.class)
public class VinylSvcTest {
    @MockBean
    private VinylRepo vinylRepo;
    
    @Autowired
    private VinylSvc vinylSvc;
    
    @Test
    public void testShowVinyl() {
        when(this.vinylRepo.showVinyl()).thenReturn(null);
        assertNull(this.vinylSvc.showVinyl());
        verify(this.vinylRepo).showVinyl();
    }
    
    @Test
    public void testAddVinylDb() {
        doNothing().when(this.vinylRepo).addVinylDb((Vinyl) any());
        this.vinylSvc.addVinylDb(new Vinyl("Artist", VinylGenre.CHOOSE, "Type"));
        verify(this.vinylRepo).addVinylDb((Vinyl) any());
    }
    
    @Test
    public void testGetVinylById() {
        Vinyl vinyl = new Vinyl();
        vinyl.setArticleId(123L);
        vinyl.setSupplierId(123L);
        vinyl.setVinylGenre(VinylGenre.CHOOSE);
        vinyl.setPrice(10.0);
        vinyl.setTitle("abc");
        vinyl.setArtist("Artist");
        vinyl.setType("Type");
        when(this.vinylRepo.findVinylById((Long) any())).thenReturn(vinyl);
        assertSame(vinyl, this.vinylSvc.getVinylById(123L));
        verify(this.vinylRepo).findVinylById((Long) any());
    }
    
    @Test
    public void testEditVinylById() {
        doNothing().when(this.vinylRepo).editVinylById((Vinyl) any());
        this.vinylSvc.editVinylById(new Vinyl("Artist", VinylGenre.CHOOSE, "Type"));
        verify(this.vinylRepo).editVinylById((Vinyl) any());
    }
    
    @Test
    public void testDeleteVinyl() {
        doNothing().when(this.vinylRepo).deleteVinyl(anyLong());
        this.vinylSvc.deleteVinyl(123L);
        verify(this.vinylRepo).deleteVinyl(anyLong());
    }
}

