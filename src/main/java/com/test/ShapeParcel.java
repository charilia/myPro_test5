/**
 * 
 */
package com.test;

/**
 * @author yuxiang
 * 
 */
public class ShapeParcel {

	private String name;

	class CircleParcel {

		CircleParcel(String str) {
			name = str;
			System.out.println("CircleParcel constructor!");
		}

		void draw() {
			System.out.println("Draw Circle!");
		}

		void erase() {
			System.out.println("Erase Circle!");
		}
	}

	class LineParcel {

		LineParcel() {
			System.out.println("LineParcel constructor!");
		}

		void draw() {
			System.out.println("Draw Line!");
		}

		void erase() {
			System.out.println("Erase Line!");
		}
	}

	void draw() {
		CircleParcel circle = new CircleParcel("111");
		LineParcel line = new LineParcel();
		System.out.println("drwa success!" + name);
	}

	public static void main(String[] args) {
		ShapeParcel shape = new ShapeParcel();
		shape.draw();
	}
}
