package com.bill.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bill.utils.*;
import com.bill.dao.IUserDao;
import com.bill.domain.User;

public class UserDaoImpl implements IUserDao {

	@Override
	public User find(String userName, String userPwd) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		User user = new User();
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from users where username=? and password=?";
			st = conn.prepareStatement(sql);
			st.setString(1, userName);
			st.setString(2, userPwd);
			rs = st.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setUserPwd(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setPhoneNumber(rs.getString("phonenumber"));
				user.setHistory(rs.getString("history"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
		return user;
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into users(username,password,email,phonenumber) values (?,?,?,?)";
			st = conn.prepareStatement(sql);
			st.setString(1, user.getUserName());
			st.setString(2, user.getUserPwd());
			st.setString(3, user.getEmail());
			st.setString(4, user.getPhoneNumber());
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	public boolean findExist(String userName) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String s = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from users where username=?";
			st = conn.prepareStatement(sql);
			st.setString(1, userName);
			rs = st.executeQuery();
			if (rs.next()) {
				s = rs.getString("username");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
		if (s != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean collectHouse(int userID, int houseID) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String s = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql1 = "select collection from users where id=?";
			st = conn.prepareStatement(sql1);
			st.setInt(1, userID);
			rs = st.executeQuery();
			if (rs.next()) {
				s = rs.getString("collection");
			}
			s = userUtils.processCollect(s, houseID);
			if (!s.equals(rs.getString("collection"))) {
				//System.out.println(s);
				String sql2 = "update users set collection=? where id=?";
				st = conn.prepareStatement(sql2);
				st.setString(1, s);
				st.setInt(2, userID);
				st.executeUpdate();
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
		return false;
	}

	public String addHistory(int userID, int houseID) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String s = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql1 = "select history from users where id=?";
			st = conn.prepareStatement(sql1);
			st.setInt(1, userID);
			rs = st.executeQuery();
			if (rs.next()) {
				s = rs.getString("history");
			}
			s = userUtils.processHistory(s, houseID);
			if (s != rs.getString("history")) {
				String sql2 = "update users set history=? where id=?";
				st = conn.prepareStatement(sql2);
				st.setString(1, s);
				st.setInt(2, userID);
				st.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
		return s;
	}

	public boolean deleteCollection(int userID, int houseID) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String s = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql1 = "select collection from users where id=?";
			st = conn.prepareStatement(sql1);
			st.setInt(1, userID);
			rs = st.executeQuery();
			if (rs.next()) {
				s = rs.getString("collection");
			}
			s = userUtils.processDelete(s, houseID);
			System.out.println(s);
			String sql2 = "update users set collection=? where id=?";
			st = conn.prepareStatement(sql2);
			st.setString(1, s);
			st.setInt(2, userID);
			st.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
		return true;
	}
}
