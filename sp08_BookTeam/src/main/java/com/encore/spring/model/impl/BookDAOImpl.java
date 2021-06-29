package com.encore.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.Book;
import com.encore.spring.model.BookDAO;

@Repository
public class BookDAOImpl implements BookDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NS = "BookMapper.";
	
	@Override
	public void addBook(Book book) throws Exception {
		sqlSession.insert(NS+"addBook", book);
	}
	
	@Override
	public Book findBookByIsbn(String isbn) throws Exception {
		return sqlSession.selectOne(NS+"findBookByIsbn", isbn);
	}
	
	@Override
	public List<Book> findBooks(String value) throws Exception {
		return sqlSession.selectList(NS+"findBooks", value);
	}
	@Override
	public List<Book> findBookByTitle(String title) throws Exception {
		return sqlSession.selectList(NS+"findBookByTitle", title);
	}
	@Override
	public List<Book> findBookByPublisher(String publisher) throws Exception {
		return sqlSession.selectList(NS+"findBookByPublisher", publisher);
	}

}
