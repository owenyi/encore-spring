package com.encore.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.encore.spring.domain.Myproduct;

// MyBatisFramework
public class MyBatisUnitTest1 {

	public static void main(String[] args) throws Exception {
		// 1. 설정문서 읽어들여서
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		// 2. SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		// 3. SqlSession
		SqlSession session = factory.openSession();
		
		// 4. 쿼리문 수행...
		Myproduct product = new Myproduct("공기청정기", "LG", 350000);
		session.insert("MyproductMapper.addMyproduct", product);
		
		List<Myproduct> list = session.selectList("MyproductMapper.getMyproductList", "");
		for (Myproduct vo : list) System.out.println(vo);
		
		System.out.println("\n========================\n");
		
		Myproduct myproduct = session.selectOne("MyproductMapper.getMyproduct", 10);
		System.out.println(myproduct);
	}

}
