package com.bill.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bill.dao.IHouseDao;
import com.bill.domain.House;
import com.bill.domain.User;
import com.bill.utils.JdbcUtils;
import com.bill.utils.StringUtils;
import com.bill.utils.houseUtils;
import com.bill.utils.userUtils;

public class HouseDaoImpl implements IHouseDao {

	@Override
	public House[] getAll() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		House[] house = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from housesinfo";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			rs.last();
			int i = rs.getRow();
			house = new House[i];
			rs.beforeFirst();
			i = 0;
			while (rs.next()) {
				house[i] = new House();
				house[i].setId(rs.getInt("id"));
				house[i].setTitle(rs.getString("title"));
				house[i].setCity(rs.getString("city"));
				house[i].setDistrict(rs.getString("district"));
				house[i].setCost(rs.getString("cost"));
				house[i].setPrize(rs.getString("prize"));
				house[i].setArea(rs.getString("area"));
				house[i].setRoom(rs.getString("room"));
				house[i].setFloor(rs.getString("floor"));
				house[i].setYear(rs.getString("year"));
				house[i].setName(rs.getString("name"));
				house[i].setSeller(rs.getString("seller"));
				house[i].setPhone(rs.getString("phone"));
				house[i].setDescription(rs.getString("description"));
				house[i].setFirstimg(rs.getString("firstimg"));
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
		return house;
	}

	@Override
	public House findHouse(int id) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		House house = new House();
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from housesinfo where id=?";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				house.setId(rs.getInt("id"));
				house.setTitle(rs.getString("title"));
				house.setCity(rs.getString("city"));
				house.setDistrict(rs.getString("district"));
				house.setCost(rs.getString("cost"));
				house.setPrize(rs.getString("prize"));
				house.setArea(rs.getString("area"));
				house.setRoom(rs.getString("room"));
				house.setFloor(rs.getString("floor"));
				house.setYear(rs.getString("year"));
				house.setName(rs.getString("name"));
				house.setSeller(rs.getString("seller"));
				house.setPhone(rs.getString("phone"));
				house.setDescription(rs.getString("description"));
				house.setFirstimg(rs.getString("firstimg"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
		return house;
	}

	public House[] SearchByTitle(String title) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		House[] house = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from housesinfo where title like ?";
			st = conn.prepareStatement(sql);
			st.setString(1, "%" + title + "%");
			rs = st.executeQuery();
			rs.last();
			int i = rs.getRow();
			house = new House[i];
			rs.beforeFirst();
			i = 0;
			while (rs.next()) {
				house[i] = new House();
				house[i].setId(rs.getInt("id"));
				house[i].setTitle(rs.getString("title"));
				house[i].setCity(rs.getString("city"));
				house[i].setDistrict(rs.getString("district"));
				house[i].setCost(rs.getString("cost"));
				house[i].setPrize(rs.getString("prize"));
				house[i].setArea(rs.getString("area"));
				house[i].setRoom(rs.getString("room"));
				house[i].setFloor(rs.getString("floor"));
				house[i].setYear(rs.getString("year"));
				house[i].setName(rs.getString("name"));
				house[i].setSeller(rs.getString("seller"));
				house[i].setPhone(rs.getString("phone"));
				house[i].setDescription(rs.getString("description"));
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
		return house;
	}

	public House[] multiParameter(String[] key, String[] value) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		House[] house = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql;
			if (key.length == 1) {
				sql = "select * from housesinfo limit 0,20";
			} else {
				sql = StringUtils.getSql(key, value);
			}
			//System.out.println(sql);
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			rs.last();
			int i = rs.getRow();
			house = new House[i];
			rs.beforeFirst();
			i = 0;
			while (rs.next()) {
				house[i] = new House();
				house[i].setId(rs.getInt("id"));
				house[i].setTitle(rs.getString("title"));
				house[i].setCity(rs.getString("city"));
				house[i].setDistrict(rs.getString("district"));
				house[i].setCost(rs.getString("cost"));
				house[i].setPrize(rs.getString("prize"));
				house[i].setArea(rs.getString("area"));
				house[i].setRoom(rs.getString("room"));
				house[i].setFloor(rs.getString("floor"));
				house[i].setYear(rs.getString("year"));
				house[i].setName(rs.getString("name"));
				house[i].setSeller(rs.getString("seller"));
				house[i].setPhone(rs.getString("phone"));
				house[i].setDescription(rs.getString("description"));
				house[i].setFirstimg(rs.getString("firstimg"));
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
		return house;
	}

	public House[] showHistory(String history) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		House[] house = null;
		try {
			conn = JdbcUtils.getConnection();
			String[] s = history.split(",");
			String his1 = history;
			history = houseUtils.getInString(s);
			String sql = "select * from housesinfo where id in " + history + " order by find_in_set(id, '" + his1
					+ "')";
			st = conn.prepareStatement(sql);
			for (int i = 0; i < s.length; i++) {
				st.setInt(i + 1, Integer.parseInt(s[i]));
			}
			rs = st.executeQuery();
			house = new House[s.length];
			int i = 0;
			while (rs.next()) {
				house[i] = new House();
				house[i].setId(rs.getInt("id"));
				house[i].setTitle(rs.getString("title"));
				house[i].setCity(rs.getString("city"));
				house[i].setDistrict(rs.getString("district"));
				house[i].setCost(rs.getString("cost"));
				house[i].setPrize(rs.getString("prize"));
				house[i].setArea(rs.getString("area"));
				house[i].setRoom(rs.getString("room"));
				house[i].setFloor(rs.getString("floor"));
				house[i].setYear(rs.getString("year"));
				house[i].setName(rs.getString("name"));
				house[i].setSeller(rs.getString("seller"));
				house[i].setPhone(rs.getString("phone"));
				house[i].setDescription(rs.getString("description"));
				house[i].setFirstimg(rs.getString("firstimg"));
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
		return house;
	}

	public House[] showCollection(int userid) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String s = null;
		String coll = null;
		House[] house = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql1 = "select collection from users where id=?";
			st = conn.prepareStatement(sql1);
			st.setInt(1, userid);
			rs = st.executeQuery();
			if (rs.next()) {
				s = rs.getString("collection");
			}
			String[] str = s.split(",");
			coll = houseUtils.getInString(str);
			String sql2 = null;
			if (!s.equals("")) {
				sql2 = "select * from housesinfo where id in " + coll + " order by find_in_set(id, '" + s + "') desc";

				st = conn.prepareStatement(sql2);
				for (int i = 0; i < str.length; i++) {
					st.setInt(i + 1, Integer.parseInt(str[i]));
				}
				rs = st.executeQuery();
				house = new House[str.length];
				int i = 0;
				while (rs.next()) {
					house[i] = new House();
					house[i].setId(rs.getInt("id"));
					house[i].setTitle(rs.getString("title"));
					house[i].setCity(rs.getString("city"));
					house[i].setDistrict(rs.getString("district"));
					house[i].setCost(rs.getString("cost"));
					house[i].setPrize(rs.getString("prize"));
					house[i].setArea(rs.getString("area"));
					house[i].setRoom(rs.getString("room"));
					house[i].setFloor(rs.getString("floor"));
					house[i].setYear(rs.getString("year"));
					house[i].setName(rs.getString("name"));
					house[i].setSeller(rs.getString("seller"));
					house[i].setPhone(rs.getString("phone"));
					house[i].setDescription(rs.getString("description"));
					house[i].setFirstimg(rs.getString("firstimg"));
					i++;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
		return house;
	}

}
