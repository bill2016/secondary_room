package com.bill.utils;

public class StringUtils {
	public static int[] costProcessing(String cost) {
		String[] str = cost.split("-");
		int[] i = new int[2];
		i[0] = Integer.parseInt(str[0]);
		i[1] = Integer.parseInt(str[1]);
		return i;
	}

	public static int[] areaProcessing(String area) {
		String[] str = area.split("-");
		int[] i = new int[2];
		i[0] = Integer.parseInt(str[0]);
		i[1] = Integer.parseInt(str[1]);
		return i;
	}

	public static String getSql(String[] key, String[] value) {
		String sql = "select * from housesinfo where";
		String limit = " ";
		String orderBy = " ";
		int i = 0;
		while (i < key.length) {
			if (key[i].equals("city")) {
				if (i == 1) {
					sql = sql + " city=" + "'" + value[i] + "'";
				} else {
					sql = sql + " and city=" + "'" + value[i] + "'";
				}
				i++;
			} else if (key[i].equals("district")) {
				if (i == 1) {
					sql = sql + " district=" + "'" + value[i] + "'";
				} else {
					sql = sql + " and district=" + "'" + value[i] + "'";
				}
				i++;
			} else if (key[i].equals("room")) {
				if (i == 1) {
					sql = sql + " room like '%" + value[i] + "%'";
				} else {
					sql = sql + " and room like '%" + value[i] + "%'";
				}
				i++;
			} else if (key[i].equals("year")) {
				if (i == 1) {
					sql = sql + " year like '%" + value[i] + "%'";
				} else {
					sql = sql + " and year like '%" + value[i] + "%'";
				}
				i++;
			} else if (key[i].equals("title")) {
				if (i == 1) {
					sql = sql + " title like '%" + value[i] + "%'";
				} else {
					sql = sql + " and title like '%" + value[i] + "%'";
				}
				i++;
			} else if (key[i].equals("name")) {
				if (i == 1) {
					sql = sql + " name like '%" + value[i] + "%'";
				} else {
					sql = sql + " and name like '%" + value[i] + "%'";
				}
				i++;
			} else if (key[i].equals("cost")) {
				if (i == 1) {
					if (value[i].equals("50")) {
						sql = sql + " cost<=50";
					} else if (value[i].equals("200")) {
						sql = sql + " cost>=200";
					} else {
						int[] cost;
						cost = costProcessing(value[i]);
						sql = sql + " cost>=" + cost[0] + " and cost<=" + cost[1];
					}
					i++;
				} else {
					if (value[i].indexOf("-") != -1) {
						int[] cost;
						cost = costProcessing(value[i]);
						sql = sql + " and cost>=" + cost[0] + " and cost<=" + cost[1];
					} else if (Integer.parseInt(value[i]) == 50) {
						sql = sql + " and cost<=50";
					} else if (Integer.parseInt(value[i]) == 200) {
						sql = sql + " and cost>=200";
					}
					i++;
				}
			} else if (key[i].equals("area")) {
				if (i == 1) {
					if (value[i].equals("50")) {
						sql = sql + " area<=50";
					} else if (value[i].equals("140")) {
						sql = sql + " area>=140";
					} else {
						int[] area;
						area = areaProcessing(value[i]);
						sql = sql + " area>=" + area[0] + " and area<=" + area[1];
					}
					i++;
				} else {
					if (value[i].indexOf("-") != -1) {
						int[] area;
						area = areaProcessing(value[i]);
						sql = sql + " and area>=" + area[0] + " and area<=" + area[1];
					} else if (Integer.parseInt(value[i]) == 50) {
						sql = sql + " and area<=50";
					} else if (Integer.parseInt(value[i]) == 140) {
						sql = sql + " and area>=140";
					}
					i++;
				}
			} else if (key[i].equals("page")) {
				limit = " limit " + (Integer.parseInt(value[i]) - 1) * 10 + "," + 20;
				i++;
			} else if (key[i].equals("co")) {
				if (value[i].equals("up")) {
					orderBy = " order by cost";
				} else if (value[i].equals("down")) {
					orderBy = " order by cost desc";
				}
				i++;
			} else if (key[i].equals("ar")) {
				if (value[i].equals("up")) {
					orderBy = " order by area";
				} else if (value[i].equals("down")) {
					orderBy = " order by area desc";
				}
				i++;
			}
		}
		sql = sql + orderBy + limit;
		return sql;
	}
}
