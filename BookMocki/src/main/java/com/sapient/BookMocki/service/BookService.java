package com.sapient.BookMocki.service;

import java.util.Collections;
import java.util.List;

import com.sapient.BookMocki.model.Book;

public class BookService {
	
	
	public List<Book> getAllBooks(){
	      return Collections.EMPTY_LIST;
	  }
	
	public Book getBook(String title){
	      return null;
	  }
	
	public String updateBook(Book book){
	      return book.getTitle();
	  }
}
