package com.vdab.Shopr.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.vdab.Shopr.domain.Vinyl;
import com.vdab.Shopr.domain.VinylGenre;
import com.vdab.Shopr.services.VinylSvc;
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

@ContextConfiguration(classes = {VinylController.class})
@ExtendWith(SpringExtension.class)
public class VinylControllerTest {
    @Autowired
    private VinylController vinylController;
    
    @MockBean
    private VinylSvc vinylSvc;
    
    @Test
    public void testAddVinyl() {
        VinylController vinylController = new VinylController();
        ConcurrentModel concurrentModel = new ConcurrentModel();
        assertEquals("addvinyl", vinylController.addVinyl(concurrentModel));
        assertEquals("Vinyl", ((Vinyl) concurrentModel.get("newvinyl")).getType());
    }
    
    @Test
    public void testAddVinylDb() throws Exception {
        doNothing().when(this.vinylSvc).addVinylDb((com.vdab.Shopr.domain.Vinyl) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addvinyldb");
        MockMvcBuilders.standaloneSetup(this.vinylController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("vinyl"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/showvinyl"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/showvinyl"));
    }
    
    @Test
    public void testAddVinylDb2() throws Exception {
        doNothing().when(this.vinylSvc).addVinylDb((com.vdab.Shopr.domain.Vinyl) any());
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/addvinyldb");
        postResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.vinylController)
                .build()
                .perform(postResult)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("vinyl"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/showvinyl"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/showvinyl"));
    }
    
    @Test
    public void testDeleteVinyl() throws Exception {
        doNothing().when(this.vinylSvc).deleteVinyl(anyLong());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/deletevinyl/{article_id}", 1L);
        MockMvcBuilders.standaloneSetup(this.vinylController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/showvinyl"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/showvinyl"));
    }
    
    @Test
    public void testDeleteVinyl2() throws Exception {
        doNothing().when(this.vinylSvc).deleteVinyl(anyLong());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/deletevinyl/{article_id}", 1L);
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.vinylController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/showvinyl"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/showvinyl"));
    }
    
    @Test
    public void testEditVinylDb() throws Exception {
        doNothing().when(this.vinylSvc).editVinylById((com.vdab.Shopr.domain.Vinyl) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/editvinyl/{article_id}", 1L);
        MockMvcBuilders.standaloneSetup(this.vinylController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("vinyl"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/showvinyl"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/showvinyl"));
    }
    
    @Test
    public void testEditVinylDb2() throws Exception {
        doNothing().when(this.vinylSvc).editVinylById((com.vdab.Shopr.domain.Vinyl) any());
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/editvinyl/{article_id}", 1L);
        postResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.vinylController)
                .build()
                .perform(postResult)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("vinyl"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/showvinyl"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/showvinyl"));
    }
    
    @Test
    public void testShowEditVinyl() throws Exception {
        Vinyl vinyl = new Vinyl();
        vinyl.setArticleId(123L);
        vinyl.setSupplierId(123L);
        vinyl.setVinylGenre(VinylGenre.CHOOSE);
        vinyl.setPrice(10.0);
        vinyl.setTitle("Dr");
        vinyl.setArtist("Artist");
        vinyl.setType("Type");
        when(this.vinylSvc.getVinylById((Long) any())).thenReturn(vinyl);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/editvinyl/{article_id}", 1L);
        MockMvcBuilders.standaloneSetup(this.vinylController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("editvinyl"))
                .andExpect(MockMvcResultMatchers.view().name("editvinyl"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("editvinyl"));
    }
}

