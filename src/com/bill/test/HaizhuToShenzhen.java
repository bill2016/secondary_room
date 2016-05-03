package com.bill.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bill.domain.House;
import com.bill.utils.JdbcUtils;

public class HaizhuToShenzhen {

	public static void main(String[] args) {
		House[] house = getAll();
		insertToHousesinfo(house);

	}
	
	public static void insertToHousesinfo(House[] house) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			int i = 0;
			while (i < house.length) {
				// if (house[i].getFirstimg() != null) {
				String sql = "insert into housesinfo (title,city,district,cost,prize,area,room,floor,year,name,seller,phone,description ) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				st = conn.prepareStatement(sql);
				st.setString(1, house[i].getTitle());
				st.setString(2, house[i].getCity());
				st.setString(3, house[i].getDistrict());
				st.setString(4, house[i].getCost());
				st.setString(5, house[i].getPrize());
				st.setString(6, house[i].getArea());
				st.setString(7, house[i].getRoom());
				st.setString(8, house[i].getFloor());
				st.setString(9, house[i].getYear());
				st.setString(10, house[i].getName());
				st.setString(11, house[i].getSeller());
				st.setString(12, house[i].getPhone());
				st.setString(13, house[i].getDescription());
				st.executeUpdate();
				// }
				System.out.println(i);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	public static House[] getAll() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		House[] house = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from houses where district='海珠'";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			rs.last();
			int i = rs.getRow();
			house = new House[i];
			rs.beforeFirst();
			i = 0;
			while (rs.next()) {
				house[i] = new House();
				house[i].setTitle(rs.getString("title"));
				house[i].setCity("深圳");
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
}
