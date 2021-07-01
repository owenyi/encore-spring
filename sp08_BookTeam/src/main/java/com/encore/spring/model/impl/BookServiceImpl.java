package com.encore.spring.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encore.spring.domain.Book;
import com.encore.spring.model.BookDAO;
import com.encore.spring.model.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDAO;
	
	@Override
	@Transactional
	public void addBook(Book book) throws Exception {
		bookDAO.addBook(book);
	}
	
	@Override
	public Book findBookByIsbn(String isbn) throws Exception {
		return bookDAO.findBookByIsbn(isbn);
	}
	
	@Override
	public List<Book> findBooks(String value) throws Exception {
		return bookDAO.findBooks(value);
	}
	@Override
	public List<Book> findBookByTitle(String title) throws Exception {
		return bookDAO.findBookByTitle(title);
	}
	@Override
	public List<Book> findBookByPublisher(String publisher) throws Exception {
		return bookDAO.findBookByPublisher(publisher);
	}
}
