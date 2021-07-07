package com.vdab.Shopr.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;

import com.vdab.Shopr.services.BookSvc;
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

@ContextConfiguration(classes = {BookController.class})
@ExtendWith(SpringExtension.class)
public class BookControllerTest {
    @Autowired
    private BookController bookController;
    
    @MockBean
    private BookSvc bookSvc;
    
    @Test
    public void testAddFictionBook() {
        BookController bookController = new BookController();
        assertEquals("addfictionbook", bookController.addFictionBook(new ConcurrentModel()));
    }
    
    @Test
    public void testAddFictionBookDb() throws Exception {
        doNothing().when(this.bookSvc).addFictionBookDb((com.vdab.Shopr.domain.BookFiction) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addfictionbookdb");
        MockMvcBuilders.standaloneSetup(this.bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("bookFiction"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/showfictionbooks"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/showfictionbooks"));
    }
    
    @Test
    public void testAddFictionBookDb2() throws Exception {
        doNothing().when(this.bookSvc).addFictionBookDb((com.vdab.Shopr.domain.BookFiction) any());
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/addfictionbookdb");
        postResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.bookController)
                .build()
                .perform(postResult)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("bookFiction"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/showfictionbooks"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/showfictionbooks"));
    }
    
    @Test
    public void testAddNonFictionBook() {
        BookController bookController = new BookController();
        assertEquals("addnonfictionbook", bookController.addNonFictionBook(new ConcurrentModel()));
    }
    
    @Test
    public void testAddNonFictionBookDb() throws Exception {
        doNothing().when(this.bookSvc).addNonFictionBookDb((com.vdab.Shopr.domain.BookNonFiction) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addnonfictionbookdb");
        MockMvcBuilders.standaloneSetup(this.bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("bookNonFiction"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/shownonfictionbooks"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/shownonfictionbooks"));
    }
    
    @Test
    public void testAddNonFictionBookDb2() throws Exception {
        doNothing().when(this.bookSvc).addNonFictionBookDb((com.vdab.Shopr.domain.BookNonFiction) any());
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/addnonfictionbookdb");
        postResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.bookController)
                .build()
                .perform(postResult)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("bookNonFiction"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/shownonfictionbooks"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/shownonfictionbooks"));
    }
    
    @Test
    public void testDeleteFictionBook() throws Exception {
        doNothing().when(this.bookSvc).deleteFictionBook(anyLong());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/deletefictionbook/{article_id}", 1L);
        MockMvcBuilders.standaloneSetup(this.bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/showfictionbooks"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/showfictionbooks"));
    }
    
    @Test
    public void testDeleteFictionBook2() throws Exception {
        doNothing().when(this.bookSvc).deleteFictionBook(anyLong());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/deletefictionbook/{article_id}", 1L);
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.bookController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/showfictionbooks"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/showfictionbooks"));
    }
    
    @Test
    public void testDeleteNonFictionBook() throws Exception {
        doNothing().when(this.bookSvc).deleteNonFictionBook(anyLong());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/deletenonfictionbook/{article_id}", 1L);
        MockMvcBuilders.standaloneSetup(this.bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/shownonfictionbooks"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/shownonfictionbooks"));
    }
    
    @Test
    public void testDeleteNonFictionBook2() throws Exception {
        doNothing().when(this.bookSvc).deleteNonFictionBook(anyLong());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/deletenonfictionbook/{article_id}", 1L);
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.bookController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/shownonfictionbooks"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/shownonfictionbooks"));
    }
}

