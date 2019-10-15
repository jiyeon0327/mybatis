package com.mybatis.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

public class EmpDaoImpl implements EmpDao{
 
	
	
	
	/*
	 * public List<Map> selectPageList(SqlSession sesion, int cPage, int numPerPage)
	 * { //����¡ ó�� //1.RowBounds ��ü�� ��� //�����ÿ� pagingó���� ���� ���� �������ش� ->(�Ű�����)��
	 * //offset : ��µ� ������ ����,���ݽ��������� ��ŭ �ǳʶ۰��� (*���������� ���� ����) //offset����
	 * (cPage-1)*numPerPage //limit : ����� ����� ������ *numPerPage // numPerPage
	 * RowBounds r=new RowBounds((cPage-1)*numPerPage,numPerPage); return
	 * session.selectList("emp.selectPageList",null,r); //ù��°�ڸ��� sql,�ι�°¥���� ������
	 * �Ķ����,����°�� p
	 * 
	 * RowBounds r=new RowBounds();
	 * 
	 * return null; }
	 */
	@Override
	public List<Map> selectPageList(SqlSession session, int cPage, int numPerPage) {
		//1.RowBounds��ü�� ���
		//�����ÿ� pagingó���� ���� ���� ����(�Ű�����)
		//offset : ��µ� ������ ����, *���������� ���� ����
		// - (cPage-1)*numPerPage
		//limit : ����� ����Ұ����� *numPerPage
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
