package com.encore.spring.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.Book;
import com.encore.spring.model.BookService;


@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="bookregister.do", method=RequestMethod.POST)
	public ModelAndView bookregister(String[] bookNo, 
			String bookTitle, 
			String bookCategory, 
			String bookCountry, 
			String bookDate, 
			String bookPublisher, 
			String bookAuthor, 
			int bookPrice, 
			String bookSummary) throws Exception {

		String isbn = "";
		for(int i=0; i<bookNo.length; i++) {
			if(i==bookNo.length-1) {
				isbn += bookNo[i];
			} else {
				isbn += bookNo[i] + "-";
			}
		}
		
		Book bvo = new Book(isbn, bookTitle, bookCategory, bookCountry, bookDate, bookPublisher, bookAuthor, bookPrice, "kkk", bookSummary);
		bookService.addBook(bvo);
		
		return new ModelAndView("book_register_result", "bvo", bvo);
	}
	
	@RequestMapping("booklist.do")
	public ModelAndView booklist() throws Exception {
		List<Book> books = bookService.findBooks("");
		return new ModelAndView("book_list", "books", books);
	}
	
	@RequestMapping("view.do")
	public ModelAndView view(String isbn) throws Exception {
		Book book = bookService.findBookByIsbn(isbn);
		return new ModelAndView("book_detail", "book", book);
	}
	
	@RequestMapping("search.do")
	public ModelAndView search(String searchField, String searchText) throws Exception {
		List<Book> books = null;
		if (searchField.equals("LIST")) {
			books = bookService.findBooks(searchText);
		} else if (searchField.equals("TITLE")) {
			books = bookService.findBookByTitle(searchText);
		} else if (searchField.equals("PUBLISHER")) {
			books = bookService.findBookByPublisher(searchText);
		}
		return new ModelAndView("book_list", "books", books);
	}
}
