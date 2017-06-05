package com.qaprosoft.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.qaprosoft.objects.Fridge;

public class FridgeDAO {
	public Fridge getFridgeById(Integer id) {
		SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
		try {
			FridgeMapper fridgeMapper = sqlSession.getMapper(FridgeMapper.class);
			return fridgeMapper.getFridgeById(id);
		} finally {
			sqlSession.close();
		}
	}

	public List<Fridge> getFridges() {
		SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
		try {
			FridgeMapper fridgeMapper = sqlSession.getMapper(FridgeMapper.class);
			return fridgeMapper.getFridges();
		} finally {
			sqlSession.close();
		}
	}
}
