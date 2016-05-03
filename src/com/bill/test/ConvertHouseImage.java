package com.bill.test;

import java.io.*;

import com.bill.utils.ServiceUtils;

public class ConvertHouseImage {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File f = new File("D:\\tmp");
		Writer fw = new FileWriter("D:\\houses.txt");
		getFiles(f, fw);
		fw.close();
	}

	private static void getFiles(File dir, Writer fw) throws Exception {
		File[] files = dir.listFiles();
		for (File f : files) {
			String s = ServiceUtils.md5(f.getName());
			String[] symbol = { "/", "\\", ":", "*", "?", "\"", "<", ">", "|" };
			for (int i = 0; i < symbol.length; i++) {
				s = s.replace(symbol[i], "a");
			}
			if (f.isDirectory()) {
				s = s.substring(0, 10);
				if(!new File("D:\\housesimage\\" + s).mkdirs()){
					System.out.println("error----------------------------------------------------------------------------------------");
				}
				getFiles(f, fw);
			} else {
				String jpg = "." + f.getName().split("\\.")[1];
				if (jpg.equals(".jpg") || jpg.equals(".png")) {
					String[] path = f.getParent().split("\\\\");
					String ss = ServiceUtils.md5(path[path.length - 1]).substring(0, 10);
					for (int i = 0; i < symbol.length; i++) {
						ss = ss.replace(symbol[i], "a");
					}
					String str = "housesimage\\" + ss;
					str = str + "\\" + s + jpg; // 最终图片名
					System.out.println(str);
					fw.write(str + "\r\n");
					str = "D:\\" + str;
					//移动图片 并重命名
					if (!f.renameTo(new File(str))) {
						System.out.println("error-----------------------------------------------------------------------------------------------");
					}
				}
			}
		}
	}

}
