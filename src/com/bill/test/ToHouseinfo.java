package com.bill.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bill.dao.impl.ImageDaoImpl;
import com.bill.domain.House;
import com.bill.domain.Image;
import com.bill.domain.User;
import com.bill.utils.JdbcUtils;

public class ToHouseinfo {
	public static void main(String[] args) throws Exception {
		House[] house = getAll();
		Image[] image = ImageDaoImpl.getAll();
		for (int i = 0; i < house.length; i++) {
			for (int j = 0; j < image.length; j++) {
				if (house[i].getId() == image[j].getHouseid()) {
					house[i].setFirstimg(image[j].getPath());
					break;
				}
			}
		}
		createHousesinfoTable(); // 删除并建立Housesinfo表
		insertToHousesinfo(house); // 将house对象的信息charity到Housesinfo表
		System.out.println("success!");
		// System.out.println("------------------------------------------------------------");
		// for(int i=0;i<house.length;i++)
		// System.out.println(house[i].getId()+" "+house[i].getFirstimg());
	}

	public static void createHousesinfoTable() {
		Connection conn = null;
		Statement st = null;
		try {
			conn = JdbcUtils.getConnection();
			st = conn.createStatement();
			String sqldrop = "drop tables if exists housesinfo";
			String sqlcreate = "create table housesinfo(" + "id INT NOT NULL AUTO_INCREMENT,"
					+ "title VARCHAR(100) NOT NULL," + "city VARCHAR(10) NOT NULL," + "district VARCHAR(10) NOT NULL,"
					+ "cost  int NOT NULL," + "prize VARCHAR(40) NOT NULL," + "area int NOT NULL,"
					+ "room VARCHAR(40) NOT NULL," + "floor  VARCHAR(40) NOT NULL," + "year VARCHAR(40) NOT NULL,"
					+ "name VARCHAR(60) NOT NULL," + "seller VARCHAR(10) NOT NULL," + "phone VARCHAR(20) NOT NULL,"
					+ "description  VARCHAR(800)," + "firstimg VARCHAR(200)," + "PRIMARY KEY ( id ))";
			st.executeUpdate(sqldrop);
			st.executeUpdate(sqlcreate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
				String sql = "insert into housesinfo (title,city,district,cost,prize,area,room,floor,year,name,seller,phone,description,firstimg ) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
				st.setString(14, house[i].getFirstimg());
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
			String sql = "select * from houses";
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
