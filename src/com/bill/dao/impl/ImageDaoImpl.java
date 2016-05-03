package com.bill.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bill.domain.Image;
import com.bill.utils.JdbcUtils;

public class ImageDaoImpl {
	public static Image[] getAll() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Image[] image = null;

		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from images";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			rs.last();
			int i = rs.getRow();
			image = new Image[i];
			rs.beforeFirst();
			i = 0;
			while (rs.next()) {
				image[i] = new Image();
				image[i].setHouseid(rs.getInt("houseid"));
				image[i].setPath(rs.getString("path"));
				i++;
			}
		} catch (SQLException e) {
			System.out.println("error");
		}
		return image;
	}
}
