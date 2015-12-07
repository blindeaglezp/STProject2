package com.be.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.be.utils.CharacterUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import uno.allen.entity.City;
import uno.allen.entity.CityProject;
import uno.allen.entity.CityRfc;
import uno.allen.entity.County;
import uno.allen.entity.Subject;
import uno.allen.entity.User;
import uno.allen.fun.CityOp;
import uno.allen.fun.CityProjectOp;
import uno.allen.fun.CityRfcOp;
import uno.allen.fun.CountyOp;
import uno.allen.fun.SubjectOp;

/**
 * 县Servlet
 * @author blindeagle
 * @version 1.0
 * @data 2015.11.29
 */
@WebServlet(name="CountyServlet",urlPatterns="/servlet/CountyServlet")
public class CountyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User userObj  = null;
	private User userSession = null;
	private County countyObj = null;
	private CityProject cityProjectObj = null;
	private List<CityProject> cityProjects = null;
	private List<Subject> subjects = null;
	private Subject subjectObj = null;
	private JSONObject jsonObj = null;
	private JSONArray jsonArr = null;
	private CityRfc cityRfcObj = null;
	private City cityObj = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CharacterUtil.setCharToUTF8(request, response);
		
		String type = request.getParameter("type");
		
		switch (type) {
		case "toProjectManage" : toProjectManage(request, response); break;
		case "queryCountyByName" : queryCountyByName(request, response); break;
		case "addCityProject" : addCountyProject(request, response); break;
		case "updateCountyProject" : updateCountyProject(request, response); break;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * 更新县级项目
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void updateCountyProject(HttpServletRequest request, HttpServletResponse response) {
		String cityRfc = request.getParameter("cityRfc");
		String projectName = request.getParameter("projectName");
		String countyName = request.getParameter(countyName);
		int cost = Integer.parseInt(request.getParameter("cost"));
		cityProjects = CityProjectOp.getCityProjectByCityRfc(cityRfc);
		for (CityProject cp : cityProjects) {
			System.out.println(cp.getCity_RFC_CPFK());
			if (projectName.equals(cp.getProject_Name())) {
				cityProjectObj = cp;
				CityProjectOp.deleteCityProject(cityRfc,projectName,countyName);
				cityProjectObj.setCounty_Cost(cost);
				CityProjectOp.insertCityProject(cityProjectObj);
//				CityProjectOp.updateCityProject(cp);
				break;
			}
		}
		userObj = (User) request.getSession().getAttribute("user");
		cityProjects = CityProjectOp.getCityProjectByCountyName(userObj.getUser_County_Name());
		subjects = new ArrayList<Subject>();
		for (CityProject cp : cityProjects) {
			subjects.add(SubjectOp.getSubjectByName(cp.getSubject_Name_CPFK()).get(0));
		}
		List<Object> result = new ArrayList<Object>();
		result.add(cityProjects);
		result.add(subjects);
		jsonArr = JSONArray.fromObject(result);
		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 跳转到项目管理页面
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void toProjectManage(HttpServletRequest request, HttpServletResponse response) {
		userObj = (User) request.getSession().getAttribute("user");
		if (userObj == null) {
			return;
		}
		cityProjects = CityProjectOp.getCityProjectByCountyName(userObj.getUser_County_Name());
		subjects = new ArrayList<Subject>();
		for (CityProject project : cityProjects) {
			subjectObj = SubjectOp.getSubjectByName(project.getSubject_Name_CPFK()).get(0);
			subjects.add(subjectObj);
		}
		request.setAttribute("subjects", subjects);
		request.setAttribute("cityProjects", cityProjects);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/county/projectManage.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据县名查询县信息
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void queryCountyByName(HttpServletRequest request, HttpServletResponse response) {
		userSession = (User) request.getSession().getAttribute("user");
		countyObj = CountyOp.getAllCountyByCountyName(userSession.getUser_County_Name()).get(0);
		jsonObj = JSONObject.fromObject(countyObj);
		try {
			response.getWriter().print(jsonObj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加市项目
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void addCountyProject(HttpServletRequest request, HttpServletResponse response) {
		userSession = (User) request.getSession().getAttribute("user");
		
		// 获取数据
		String countyName = userSession.getUser_County_Name();
		String cityRfc = request.getParameter("cityRfc");
		String subClass = request.getParameter("subClass");
		String regulation = request.getParameter("regulation");
		String item = request.getParameter("item");
		subjectObj = SubjectOp.getSubjectByID(subClass + regulation + item).get(0);
		String projectName = request.getParameter("projectName");
		int countyBudget = Integer.parseInt(request.getParameter("countyBudget"));
		int countyCost = Integer.parseInt(request.getParameter("countyCost"));
		int countyPercent = (int) ((double)countyCost * 100 / countyBudget);
		
		// 封装对象
		cityProjectObj = new CityProject();
		cityProjectObj.setCity_RFC_CPFK(cityRfc);
		cityProjectObj.setSubject_Name_CPFK(subjectObj.getSBJ_Name());
		cityProjectObj.setCounty_name_CPFK(countyName);
		cityProjectObj.setProjec_Name(projectName);
		cityProjectObj.setCounty_Budget(countyBudget);
		cityProjectObj.setCounty_Cost(countyCost);
		cityProjectObj.setCounty_Percent(countyPercent);
		
		// 插入市项目表
		CityProjectOp.insertCityProject(cityProjectObj);
		
		// 添加市文号表记录
		cityRfcObj = new CityRfc();
		cityObj = CityOp.getCityByName(userSession.getUser_City_Name());
		cityRfcObj.setCity_FK_RFC(cityObj.getCityID());
		cityRfcObj.setCity_RFC(cityRfc);
		cityRfcObj.setCounty_Name(userSession.getUser_County_Name());
		cityRfcObj.setSBJ_ID_PFK(subjectObj.getSBJ_ID());
		cityRfcObj.setSBJ_Name_PFK(subjectObj.getSBJ_Name());
		CityRfcOp.insertCityRfc(cityRfcObj);
		
		cityProjects = CityProjectOp.getCityProjectByCountyName(userSession.getUser_County_Name());
		subjects = new ArrayList<Subject>();
		for(CityProject cityProject : cityProjects) {
			subjectObj = SubjectOp.getSubjectByName(cityProject.getSubject_Name_CPFK()).get(0);
			subjects.add(subjectObj);
		}
		List<Object> result = new ArrayList<Object>();
		result.add(cityProjects);
		result.add(subjects);
		jsonArr = JSONArray.fromObject(result);
		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
