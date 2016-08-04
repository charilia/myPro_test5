package com.infocore.test;

import java.util.ArrayList;
import java.util.List;

import com.infocore.utils.JsonConvert;

public class testHello {

	public static void main(String[] args) {
		String result = "success";
		System.out.println(JsonConvert.objectoJson(result));
	}
}
