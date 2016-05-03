package com.bill.dao;

import com.bill.domain.User;

public interface IUserDao {

    /**
     * 根据用户名和密码来查找用户
     * @param userName
     * @param userPwd
     * @return 查到到的用户
     */
    public User find(String userName, String userPwd);
    public void add(User user);
    public boolean findExist(String userName);
	public boolean collectHouse(int userID, int houseID);
	public String addHistory(int userID, int houseID);
	public boolean deleteCollection(int userID, int houseID);



}