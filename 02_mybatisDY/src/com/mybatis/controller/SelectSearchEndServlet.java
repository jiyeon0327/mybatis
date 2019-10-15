package com.mybatis.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.EmpService;
import com.mybatis.model.service.EmpServiceImpl;

/**
 * Servlet implementation class SelectSearchEndServlet
 */
@WebServlet("/selectSearchEnd")
public class SelectSearchEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		private EmpService service =new EmpServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectSearchEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String type=request.getParameter("searchType");
		String key=request.getParameter("keyword");
		String gender=request.getParameter("gender");
		String salary=request.getParameter("salary");
		String salary_le_ge=request.getParameter("salary_le_ge");
		String hiredate=request.getParameter("hiredate");
		String ent_date_ge_le=request.getParameter("ent_date");
		//String jobs=request.getParameter("job_code"); 다중값이어서 불가능
		String[] jobs=request.getParameterValues("job_code"); 
		Map<String,Object> param=new HashMap();
		param.put("type",type);
		param.put("key",key);
		param.put("gender", gender);
		param.put("salary",salary);
		param.put("flag",salary_le_ge);
		param.put("hiredate",hiredate);
		param.put("flags", ent_date_ge_le);
		param.put("jobs",jobs);
		
		List<Map> list=service.selectSearch(param);
		request.setAttribute("emp", list);
		System.out.println(list);
		request.getRequestDispatcher("/WEB-INF/views/selectSearch.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	} 

}
