package com.sapient.BookMocki.model;

import java.util.List;

public class Book {
	
	private String title;
	private List<String> authors;
	private String publication;
	private Integer yearOfPublication;
	
	public Book(String title,
			List<String> authors,
			String publication,
			Integer yearOfPublication){
		
		this.title=title;
		this.authors=authors;
		this.publication=publication;
		this.yearOfPublication=yearOfPublication;
		
	}
	
	public String getTitle() {
	    return title;
	  }

	  public List<String> getAuthors() {
	    return authors;
	  }

	  public String getPublication() {
	    return publication;
	  }

	  public Integer getYearOfPublication() {
	    return yearOfPublication;
	  }

	  

}
