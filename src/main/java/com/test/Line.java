/**
 * 
 */
package com.test;


/**
 * @author yuxiang
 *
 */
public class Line extends Shape{
	
	Line(){
		System.out.println("this is constructor of Line!");
	}

	void draw(){
		System.out.println("Draw Line!");
	}
	
	void erase(){
		System.out.println("Erase Line!");
	}
}
