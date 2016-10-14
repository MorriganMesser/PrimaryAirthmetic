package edu.tju.goliath.util;

import java.util.ArrayList;

public class Split {
	public static ArrayList<String> split(String str) {
		ArrayList<String> list = new ArrayList<String>();
		String s[] = str.split(",");
		for(String i : s) {
			list.add(i);
		}
		return list;
	}
}
