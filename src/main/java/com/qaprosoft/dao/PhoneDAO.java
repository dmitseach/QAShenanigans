package com.qaprosoft.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.qaprosoft.objects.Phone;

public class PhoneDAO {
	public Phone getPhoneById(Integer id) {
		SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
		try {
			PhoneMapper phoneMapper = sqlSession.getMapper(PhoneMapper.class);
			return phoneMapper.getPhoneById(id);
		} finally {
			sqlSession.close();
		}
	}

	public List<Phone> getPhones() {
		SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
		try {
			PhoneMapper phoneMapper = sqlSession.getMapper(PhoneMapper.class);
			return phoneMapper.getPhones();
		} finally {
			sqlSession.close();
		}
	}

}
