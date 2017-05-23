package com.qaprosoft.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.qaprosoft.objects.*;

public class FridgeDAO implements FridgeMapper {
	protected static final String NAMESPACE = "mappers";
	protected SqlSessionFactory sf;

	public SqlSessionFactory getSf() {
		return sf;
	}

	public void setSf(SqlSessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Fridge getFridgeById(Integer id) {
		final SqlSession session = sf.openSession();
		try {
			final String query = NAMESPACE + ".getFridgeById";
			Map<String, Object> args = new HashMap<String, Object>();
			args.put("id", id);
			return session.selectOne(query, args);
		} finally {
			session.close();
		}
	}

	@Override
	public List<Fridge> getFridges() {
		final SqlSession session = sf.openSession();
		try {
			final String query = NAMESPACE + ".getFridges";
			return session.selectList(query);
		} finally {
			session.close();
		}
	}

}
