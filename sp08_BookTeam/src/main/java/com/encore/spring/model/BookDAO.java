package com.encore.spring.model;

import java.util.List;

import com.encore.spring.domain.Book;

public interface BookDAO {
	void addBook(Book book) throws Exception;
	Book findBookByIsbn(String isbn) throws Exception;
	List<Book> findBooks(String value) throws Exception;
	List<Book> findBookByTitle(String title) throws Exception;
	List<Book> findBookByPublisher(String publisher) throws Exception;
}
