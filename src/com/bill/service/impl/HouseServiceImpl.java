package com.bill.service.impl;

import com.bill.dao.IHouseDao;
import com.bill.dao.impl.HouseDaoImpl;
import com.bill.domain.House;
import com.bill.domain.User;
import com.bill.service.IHouseService;

public class HouseServiceImpl implements IHouseService {

	private IHouseDao houseDao = new HouseDaoImpl();

	@Override
	public House[] getAll() {
		return houseDao.getAll();
	}

	public House findHouse(int id) {
		return houseDao.findHouse(id);
	}

	public House[] SearchByTitle(String title) {
		return houseDao.SearchByTitle(title);
	}

	public House[] multiParameter(String[] key, String[] value) {
		return houseDao.multiParameter(key, value);
	}

	public House[] showHistory(String history) {
		return houseDao.showHistory(history);
	}
	
	public House[] showCollection(int userid) {
		return houseDao.showCollection(userid);
	}
}
