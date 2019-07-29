package com.book.dao;


import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.book.model.Book;
import com.book.repository.BookRepository;

@Component
public class BookDao {

	@Autowired
	BookRepository bookRepository;
	
	
	
	static void validPrice(double price) throws Exception {

		if (price >= 150 && price<= 500)
			
			System.out.println("book is added");
		
		else
			throw new Exception("price is not between 150 and 500");
					
	}
	public static void findAuthorName (String authorName) throws NameNotFoundException{ 
		
		
		if ("aravinth".equals(authorName)) 
			
			System.out.println("author name is correct");
		
		else
			
            throw new NameNotFoundException("Name is not match!");
        
	}
	
	public Book create(Book book) throws Exception  {
		 Book value=null;
		try 
		{
		validPrice(book.getPrice());
		findAuthorName(book.getAuthorname());
		value=bookRepository.save(book); 
		}
		catch(Exception e)
		{
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());	
			
			throw e;
			
		}
	return value;	
		
	}
	
	public List<Book>getAll(){
		return bookRepository.findAll();
	}
	
	
	public Optional<Book> getById(Long bookid)
	
	{
		
     return bookRepository.findById(bookid);
		
	}
	
	public Long delete (Long bookid) 
	{
			bookRepository.deleteById(bookid);
			return bookid;
			
		}
		 
		
	
public Book update(Book book) {	
	
	return bookRepository.save(book);
	
}
}
