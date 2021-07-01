package com.encore.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.encore.spring.domain.Board;

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
		session.insert("BoardMapper.insert", new Board("owen", "성시경", "내시경", null));
		session.commit();
		
		List<Board> list = session.selectList("BoardMapper.selectAll");
		for (Board vo : list) System.out.println(vo);
		
		System.out.println(session.selectOne("BoardMapper.selectOne", "2"));
	}

}