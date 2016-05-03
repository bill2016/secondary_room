package com.bill.test;

import java.io.File;

public class test {
	public static void main(String[] args) {
		String imgName[] = null;
		for (int i = 0; i < 10; i++) {
			File file = new File("F:\\JAProject\\webproject\\WebContent\\housesimg\\天河\\远洋明苑 送豪华装修 业主自住 看房方便");
			imgName = file.list();
		}
		for (int i = 0; i < imgName.length; i++) {
			System.out.println(imgName[i]);
		}
	}

}
