package com.sapient.BookMocki;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sapient.BookMocki.model.Book;
import com.sapient.BookMocki.service.BookService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

public class BookServiceTest {
	
	private static BookService mockedBookService;
	private static Book book1;
	private static Book book2;
	
	@BeforeClass
	  public static void setUp(){
		
		//Create mock object of BookService
	    mockedBookService = mock(BookService.class);
	    
	  //Create few instances of Book class.
	    book1 = new Book("Compilers Principles",
	            Arrays.asList("D. Jeffrey Ulman","Ravi Sethi", "Alfred V. Aho", "Monica S. Lam"),
	            "Pearson Education Singapore Pte Ltd", 2008);
	    
	    book2 = new Book("Let Us C 13th Edition",
	            Arrays.asList("Yashavant Kanetkar"),"BPB PUBLICATIONS", 2012);
	    
	    when(mockedBookService.getAllBooks()).thenReturn(Arrays.asList(book1, book2));
	}

	@Test
	public void TestService(){
		
		assertEquals(2,mockedBookService.getAllBooks().size() );
		assertEquals("Compilers Principles",mockedBookService.getAllBooks().get(0).getTitle());
		//assertEquals("Let Us C 13th Edition",mockedBookService.getAllBooks().get(0).getTitle());
	}
}
