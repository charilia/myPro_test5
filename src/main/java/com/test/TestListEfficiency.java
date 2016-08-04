/**
 * 
 */
package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author yuxiang
 * 
 */
public class TestListEfficiency {

	private static List<String> list = new ArrayList<String>();

	List<String> init(int size) {
		for (int i = 0; i < size; i++) {
			list.add("it's No." + i);
		}
		return list;
	}

	public static void main(String[] args) {
		TestListEfficiency effi = new TestListEfficiency();
		effi.init(10000);
		int num = 0;
		long t1, t2;
		// 初试计时
		t1 = System.currentTimeMillis();
		for (String str : list) {
			num += str.length();
		}
		System.out.println("num=" + num);
		num = 0;
		// 第一次循环后计时
		t2 = System.currentTimeMillis();
		System.out.println("First round costs time =" + (t2 - t1) + "Ms");
		for (int i = 0; i < list.size(); i++) {
			num += list.get(i).length();
		}
		System.out.println("num=" + num);
		num = 0;
		// 第二次循环后计时
		t1 = System.currentTimeMillis();
		System.out.println("Second round costs time =" + (t1 - t2) + "Ms");
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			num += iterator.next().length();
		}
		System.out.println("num=" + num);
		num = 0;
		// 第二次循环后计时
		t2 = System.currentTimeMillis();
		System.out.println("Third round costs time =" + (t2 - t1) + "Ms");
		
	}
}
