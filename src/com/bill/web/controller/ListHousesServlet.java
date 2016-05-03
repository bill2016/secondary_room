package com.bill.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bill.dao.impl.HouseDaoImpl;
import com.bill.domain.House;
import com.bill.domain.User;
import com.bill.service.IHouseService;
import com.bill.service.IUserService;
import com.bill.service.impl.HouseServiceImpl;
import com.bill.service.impl.UserServiceImpl;
import com.bill.utils.ImageUtils;
import com.bill.utils.KVUtils;

@WebServlet("/ListHousesServlet")
public class ListHousesServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		Enumeration pNames = request.getParameterNames();
		String[] key = new String[10];
		String[] value = new String[10];
		IHouseService service = new HouseServiceImpl();
		House[] house = null;
		int i = 0;
		while (pNames.hasMoreElements()) {
			key[i] = (String) pNames.nextElement();
			value[i] = request.getParameter(key[i]);
			i++;
		}
		String[] str1 = KVUtils.kvProcessing(key, i);
		String[] str2 = KVUtils.kvProcessing(value, i);
		if (key[0] == null) {
			house = service.getAll();
		} else {
			house = service.multiParameter(str1, str2);
		}
		// String[] imgs = ImageUtils.getImageName(house);
		// request.setAttribute("imgs", imgs);
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			House[] houses = service.showHistory(user.getHistory());
			request.setAttribute("houses", houses);
		}
		request.setAttribute("key", str1);
		request.setAttribute("len", str1.length);
		request.setAttribute("value", str2);
		request.setAttribute("house", house);
		request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
