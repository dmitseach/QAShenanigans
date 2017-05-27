package com.qaprosoft.dao;

import static com.qaprosoft.utils.Constants.DB.MYBATIS_CFG;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qaprosoft.objects.*;

public class MyBatis {
	private final static Logger LOGGER = LogManager.getLogger(MyBatis.class);

	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory;
		PhoneMapper phoneMapper;
		FridgeMapper fridgeMapper;
		Reader reader = null;
		PhoneDAO phoneDAO;

		try {
			reader = Resources.getResourceAsReader(MYBATIS_CFG);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			phoneMapper = sqlSessionFactory.openSession().getMapper(PhoneMapper.class);
			fridgeMapper = sqlSessionFactory.openSession().getMapper(FridgeMapper.class);

			List<Phone> phones = phoneMapper.getPhones();
			Phone phone = phoneMapper.getPhoneById(1);

			List<Fridge> fridges = fridgeMapper.getFridges();
			Fridge fridge = fridgeMapper.getFridgeById(1);

		} catch (IOException e) {
			LOGGER.error("IOException", e);
		}

	}

}