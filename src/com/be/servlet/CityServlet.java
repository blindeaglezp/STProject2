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
import uno.allen.entity.City;
import uno.allen.entity.CityProject;
import uno.allen.entity.County;
import uno.allen.entity.ProvinceProject;
import uno.allen.entity.ProvinceRfc;
import uno.allen.entity.Subject;
import uno.allen.entity.User;
import uno.allen.fun.CityOp;
import uno.allen.fun.CityProjectOp;
import uno.allen.fun.CountyOp;
import uno.allen.fun.ProvinceProjectOp;
import uno.allen.fun.ProvinceRfcOp;
import uno.allen.fun.SubjectOp;
import uno.allen.fun.UserOp;

/**
 * 市Servlet
 * @author blindeagle
 * @version 1.0
 * @data 2015.11.29
 */
@WebServlet(name="CityServlet",urlPatterns="/servlet/CityServlet")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private City city = null;
	private List<County> countys = null;
	private List<Object> cityAndCounty = null;
	private JSONArray jsonArr = null;
	private County county = null;
	private User user = null;
	private User userSession = null;
	private List<User> users = null;
	private List<CityProject> projects = null;
	private List<Subject> subjects = null;
	private Subject subjectObj = null;
	private ProvinceProject provinceProjectObj = null;
	private List<ProvinceProject> provinceProjects = null;
	private ProvinceRfc provinceRfcObj = null;
	private CityProject cityProjectObj = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CharacterUtil.setCharToUTF8(request, response);
		
		String type = request.getParameter("type");
		
		switch (type) {
		case "toUserManage" : toUserManage(request, response); break;
		case "toCountyManage" : toCountyManage(request, response); break;
		case "toCountyProjectManage" : toCountyProjectManage(request, response); break;
		case "toCityProjectManage" : toCityProjectManage(request, response); break;
		case "queryCityAndCounty" : queryCityAndCounty(request, response); break;
		case "addCounty" : addCounty(request, response); break;
		case "queryCountyByCityId" : queryCountyByCityId(request, response); break;
		case "InsertCountyUser" : insertCountyUser(request, response); break;
		case "queryUserByCountyName" : queryUserByCountyName(request, response); break;
		case "deleteCountyUser" : deleteCountyUser(request, response); break;
		case "deleteCounty" : deleteCounty(request, response); break;
		case "addCityProject" : addCityProject(request, response); break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * 跳转到用户管理界面
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void toUserManage(HttpServletRequest request, HttpServletResponse response) {
		userSession = (User) request.getSession().getAttribute("user");
		if (userSession == null) {
			return;
		}
		users = UserOp.getUserByCityName(userSession.getUser_City_Name());
		city = CityOp.getCityByName(userSession.getUser_City_Name());
		countys = CountyOp.getCountyByCityID(city.getCityID());
		request.setAttribute("users", users);
		request.setAttribute("countys", countys);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/city/userManage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 跳转到县管理界面
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void toCountyManage(HttpServletRequest request, HttpServletResponse response) {
		user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return;
		}
		city = CityOp.getCityByName(user.getUser_City_Name());
		countys = CountyOp.getCountyByCityID(city.getCityID());
		request.setAttribute("countys", countys);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/city/countyManage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 跳转到市级项目管理页面
	 * @param request
	 * @param response
	 */
	private void toCityProjectManage(HttpServletRequest request, HttpServletResponse response) {
		userSession = (User) request.getSession().getAttribute("user");
		if (userSession == null) {
			return;
		}
		provinceProjects = ProvinceProjectOp.getProvinceProjectByCityName(userSession.getUser_City_Name());
		request.setAttribute("provinceProjects", provinceProjects);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/city/cityProjectManage.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 跳转到县级项目管理页面
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void toCountyProjectManage(HttpServletRequest request, HttpServletResponse response) {
		user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return;
		}
		String cityName = user.getUser_City_Name();
		city = CityOp.getCityByName(cityName);
		countys = CountyOp.getCountyByCityID(city.getCityID());
		
		projects = new ArrayList<CityProject>();
		List<CityProject> cityProjects = null;
		for (County county : countys) {
			String countyName = county.getCounty_Name();
			cityProjects = CityProjectOp.getCityProjectByCountyName(countyName);
			for (CityProject cityProject : cityProjects) {
				projects.add(cityProject);
			}
		}
		
		subjects = new ArrayList<Subject>();
		for (CityProject project : projects) {
			subjectObj = SubjectOp.getSubjectByName(project.getSubject_Name_CPFK()).get(0); 
			subjects.add(subjectObj);
		}
		request.setAttribute("subjects", subjects);
		request.setAttribute("projects", projects);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/city/countyProjectManage.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据市ID查询市和县的信息
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void queryCityAndCounty(HttpServletRequest request, HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return;
		}
		city = CityOp.getCityByName(user.getUser_City_Name());
		if (city == null) {
			return;
		}
		countys = CountyOp.getCountyByCityID(city.getCityID());
		cityAndCounty = new ArrayList<Object>();
		cityAndCounty.add(city);
		cityAndCounty.add(countys);
		jsonArr = JSONArray.fromObject(cityAndCounty);
		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * 添加县
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void addCounty(HttpServletRequest request, HttpServletResponse response) {
		userSession = (User) request.getSession().getAttribute("user");
		city = CityOp.getCityByName(userSession.getUser_City_Name());
		String countyName = request.getParameter("countyName");
		county = new County();
		county.setCity_FK(city.getCityID());
		county.setCounty_Name(countyName);
		CountyOp.insertCounty(county);
		countys = CountyOp.getCountyByCityID(city.getCityID());
		jsonArr = JSONArray.fromObject(countys);
		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询市Id查询县信息
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void queryCountyByCityId(HttpServletRequest request, HttpServletResponse response) {
		user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return;
		}
		city = CityOp.getCityByName(user.getUser_City_Name());
		countys = CountyOp.getCountyByCityID(city.getCityID());
		jsonArr = JSONArray.fromObject(countys);
		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加县用户
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void insertCountyUser(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String countyName = request.getParameter("countyName");
		userSession = (User) request.getSession().getAttribute("user");
		user = new User();
		user.setUser_City_Name(userSession.getUser_City_Name());
		user.setUser_County_Name(countyName);
		user.setUser_Level("县级");
		user.setUser_Name(userName);
		user.setUser_Password(password);
		UserOp.insertUser(user);
		users = UserOp.getUserByCityName(userSession.getUser_City_Name());
		jsonArr = JSONArray.fromObject(users);
		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据县名查询用户
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void queryUserByCountyName(HttpServletRequest request, HttpServletResponse response) {
		String countyName = request.getParameter("countyName");
		users = UserOp.getUserByCountyName(countyName);
		jsonArr = JSONArray.fromObject(users);
		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除县用户
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void deleteCountyUser(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("userName");
		UserOp.deleteUser(userName);
		userSession = (User) request.getSession().getAttribute("user");
		if (userSession == null) {
			return;
		}
		users = UserOp.getUserByCityName(userSession.getUser_City_Name());
		jsonArr = JSONArray.fromObject(users);
		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除县
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void deleteCounty(HttpServletRequest request, HttpServletResponse response) {
		int countyId = Integer.parseInt(request.getParameter("countyId"));
		county = CountyOp.getAllCountyByCountyID(countyId).get(0);
		CountyOp.deleteCounty(county.getCounty_Name());
		userSession = (User) request.getSession().getAttribute("user");
		if (userSession == null) {
			return;
		}
		String cityName = userSession.getUser_City_Name();
		city = CityOp.getCityByName(cityName);
		countys = CountyOp.getCountyByCityID(city.getCityID());
		jsonArr = JSONArray.fromObject(countys);
		try {
			response.getWriter().print(jsonArr);
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
	private void addCityProject(HttpServletRequest request, HttpServletResponse response) {
		userSession = (User) request.getSession().getAttribute("user");
		
		// 获取数据
		
		String provinceRfc = request.getParameter("cityRfc");
		String subClass = request.getParameter("subClass");
		String regulation = request.getParameter("regulation");
		String item = request.getParameter("item");
		subjectObj = SubjectOp.getSubjectByID(subClass + regulation + item).get(0);
		String projectName = request.getParameter("projectName");
		int totalBudget = Integer.parseInt(request.getParameter("totalBudget"));
		int centreBudget = Integer.parseInt(request.getParameter("centreBudget"));
		int provinceBudget = Integer.parseInt(request.getParameter("provinceBudget"));
		int cityLocalBudget = Integer.parseInt(request.getParameter("cityLocalBudget"));
		int cityLocalCost = Integer.parseInt(request.getParameter("cityLocalCost"));
		int cityLocalPercent = Integer.parseInt(request.getParameter("cityLocalPercent"));
		
		String cityAndCounty = request.getParameter("cityAndCounty");
		
		//　拆分字符串
		String[] cityAndCountys = cityAndCounty.split(",");
		for (String cc : cityAndCountys) {
			String[] cs = cc.split(":");
			
			if (cs[0] == null || "".equals(cs[1])) {
				// 添加省项目
				provinceProjectObj = new ProvinceProject();
				provinceProjectObj.setProvince_RFC_PPFK(provinceRfc);
				provinceProjectObj.setCity_Name_PPFK(cs[0]);
				provinceProjectObj.setSubject_PPFK(subjectObj.getSBJ_Name());
				provinceProjectObj.setProject_Name(projectName);
				provinceProjectObj.setTotal_Budget(totalBudget);
				provinceProjectObj.setCentre_Budget(centreBudget);
				provinceProjectObj.setProvince_Budget(provinceBudget);
				provinceProjectObj.setCity_Local_Budget(cityLocalBudget);
				provinceProjectObj.setCity_Local_Cost(cityLocalCost);
				provinceProjectObj.setCity_Local_Percent(cityLocalPercent);
				if (cs[2] != null && !"".equals(cs[2])) {
					provinceProjectObj.setCounty_Budget(Integer.parseInt(cs[2]));
				} else {
					provinceProjectObj.setCounty_Budget(0);
				}
				if (cs[3] != null && !"".equals(cs[3])) {
					provinceProjectObj.setCounty_Cost(Integer.parseInt(cs[3]));
				} else {
					provinceProjectObj.setCounty_Cost(0);
				}
				if (cs[4] != null && !"".equals(cs[4])) {
					provinceProjectObj.setCounty_Cost(Integer.parseInt(cs[4]));
				} else {
					provinceProjectObj.setCounty_Cost(0);
				}
				ProvinceProjectOp.insertProvinceProject(provinceProjectObj);
				// 添加省文号
				provinceRfcObj = new ProvinceRfc();
				provinceRfcObj.setCity_Name(cs[0]);
				provinceRfcObj.setProvince_RFC(provinceRfc);
				provinceRfcObj.setSBJ_ID_CITYFK(subjectObj.getSBJ_ID());
				provinceRfcObj.setSBJ_Name_CITYFK(subjectObj.getSBJ_Name());
				ProvinceRfcOp.insertProvinceRfc(provinceRfcObj);
			}
			
			if ((cs[0] != null && !"".equals(cs[0])) && (cs[1] != null && !"".equals(cs[1]))) {
				// 封装对象
				cityProjectObj = new CityProject();
	//						cityProjectObj.setCity_RFC_CPFK(cityRfc);
				cityProjectObj.setSubject_Name_CPFK(subjectObj.getSBJ_Name());
				cityProjectObj.setCounty_name_CPFK(cs[1]);
				cityProjectObj.setProjec_Name(projectName);
				if (cs[2] != null && "".equals(cs[2])) {
					cityProjectObj.setCounty_Budget(Integer.parseInt(cs[2]));
				}
				if (cs[3] != null && "".equals(cs[3])) {
					cityProjectObj.setCounty_Cost(Integer.parseInt(cs[3]));
				}
				if (cs[4] != null && "".equals(cs[4])) {
					cityProjectObj.setCounty_Cost(Integer.parseInt(cs[4]));
				}
				CityProjectOp.insertCityProject(cityProjectObj);
			}
			
		}
		provinceProjects = ProvinceProjectOp.getProvinceProjectByCityName(userSession.getUser_City_Name());
		
		subjects = new ArrayList<Subject>();
		for (ProvinceProject project : provinceProjects) {
			subjectObj = SubjectOp.getSubjectByName(project.getSubject_PPFK()).get(0);
			subjects.add(subjectObj);
		}
		
		List<Object> result = new ArrayList<Object>();
		result.add(provinceProjects);
		result.add(subjectObj);
		
		jsonArr = JSONArray.fromObject(result);
		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
}
