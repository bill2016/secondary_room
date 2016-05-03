package com.bill.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.bill.domain.House;
import com.bill.domain.Image;
import com.bill.domain.User;
import com.bill.utils.JdbcUtils;
import com.bill.utils.ServiceUtils;

public class CreateImageTable {

	public static void main(String[] args) throws Exception {
		//
		File fi = new File("D:\\houses.txt");
		FileReader fr = new FileReader(fi);
		BufferedReader br = new BufferedReader(fr);

		String[] path = getImgName(br); // 改String数组存图片路径

		// house数据表写到text
		House[] house = getAll();
		System.out.println(house[10].getTitle());
		try {
			writeToText(house);
		} catch (IOException e) {
			System.out.println("error!");
		}

		// 实例化图片javabean对象
		Image[] images = createImgObj(house, path);
		System.out.println(images[0].getHouseid());
		// for (int i = 0; i < 469; i++) {
		// System.out.println(images[i].getPath());
		// }
		
		//删除并建立image表
		createImageTable();
		
		// 插入到images数据表
		insertToImgTable(images);
		System.out.println("success!");
	}

	public static void insertToImgTable(Image[] images) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			for (int i = 0; i < 469; i++) { //// 只有469张图片!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				String sql = "insert into imagestest(houseid,path) values (?,?)";
				st = conn.prepareStatement(sql);
				st.setInt(1, images[i].getHouseid());
				st.setString(2, images[i].getPath());
				st.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	public static Image[] createImgObj(House[] house, String[] path) {
		Image[] images = new Image[path.length];
		int n = 0;
		for (int j = 0; j < house.length; j++) {
			for (int i = 0; i < path.length; i++) {
				String s = path[i].split("\\\\")[1];
				if (s.equals(house[j].getTitle())) {
					images[n] = new Image();
					images[n].setHouseid(house[j].getId());
					images[n].setPath(path[i]);
					n++;
				}
			}
		}
		System.out.println(n); // 只有469张图片!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		return images;
	}

	public static String[] getImgName(BufferedReader br) throws Exception {
		ArrayList<String> list = new ArrayList<String>();
		String line = br.readLine();
		while (line != null) {
			list.add(line);
			line = br.readLine();
		}
		Iterator<String> iter = list.iterator();
		String[] path = new String[list.size()];
		int i = 0;
		while (iter.hasNext()) {
			path[i] = iter.next();
			i++;
		}
		return path;
	}

	public static void writeToText(House[] house) throws IOException {
		Writer fw = new FileWriter("D:\\id&title.txt");
		for (int i = 0; i < house.length; i++) {
			fw.write(house[i].getId() + "     " + house[i].getTitle() + "\r\n");
		}
		fw.close();
	}

	public static House[] getAll() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		House[] house = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select id,title from houses";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			rs.last();
			int i = rs.getRow();
			house = new House[i];
			rs.beforeFirst();
			i = 0;
			while (rs.next()) {
				house[i] = new House();
				house[i].setId(rs.getInt("id"));
				house[i].setTitle(ServiceUtils.md5(rs.getString("title")).substring(0, 10));
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
		return house;
	}

	public static void createImageTable() {
		Connection conn = null;
		Statement st = null;
		try {
			conn = JdbcUtils.getConnection();
			st = conn.createStatement();
			String sqldrop = "drop tables if exists imagestest";
			String sqlcreate = "create table imagestest(id INT NOT NULL AUTO_INCREMENT,houseid INT NOT NULL,path VARCHAR(500) ,PRIMARY KEY ( id ))";
			st.executeUpdate(sqldrop);
			st.executeUpdate(sqlcreate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
