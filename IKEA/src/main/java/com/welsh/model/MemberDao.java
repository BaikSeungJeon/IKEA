package com.welsh.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	
	@Autowired
	private SqlSessionFactory sqlsessionFactory;
	
	public MemberDto getLoggedMember(MemberDto memberDto) {
		// TODO Auto-generated method stub
		MemberDto loggedMember= null;
		SqlSession sqlSession =sqlsessionFactory.openSession();
		loggedMember=sqlSession.selectOne("getLoggedMember",memberDto);
		sqlSession.close();
		return loggedMember;
	}

}
