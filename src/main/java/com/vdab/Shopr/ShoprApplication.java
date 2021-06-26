package com.vdab.Shopr;

import com.vdab.Shopr.domain.Book;
import com.vdab.Shopr.services.ArticleSvc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoprApplication {
	
	private static Book book;
	
	public static void main(String[] args) {
		SpringApplication.run(ShoprApplication.class, args);

		}
		
	}
	

