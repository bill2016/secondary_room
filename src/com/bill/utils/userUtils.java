package com.bill.utils;

public class userUtils {
	public static String processCollect(String s, int houseID) {
		if (s==null||s.equals("")) {
			s = Integer.toString(houseID);
		} else if (!s.contains(Integer.toString(houseID))) {
			s = s + "," + Integer.toString(houseID);
		}
		return s;
	}

	public static String processDelete(String s, int houseID) {
		if (s.length() == 1) {
			s = "";
		} else {
			String[] str = s.split(",");
			s = "";
			for (int i = 0; i < str.length; i++) {
				if (!str[i].equals(Integer.toString(houseID))) {
					s = s + str[i] + ",";
				}
			}
		}
		if (s.contains(",")) {
			s = s.substring(0, s.length() - 1);
		}else{
			s="";
		}
		return s;
	}

	public static String processHistory(String s, int houseID) {

		if (s == null) {
			s = Integer.toString(houseID);
			return s;
		}
		String[] str = s.split(",");
		for (int i = 0; i < str.length; i++) {
			if (str[i].equals(Integer.toString(houseID))) {
				return s;
			}
		}
		if (s.split(",").length < 5) {
			s = s + "," + Integer.toString(houseID);
		} else {
			s = str[1] + "," + str[2] + "," + str[3] + "," + str[4] + "," + Integer.toString(houseID);
		}
		return s;
	}
}
