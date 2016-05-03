package com.bill.test;

import com.bill.domain.House;
import com.bill.domain.User;
import com.bill.exception.UserExistException;
import com.bill.service.IHouseService;
import com.bill.service.IUserService;
import com.bill.service.impl.HouseServiceImpl;
import com.bill.service.impl.UserServiceImpl;

public class TestService {
	public static void main(String[] args) {
		testShowCollection();
	}

	public static void testLogin() {
		IUserService service = new UserServiceImpl();
		User user = service.loginUser("aaa", "123");
		System.out.println(user.getUserName());
		System.out.println(user.getEmail());
	}

	public static void testRegister() {
		IUserService service = new UserServiceImpl();
		User user = new User();
		user.setUserName("aaa");
		user.setUserPwd("aaa");
		user.setEmail("123@qq.com");
		user.setPhoneNumber("23456");
		try {
			service.registerUser(user);
			System.out.println("succeed!");
		} catch (UserExistException e) {
			// TODO Auto-generated catch block
			System.out.println("exist!");
		}
	}

	public static void testHouseList() {
		IHouseService service = new HouseServiceImpl();
		House[] house = service.getAll();
		System.out.println(house);
		for (House h : house) {
			System.out.println(h.getName());
			System.out.println(h.getArea());
		}
	}

	public static void testSearchByTitle() {
		IHouseService service = new HouseServiceImpl();
		House[] house = service.SearchByTitle("中海康");
		System.out.println(house);
		for (House h : house) {
			System.out.println(h.getName());
		}
	}

	public static void testMultiParameter() {
		IHouseService service = new HouseServiceImpl();
		// String[] key = {"district","cost","room","area"};
		String[] key = new String[4];
		key[0] = "district";
		key[1] = "cost";
		key[2] = "room";
		key[3] = "area";
		System.out.println(key.length);
		String[] value = { "番禺", "150-300", "3室", "50-100" };
		House[] house = service.multiParameter(key, value);
		System.out.println(house);
		for (House h : house) {
			// System.out.print(h.getName()+" ");
			System.out.print(h.getDistrict() + "  ");
			System.out.print(h.getCost() + "  ");
			System.out.print(h.getRoom() + "  ");
			System.out.print(h.getArea() + "  \n");
		}
	}

	public static void testCollectHouse() {
		IUserService service = new UserServiceImpl();
		System.out.println(service.collectHouse(1,99));
	}

	public static void testAddHistory() {
		IUserService service = new UserServiceImpl();
		System.out.println(service.addHistory(1, 57));
	}

	public static void testShowHistory() {
		IHouseService service = new HouseServiceImpl();
		House[] house = service.showHistory("9");
		for (House h : house) {
			System.out.print(h.getId());
			System.out.println(h.getName());
		}
	}
	public static void testShowCollection() {
		IHouseService service = new HouseServiceImpl();
		House[] house = service.showCollection(1);
		for (House h : house) {
			System.out.print(h.getId());
			System.out.println(h.getName());
		}
	}
}
