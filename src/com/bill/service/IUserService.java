package com.bill.service;

import com.bill.domain.User;
import com.bill.exception.UserExistException;

public interface IUserService {
	public User loginUser(String userName, String userPwd);
	public void registerUser(User user) throws UserExistException;
	public boolean collectHouse(int userID, int houseID);
	public String addHistory(int userID, int houseID);
	public boolean deleteCollection(int userID, int houseID);

}
