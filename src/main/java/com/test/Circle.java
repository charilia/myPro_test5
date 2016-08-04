/**
 * 
 */
package com.test;

/**
 * @author yuxiang
 * 
 */
public class Circle extends Shape {

	int r;

	String d;

	Circle(int i) {
		System.out.println("this is Circle's No." + i + " constructor!");
	};

	Circle() {
		System.out.println("this is constructor of Circle!");
	};

	Circle(int r, String d) {
		this();
		this.r = r;
		this.d = d;
		System.out.println("this is Circle's constructor!");
	};

	void draw() {
		System.out.println("Draw Circle!");
	}

	void erase() {
		System.out.println("Erase Circle!");
	}

}
