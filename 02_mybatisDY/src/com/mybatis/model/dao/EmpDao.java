package com.mybatis.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public interface EmpDao {
	List<Map> selectSearch(SqlSession session,Map<String,Object> param);
	List<Map> selectPageList(SqlSession sesion,int cPage,int numPerPage);
	int selectCount(SqlSession session);
	
}
