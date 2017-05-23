package com.qaprosoft.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.qaprosoft.objects.*;

public class PhoneDAO implements PhoneMapper {

	protected static final String NAMESPACE = "mappers";
	protected SqlSessionFactory sf;

	public SqlSessionFactory getSf() {
		return sf;
	}

	public void setSf(final SqlSessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Phone getPhoneById(Integer id) {
		final SqlSession session = sf.openSession();
		try {
			final String query = NAMESPACE + ".getPhoneById";
			Map<String, Object> args = new HashMap<String, Object>();
			args.put("id", id);
			return session.selectOne(query, args);
		} finally {
			session.close();
		}
	}

	@Override
	public List<Phone> getPhones() {
		final SqlSession session = sf.openSession();
		try {
			final String query = NAMESPACE + ".getPhones";
			return session.selectList(query);
		} finally {
			session.close();
		}
	}

}
