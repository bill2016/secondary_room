package com.bill.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bill.domain.House;
import com.bill.domain.User;
import com.bill.service.IHouseService;
import com.bill.service.IUserService;
import com.bill.service.impl.HouseServiceImpl;
import com.bill.service.impl.UserServiceImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		// 获取用户填写的登录用户名，密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username != null) {
			IUserService service = new UserServiceImpl();
			// 用户登录
			User user = service.loginUser(username, password);
			if (user.getUserName() == null) {
				request.setAttribute("message", "用户名或密码错误");
				request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
				return;
			}

			HttpSession session = request.getSession();
			String sessionid = session.getId();
			Cookie cookie = new Cookie("JSESSIONID", sessionid);
			cookie.setPath("/webproject");
			cookie.setMaxAge(30 * 60);
			response.addCookie(cookie);
			session.setAttribute("user", user);
		}
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		return;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}