package com.bill.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bill.domain.User;
import com.bill.service.IUserService;
import com.bill.service.impl.UserServiceImpl;

import net.sf.json.JSONArray;


@WebServlet("/DeleteHouseServlet")
public class DeleteHouseServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		IUserService userserv = new UserServiceImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		boolean flag = userserv.deleteCollection(user.getId(), id);
		JSONArray jsonArray = JSONArray.fromObject(flag);
		response.getWriter().print(jsonArray);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
