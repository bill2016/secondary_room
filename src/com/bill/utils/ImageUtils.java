package com.bill.utils;

import java.io.File;

import com.bill.domain.House;

public class ImageUtils {
	public static String[] getImageName(House[] house) {
		String imgNameTmp[] = null;
		String imgName[]= new String[10000];
		String str;
		for (int i = 0; i < house.length; i++) {
			str="F:\\JAProject\\webproject\\WebContent\\housesimg\\天河\\" + house[0].getTitle();
			System.out.println(str);
			File file = new File(str);
			imgNameTmp = file.list();
			System.out.println(imgNameTmp[0]);
			imgName[i] = imgNameTmp[0];
		}
		return imgName;
	}
}
