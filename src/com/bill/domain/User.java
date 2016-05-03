package com.bill.domain;

import java.io.Serializable;
/**
 * @author gacl
 * 用户实体类
 */
public class User implements Serializable {

    private static final long serialVersionUID = -4313782718477229465L;
    
    // 用户ID
    private int id;
    // 用户名
    private String username;
    // 用户密码
    private String password;
    // 用户邮箱
    private String email;
    // 用户生日
    private String phonenumber;
    
    private String history;
    
    private String collection;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getUserPwd() {
        return password;
    }

    public void setUserPwd(String userPwd) {
        this.password = userPwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phonenumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phonenumber = phoneNumber;
    }

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}
}