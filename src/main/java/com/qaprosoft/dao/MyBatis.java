package com.qaprosoft.dao;

// import static com.qaprosoft.utils.Constants.DB.MYBATIS_CFG;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MyBatis {
	private final static Logger LOGGER = LogManager.getLogger(MyBatis.class);
	private static SqlSessionFactory factory;

	private MyBatis() {
	}

	static {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
		} catch (IOException e) {
			LOGGER.error("IOException", e);
		}
		factory = new SqlSessionFactoryBuilder().build(reader);
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return factory;
	}

}