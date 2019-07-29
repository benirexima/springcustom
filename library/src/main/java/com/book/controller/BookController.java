package com.book.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.model.Book;
import com.book.service.BookService;

@RequestMapping("library")

@RestController
public class BookController {


	@Autowired
	BookService bookservice;
	
	@PostMapping
	public Book create (@RequestBody Book book) throws Exception 
	{
		Book v =null;
		 try {
			v= bookservice.create(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}	
		 
		 return v;
	}

	@GetMapping("{bookid}")
	private Optional <Book> getById(@PathVariable("bookid")Long bookid ) {
		return bookservice.getById(bookid);
	}

	
	@GetMapping
	private List<Book>getAllBook(){
		return bookservice.getAllBook();
	}

	@PutMapping("{bookid}")
	private void update(@PathVariable("bookid")Long bookid,@RequestBody Book book) {
		bookservice.update(book);
	}
	
	
	@DeleteMapping("{bookid}")
	private void delete(@PathVariable Long bookid) {
		  bookservice.delete(bookid);
	} 
}
