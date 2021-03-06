package com.be.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * 省servlet
 * @author blindeagle
 * @version 1.0
 * @data 2015.11.29
 */
@WebServlet(name="ProvinceServlet",urlPatterns="/servlet/ProvinceServlet")
public class ProvinceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private City cityObj = null;
	private List<City> citys = null;
	private JSONArray jsonArr = null;
	private List<County> countys = null;
	private County countyObj = null;
	private Map<String, List<County>> cityCountys = null;
	private Subject subjectObj = null;
	private List<Subject> subjects = null;
	private List<CityProject> cityProjects = null;
	private List<User> users = null;
	private User userObj = null;
	private List<ProvinceRfc> provinceRfcs = null;
	private List<ProvinceProject> provinceProjects = null;
	private ProvinceProject provinceProjectObj = null;
	private CityProject cityProjectObj = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CharacterUtil.setCharToUTF8(request, response);
		
		String type = request.getParameter("type");
		
		switch (type) {
		case "toIndex" :toIndex(request,response); break;
		case "toUserManage" : toUserManage(request, response); break;
		case "toCityManage" : toCityManage(request, response); break;
		case "toProjectManage" : toProjectManage(request, response); break;
		case "toSubjectManage" : toSubjectManage(request, response); break;
		case "addCity" : addCity(request, response); break;
		case "deleteCity" : deleteCity(request, response); break;
		case "queryCityAndCounty" : queryCityAndCounty(request, response); break;
		case "queryAllCity" : queryAllCity(request, response); break;
		case "updateCity" : updateCity(request, response); break;
		case "queryUserByCityName" : queryUserByCityName(request, response); break;
		case "queryCountyByCityName" : queryCountyByCityName(request, response); break;
		case "queryUserByCountyName" : queryUserByCountyName(request, response); break;
		case "deleteUser" : deleteUser(request, response); break;
		case "udateUser" : updateUser(request, response); break;
		case "addUser" : addUser(request, response); break;
		case "addSubject" : addSubject(request, response); break;
		case "querySubjectByClass" : querySubjectByClass(request,response); break;
		case "querySubjectByRegulation" : querySubjectByRegulation(request, response); break;
		case "querySubjectByItem" : querySubjectByItem(request, response); break;
		case "deleteSubject" : deleteSubject(request, response); break;
		case "addProvinceProject" : addProvinceProject(request, response); break;
		case "queryRfcByRfc" : queryRfcByRfc(request, response); break;
		case "queryProjectByCondition" : queryProjectByCondition(request, response); break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	/**
	 * 跳转到首页
	 * @author gaohailong
	 * @param request
	 * @param response
	 */
	private void toIndex(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/province/functionShow.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据条件查询项目信息
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void queryProjectByCondition(HttpServletRequest request, HttpServletResponse response) {
		String cityName = request.getParameter("cityName");
		String countyName = request.getParameter("countyName");
		String subClass = request.getParameter("subClass");
		String subReg = request.getParameter("subReg");
		String subItem = request.getParameter("subItem");
		String provinceRfc = request.getParameter("provinceRfc");
		String projectName = request.getParameter("projectName");
		cityProjects = CityProjectOp.getAllCityProject();
		if ((!"0".equals(cityName)) && "0".equals(countyName)) {
			for (int i = 0; i < cityProjects.size(); i++) {
				cityObj = CityOp.getCityByID(CountyOp.getAllCountyByCountyName(cityProjects.get(i).getCounty_name_CPFK()).get(0).getCity_FK());
				if (!cityName.equals(cityObj.getCityName())) {
					cityProjects.remove(i);
					i--;
				}
			}
		} else if (!"0".equals(countyName)) {
			for (int i = 0; i < cityProjects.size(); i++) {
				if (!countyName.equals(cityProjects.get(i).getCounty_name_CPFK())) {
					cityProjects.remove(i);
					i--;
				}
			}
		}
		if (!"0".equals(subClass) && "0".equals(subReg)) {
			subjects = SubjectOp.getSubjectByClass(subClass);
			for (int i = 0; i < cityProjects.size(); i++) {
				List<Subject> subs = SubjectOp.getSubjectByName(cityProjects.get(i).getSubject_Name_CPFK());
				for (int j = 0; j < subs.size(); j++) {
					if (!subClass.equals(subs.get(j).getSBJ_Class())) {
						cityProjects.remove(i);
						i--;
						break;
					}
				}
			}
		} else if (!"0".equals(subReg) && "0".equals(subItem)) {
			subjects = SubjectOp.getSubjectByRegulation(subReg);
			for (int i = 0; i < cityProjects.size(); i++) {
				List<Subject> subs = SubjectOp.getSubjectByName(cityProjects.get(i).getSubject_Name_CPFK());
				for (int j = 0; j < subs.size(); j++) {
					if (!subReg.equals(subs.get(j).getSBJ_Regulation())) {
						cityProjects.remove(i);
						i--;
						break;
					}
				}
			}
		} else if (!"0".equals(subItem)) {
			subjects = SubjectOp.getSubjectByRegulation(subItem);
			for (int i = 0; i < cityProjects.size(); i++) {
				List<Subject> subs = SubjectOp.getSubjectByName(cityProjects.get(i).getSubject_Name_CPFK());
				for (int j = 0; j < subs.size(); j++) {
					if (!subItem.equals(subs.get(j).getSBJ_Item())) {
						cityProjects.remove(i);
						i--;
						break;
					}
				}
			}
		}
		if (provinceRfc != null && !"".equals(provinceRfc)) {
			for (int i = 0; i < cityProjects.size(); i++) {
				if (!provinceRfc.equals(cityProjects.get(i).getCity_RFC_CPFK())) {
					cityProjects.remove(i);
					i--;
				}
			}
		}
		if (projectName != null && !"".equals(projectName)) {
			for (int i = 0; i < cityProjects.size(); i++) {
				if (!projectName.equals(cityProjects.get(i).getProject_Name())) {
					cityProjects.remove(i);
					i--;
				}
			}
		}
		List<String> cityNames = new ArrayList<String>();
		subjects = new ArrayList<Subject>();
		for (CityProject project : cityProjects) {
			subjectObj = SubjectOp.getSubjectByName(project.getSubject_Name_CPFK()).get(0);
			subjects.add(subjectObj);
			cityObj = CityOp.getCityByID(CountyOp.getAllCountyByCountyName(project.getCounty_name_CPFK()).get(0).getCity_FK());
			cityNames.add(cityObj.getCityName());
		}
		List<Object> result = new ArrayList<Object>();
		result.add(cityProjects);
		result.add(cityNames);
		result.add(subjects);
		jsonArr = JSONArray.fromObject(result);
		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据文号的一部分模糊查询文号
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void queryRfcByRfc(HttpServletRequest request, HttpServletResponse response) {
		String provinceRfc = request.getParameter("provinceRfc");
		cityProjects = CityProjectOp.getAllCityProject();
		List<String> result = new ArrayList<String>();
		for (CityProject project : cityProjects) {
			if (project.getCity_RFC_CPFK().contains(provinceRfc)) {
				result.add(project.getCity_RFC_CPFK());
			}
		}
		jsonArr = JSONArray.fromObject(result);
		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 跳转到用户管理界面
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void toUserManage(HttpServletRequest request, HttpServletResponse response) {
		citys = CityOp.getAllCity();
		users = UserOp.getAllUser();
		request.setAttribute("citys", citys);
		request.setAttribute("users", users);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/province/userManage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 跳转到市管理界面
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void toCityManage(HttpServletRequest request, HttpServletResponse response) {
		citys = CityOp.getAllCity();
		request.setAttribute("citys", citys);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/province/cityManage.jsp").forward(request, response);
		} catch (Exception e) {
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
		citys = CityOp.getAllCity();
		provinceRfcs = ProvinceRfcOp.getAllProvinceRfc();
		List<String> proCitys = new ArrayList<String>();
		cityProjects = CityProjectOp.getAllCityProject();
		for (CityProject project : cityProjects) {
			countyObj = CountyOp.getAllCountyByCountyName(project.getCounty_name_CPFK()).get(0);
			cityObj = CityOp.getCityByID(countyObj.getCity_FK());
			proCitys.add(cityObj.getCityName());
		}
		provinceProjects = ProvinceProjectOp.getAllProvinceProject();
		List<Subject> proSubjects = new ArrayList<Subject>();
		for (ProvinceProject pp : provinceProjects) {
			proSubjects.add(SubjectOp.getSubjectByName(pp.getSubject_PPFK()).get(0));
		}
		
		List<String> subClasses = new ArrayList<String>();
		subjects = new ArrayList<Subject>();
		for (CityProject project : cityProjects) {
			subjectObj = SubjectOp.getSubjectByName(project.getSubject_Name_CPFK()).get(0);
			subjects.add(subjectObj);
			if (!subClasses.contains(subjectObj.getSBJ_Class())) {
				subClasses.add(subjectObj.getSBJ_Class());
			}
		}
		request.setAttribute("citys", citys);
//		request.setAttribute("provinceProjects", provinceProjects);
		request.setAttribute("provinceRfcs", provinceRfcs);
		request.setAttribute("subjects", subjects);
		request.setAttribute("subClasses", subClasses);
		request.setAttribute("proSubjects", proSubjects);
		request.setAttribute("cityProjects", cityProjects);
		request.setAttribute("proCitys", proCitys);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/province/projectManage.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 跳转到科目管理界面
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void toSubjectManage(HttpServletRequest request, HttpServletResponse response) {
		subjects = SubjectOp.getAllSubject();
		List<String> classes = new ArrayList<String>();
		for (Subject subject : subjects) {
			if (! classes.contains(subject.getSBJ_Class())) {
				classes.add(subject.getSBJ_Class());
			}
		}
		request.setAttribute("classes", classes);
		request.setAttribute("subjects", subjects);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/province/subjectManage.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加市
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void addCity(HttpServletRequest request, HttpServletResponse response) {
		String cityName = request.getParameter("cityName");
		cityObj = new City();
		cityObj.setCityName(cityName);
		CityOp.insertCity(cityObj);
		citys = CityOp.getAllCity();
		jsonArr = JSONArray.fromObject(citys);
		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除市
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void deleteCity(HttpServletRequest request, HttpServletResponse response) {
		int cityId = Integer.parseInt(request.getParameter("cityId"));
		cityObj = CityOp.getCityByID(cityId);
		CityOp.deleteCity(cityObj.getCityName());
		citys = CityOp.getAllCity();
		jsonArr = JSONArray.fromObject(citys);
		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询所有市和县的信息
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void queryCityAndCounty(HttpServletRequest request, HttpServletResponse response) {
		citys = CityOp.getAllCity();
		cityCountys = new HashMap<String, List<County>>();
		for (City city : citys) {
			countys = CountyOp.getCountyByCityID(city.getCityID());
			cityCountys.put(city.getCityID() + "", countys);
		}
		List<Object> data = new ArrayList<Object>();
		data.add(citys);
		data.add(cityCountys);
		jsonArr = JSONArray.fromObject(data);
		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询所有市
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void queryAllCity(HttpServletRequest request, HttpServletResponse response) {
		citys = CityOp.getAllCity();
		jsonArr = JSONArray.fromObject(citys);
		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改市信息
	 * @param request
	 * @param response
	 */
	private void updateCity(HttpServletRequest request, HttpServletResponse response) {
		
		citys = CityOp.getAllCity();
		jsonArr = JSONArray.fromObject(citys);
		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据市ID查询用户信息
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void queryUserByCityName(HttpServletRequest request, HttpServletResponse response) {
		String cityName = request.getParameter("cityName");
		if ("0".equals(cityName)) {
			users = UserOp.getAllUser();
		} else {
			users = UserOp.getUserByCityName(cityName);
		}
		jsonArr = JSONArray.fromObject(users);
		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据市ID查询县信息
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void queryCountyByCityName(HttpServletRequest request, HttpServletResponse response) {
		String cityName = request.getParameter("cityName");
		cityObj = CityOp.getCityByName(cityName);
		countys = CountyOp.getCountyByCityID(cityObj.getCityID());
		jsonArr = JSONArray.fromObject(countys);
		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据县ID查询用户信息
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void queryUserByCountyName(HttpServletRequest request, HttpServletResponse response) {
		String countyName = request.getParameter("countyName");
		String cityName = request.getParameter("cityName");
		if ("0".equals(countyName)) {
			users = UserOp.getUserByCityName(cityName);
		} else {
			users = UserOp.getUserByCountyName(countyName);
		}
		jsonArr = JSONArray.fromObject(users);
		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除用户
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("userName");
		UserOp.deleteUser(userName);
		users = UserOp.getAllUser();
		jsonArr = JSONArray.fromObject(users);
		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 更新用户
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void updateUser(HttpServletRequest request, HttpServletResponse response) {
		/*int userId = Integer.parseInt(request.getParameter("userId"));
		String result = "{'reslt':'success'}";
		jsonObj = JSONObject.fromObject(result);
		try {
			response.getWriter().print(jsonObj);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
	
	/**
	 * 添加用户
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void addUser(HttpServletRequest request, HttpServletResponse response) {
		String cityName = request.getParameter("cityName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		userObj = new User();
		userObj.setUser_City_Name(cityName);
		userObj.setUser_Name(userName);
		userObj.setUser_Password(password);
		userObj.setUser_Level("市级");
		UserOp.insertUser(userObj);
		users = UserOp.getAllUser();
		jsonArr = JSONArray.fromObject(users);
		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据科目的类查询科目信息
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void querySubjectByClass(HttpServletRequest request, HttpServletResponse response) {
		String subClass = request.getParameter("class");
		subjects = SubjectOp.getSubjectByClass(subClass);
		List<String> regulations = new ArrayList<String>();
		for (Subject subject : subjects) {
			if (! regulations.contains(subject.getSBJ_Regulation())) {
				regulations.add(subject.getSBJ_Regulation());
			}
		}
		List<Object> result = new ArrayList<Object>();
		result.add(subjects);
		result.add(regulations);
		jsonArr = JSONArray.fromObject(result);
		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据科目的款查询科目信息
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void querySubjectByRegulation(HttpServletRequest request, HttpServletResponse response) {
		String regulation = request.getParameter("regulation");
		subjects = SubjectOp.getSubjectByRegulation(regulation);
		List<String> items = new ArrayList<String>();
		for (Subject subject : subjects) {
			if (! items.contains(subject.getSBJ_Item())) {
				items.add(subject.getSBJ_Item());
			}
		}
		List<Object> result = new ArrayList<Object>();
		result.add(subjects);
		result.add(items);
		jsonArr = JSONArray.fromObject(result);
		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据科目的项查询科目信息
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void querySubjectByItem(HttpServletRequest request, HttpServletResponse response) {
		String subClass = request.getParameter("subClass");
		String subRegulation = request.getParameter("subRegulation");
		String item = request.getParameter("item");
		subjects = SubjectOp.getSubjectByItem(item);
		for (int i = 0; i < subjects.size(); i++) {
			Subject subject = subjects.get(i);
			if (!subClass.equals(subject.getSBJ_Class())) {
				subjects.remove(i);
				i--;
				continue;
			}
			if (! subRegulation.equals(subject.getSBJ_Regulation())) {
				subjects.remove(i);
				i--;
				continue;
			}
		}
		jsonArr = JSONArray.fromObject(subjects);
		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除科目
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void deleteSubject(HttpServletRequest request, HttpServletResponse response) {
		String subjectId = request.getParameter("subjectId");
		subjectObj = SubjectOp.getSubjectByID(subjectId).get(0);
		SubjectOp.deleteSubject(subjectObj.getSBJ_Name());
		subjects = SubjectOp.getAllSubject();
		jsonArr = JSONArray.fromObject(subjects);
		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加科目
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void addSubject(HttpServletRequest request, HttpServletResponse response) {
		String subClass = request.getParameter("subClass");
		String subRegulation = request.getParameter("subRegulation");
		String subItem = request.getParameter("subItem");
		String subName = request.getParameter("subName");
		subjectObj = new Subject();
		subjectObj.setSBJ_Class(subClass);
		subjectObj.setSBJ_Regulation(subRegulation);
		subjectObj.setSBJ_Item(subItem);
		subjectObj.setSBJ_ID(subClass + subRegulation + subItem);
		subjectObj.setSBJ_Name(subName);
		SubjectOp.insertSubject(subjectObj);
		subjects = SubjectOp.getAllSubject();
		jsonArr = JSONArray.fromObject(subjects);
		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加省级项目
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response　响应对象
	 * @return void
	 */
	private void addProvinceProject(HttpServletRequest request, HttpServletResponse response) {
		// 获取数据
		String provinceRfc = request.getParameter("provinceRfc");
		String subClass = request.getParameter("subClass");
		String regulation = request.getParameter("regulation");
		String item = request.getParameter("item");
		subjectObj = SubjectOp.getSubjectByID(subClass + regulation + item).get(0);
		String projectName = request.getParameter("projectName");
		int totalBudget = Integer.parseInt(request.getParameter("totalBudget"));
		int centreBudget = Integer.parseInt(request.getParameter("centreBudget"));
		int provinceBudget = Integer.parseInt(request.getParameter("provinceBudget"));
		int cityLocalBudget = Integer.parseInt(request.getParameter("cityLocalBudget"));
		String cityAndCounty = request.getParameter("cityAndCounty");
		
		//　拆分字符串
		String[] cityAndCountys = cityAndCounty.split(",");
		for (String cc : cityAndCountys) {
			String[] cs = cc.split(":");
			if ((cs[0] != null && !"".equals(cs[0])) && (cs[1] == null || "".equals(cs[1]))) {
				// 添加省项目
				provinceProjectObj = new ProvinceProject();
				provinceProjectObj.setProvince_RFC_PPFK(provinceRfc);
				System.out.println(cs[0]);
				provinceProjectObj.setCity_Name_PPFK(cs[0]);
				provinceProjectObj.setSubject_PPFK(subjectObj.getSBJ_Name());
				provinceProjectObj.setProject_Name(projectName);
				provinceProjectObj.setTotal_Budget(totalBudget);
				provinceProjectObj.setCentre_Budget(centreBudget);
				provinceProjectObj.setProvince_Budget(provinceBudget);
				provinceProjectObj.setCity_Local_Budget(cityLocalBudget);
				provinceProjectObj.setCounty_Budget(Integer.parseInt(cs[2]));
				ProvinceProjectOp.insertProvinceProject(provinceProjectObj);
			}
			if ((cs[0] != null && !"".equals(cs[0])) && (cs[1] != null && !"".equals(cs[1]))) {
				// 封装对象
				cityProjectObj = new CityProject();
				cityProjectObj.setCity_RFC_CPFK(provinceRfc);
				cityProjectObj.setSubject_Name_CPFK(subjectObj.getSBJ_Name());
				System.out.println(cs[1]);
				cityProjectObj.setCounty_name_CPFK(cs[1]);
				cityProjectObj.setTotal_Budget(totalBudget);
				cityProjectObj.setProjec_Name(projectName);
				cityProjectObj.setCounty_Budget(Integer.parseInt(cs[2]));
				CityProjectOp.insertCityProject(cityProjectObj);
			}
		}
		cityProjects = CityProjectOp.getAllCityProject();
		subjects = new ArrayList<Subject>();
		List<String> cityNames = new ArrayList<String>();
		for (CityProject project : cityProjects) {
			countyObj = CountyOp.getAllCountyByCountyName(project.getCounty_name_CPFK()).get(0);
			String cityName = CityOp.getCityByID(countyObj.getCity_FK()).getCityName();
			cityNames.add(cityName);
			subjects.add(SubjectOp.getSubjectByName(project.getSubject_Name_CPFK()).get(0));
		}
		List<Object> result = new ArrayList<Object>();
		result.add(cityProjects);
		result.add(cityNames);
		result.add(subjects);
		jsonArr = JSONArray.fromObject(result);
		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}











