package com.bill.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bill.domain.House;
import com.bill.domain.User;
import com.bill.service.IHouseService;
import com.bill.service.IUserService;
import com.bill.service.impl.HouseServiceImpl;
import com.bill.service.impl.UserServiceImpl;

@WebServlet("/DetailHouseServlet")
public class DetailHouseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		IHouseService service = new HouseServiceImpl();
		House house = service.findHouse(id);
		request.setAttribute("house", house);

		IUserService userserv = new UserServiceImpl();
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			user.setHistory(userserv.addHistory(user.getId(), id));

			House[] houses = service.showHistory(user.getHistory());
			request.setAttribute("houses", houses);
		}
		request.getRequestDispatcher("/WEB-INF/jsp/detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
