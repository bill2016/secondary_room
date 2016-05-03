package com.bill.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bill.domain.User;
import com.bill.exception.UserExistException;
import com.bill.service.IUserService;
import com.bill.service.impl.UserServiceImpl;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phonenumber = request.getParameter("phonenumber");
		IUserService service = new UserServiceImpl();
		// 用户登录
		User user = new User();
		user.setUserName(username);
		user.setUserPwd(password);
		user.setEmail(email);
		user.setPhoneNumber(phonenumber);
		
		if(!password.equals(request.getParameter("confirmpassword"))){
			request.setAttribute("unconsist", "两次密码不一致");
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request,response);
			return;
		}
		try {
			service.registerUser(user);
		} catch (UserExistException e) {
			request.setAttribute("exist", "用户名已存在");
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request,response);
			return;
		}
		request.setAttribute("message", "注册成功！！ <meta http-equiv='refresh' content='3;url="+request.getContextPath()+"/LoginUIServlet'>");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
