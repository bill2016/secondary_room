package com.bill.service;

import com.bill.domain.House;

public interface IHouseService {

	House[] getAll();

	House findHouse(int id);

	House[] SearchByTitle(String title);

	House[] multiParameter(String[] key, String[] value);

	House[] showHistory(String history);

	House[] showCollection(int userid);

}