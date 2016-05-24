package service.logic;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryProvider {
	private static final String RESOURCE = "config.xml";
	
	private static SqlSessionFactory factory;
	
	public static SqlSessionFactory getSqlSessionFactory(){
		if(factory ==null){
			createSqlSessionFactory();
		}
		return factory;
	}
	private static void createSqlSessionFactory(){
		try {
			Reader reader = Resources.getResourceAsReader(RESOURCE);
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("SqlSessionFactory Error");
		}
	}
}
