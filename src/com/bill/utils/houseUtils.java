package com.bill.utils;

public class houseUtils {
	public static String getInString(String[] history) {
		String str = "(" + "?";
		for (int i = 1; i < history.length; i++) {
			str = str + "," + "?";
		}
		str = str + ")";
		return str;
	}

	public static void main(String[] args) {
		String[] str = {"1","3"};
		String s = getInString(str);
		System.out.println(s);
	}
}
