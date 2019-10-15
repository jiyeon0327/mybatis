package com.mybatis.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

public class EmpDaoImpl implements EmpDao{
 
	
	
	
	/*
	 * public List<Map> selectPageList(SqlSession sesion, int cPage, int numPerPage)
	 * { //페이징 처리 //1.RowBounds 객체를 사용 //생성시에 paging처리에 대한 값을 대입해준다 ->(매개변수)로
	 * //offset : 출력된 데이터 범위,지금시작점에서 얼만큼 건너뛸건지 (*시작점으로 봐도 무방) //offset계산식
	 * (cPage-1)*numPerPage //limit : 몇개까지 출력할 것인지 *numPerPage // numPerPage
	 * RowBounds r=new RowBounds((cPage-1)*numPerPage,numPerPage); return
	 * session.selectList("emp.selectPageList",null,r); //첫번째자리는 sql,두번째짜리는 무조건
	 * 파라미터,세번째는 p
	 * 
	 * RowBounds r=new RowBounds();
	 * 
	 * return null; }
	 */
	@Override
	public List<Map> selectPageList(SqlSession session, int cPage, int numPerPage) {
		//1.RowBounds객체를 사용
		//생성시에 paging처리에 대한 값을 대입(매개변수)
		//offset : 출력된 데이터 범위, *시작점으로 봐도 무방
		// - (cPage-1)*numPerPage
		//limit : 몇개까지 출력할것인지 *numPerPage
		// - numPerapge
		RowBounds r=new RowBounds((cPage-1)*numPerPage,numPerPage);		
		return session.selectList("emp.selectPagelist",null,r);
	}

	@Override
	public int selectCount(SqlSession session) {
		return session.selectOne("emp.selectCount");
	}

	@Override 
	public List<Map> selectSearch(SqlSession session,Map<String,Object> param){
		return session.selectList("emp.selectSearch",param);
	}
}
