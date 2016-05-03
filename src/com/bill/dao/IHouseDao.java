package com.bill.dao;

import com.bill.domain.House;
import com.bill.domain.User;

public interface IHouseDao {

	House[] getAll();

	House findHouse(int id);

	House[] SearchByTitle(String title);

	House[] multiParameter(String[] key, String[] value);

	House[] showHistory(String history);

	House[] showCollection(int userid);

}