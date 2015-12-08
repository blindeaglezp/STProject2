package com.be.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.be.utils.CharacterUtil;

import uno.allen.entity.User;
import uno.allen.fun.UserOp;

/**
 * 登录Servlet
 * @author blindeagle
 * @version 1.0
 * @data 2015.11.29
 */
@WebServlet(name="LoginServlet",urlPatterns="/servlet/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User user = null;
	private List<User> users = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CharacterUtil.setCharToUTF8(request, response);
		
		String type = request.getParameter("type");
		
		switch (type) {
		case "checkUser" : checkUser(request, response); break;
		case "quit" : quit(request, response); break;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void quit(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		try {
			response.sendRedirect("/STProject2/login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 检查用户
	 * @author blindeagle
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return void
	 */
	private void checkUser(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		users = UserOp.getUserByUserName(userName);
		if (users != null && users.size() > 0) {
			user = users.get(0);
		}
		try {
			if (user != null && password.equals(user.getUser_Password())) {
				request.getSession().setAttribute("user", user);
				String userLevel = user.getUser_Level();
				if ("省级".equals(userLevel)) {
					request.getRequestDispatcher("/WEB-INF/jsp/province/functionShow.jsp").forward(request, response);
				} else if ("市级".equals(userLevel)) {
					request.getRequestDispatcher("/WEB-INF/jsp/city/functionShow.jsp").forward(request, response);
				} else if ("县级".equals(userLevel)) {
					request.getRequestDispatcher("/servlet/CountyServlet?type=toProjectManage").forward(request, response);
				}
			} else {
					response.sendRedirect(request.getContextPath() + "/login.jsp");
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
