package com.bill.service.impl;

import com.bill.dao.IUserDao;
import com.bill.dao.impl.UserDaoImpl;
import com.bill.domain.User;
import com.bill.exception.UserExistException;
import com.bill.service.IUserService;
import com.bill.utils.ServiceUtils;

public class UserServiceImpl implements IUserService {

	private IUserDao userDao = new UserDaoImpl();

	@Override
	public User loginUser(String username, String password) {
		password = ServiceUtils.md5(password);
		return userDao.find(username, password);
	}

	@Override
	public void registerUser(User user) throws UserExistException {
		boolean b = userDao.findExist(user.getUserName());
		if (b) {
			throw new UserExistException();
		} else {
			user.setUserPwd(ServiceUtils.md5(user.getUserPwd()));
			userDao.add(user);
		}
	}

	public boolean collectHouse(int userID,int houseID){
		return userDao.collectHouse(userID,houseID);
	}
	
	public boolean deleteCollection(int userID,int houseID){
		return userDao.deleteCollection(userID,houseID);
	}
	
	public String addHistory(int userID,int houseID){
		return userDao.addHistory(userID,houseID);
	}

}