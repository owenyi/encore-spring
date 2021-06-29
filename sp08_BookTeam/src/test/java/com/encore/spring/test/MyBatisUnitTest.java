package com.encore.spring.test;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.encore.spring.domain.Book;
import com.encore.spring.domain.UserVO;

// MyBatisFramework
public class MyBatisUnitTest {

	public static void main(String[] args) throws Exception {
		// 1. 설정문서 읽어들여서
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		// 2. SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		// 3. SqlSession
		SqlSession session = factory.openSession();
		
		// 4. 쿼리문 수행...
//		Book book = new Book("199-512-050", "아몬드", "kkk", "한국", "1995-12-05", "창비", "손원평", 10800, "kkk", "kkk");
//		session.insert("BookMapper.addBook", book);
//	
//		List<Book> list = session.selectList("BookMapper.findBooks");
//		for (Book vo : list) System.out.println(vo);
//		
//		System.out.println("\n========================\n");
//		
//		list = session.selectList("BookMapper.findBookByTitle", "미드");
//		for (Book vo : list) System.out.println(vo);
//		
//		System.out.println("\n========================\n");
//		
//		list = session.selectList("BookMapper.findBookByPublisher", "인플");
//		for (Book vo : list) System.out.println(vo);
//		
//		HashMap map = new HashMap();
//		map.put("userId", "owen");
//		map.put("password", "1234");
//		System.out.println(session.selectOne("UserMapper.login", map));
		
		System.out.println(session.selectList("BookMapper.findBooks", "엔코"));
	}

}