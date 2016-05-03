package com.bill.utils;

public class KVUtils {
	public static String[] kvProcessing(String[] arr, int i) {
		String[] str = new String[i];
		for(int j=0;j<i;j++){
			str[j]=arr[j];
		}
		return str;
	}
}
