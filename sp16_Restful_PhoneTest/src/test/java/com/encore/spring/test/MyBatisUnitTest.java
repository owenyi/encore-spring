package com.encore.spring.test;

import java.io.Reader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.encore.pms.dto.Phone;

// MyBatisFramework
public class MyBatisUnitTest {

	public static void main(String[] args) throws Exception {
		// 1. 설정문서 읽어들여서
		Reader r = Resources.getResourceAsReader("mybatis/SqlMapConfig.xml");
		
		// 2. SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		// 3. SqlSession
		SqlSession session = factory.openSession();
		
		// 4. 쿼리문 수행...
		List<String> nums = Arrays.asList(new String[] {"1234", "12345"});
		session.delete("sql.pms.mapper.delete", nums);
	
		System.out.println(session.selectList("sql.pms.mapper.select"));
	}

}