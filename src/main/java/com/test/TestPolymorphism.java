package com.test;


/**
 * ≤‚ ‘∂‡Ã¨
 * 
 * @author yuxiang
 * 
 */
public class TestPolymorphism extends Shape implements MyIntf{

	static void doSomeThing(Shape shape) {
		shape.draw();
		shape.erase();
	}

	public static void main(String[] args) {
		Circle circle = new Circle(1,"2");
		doSomeThing(circle);
		System.out.println("r=" + circle.r);
		System.out.println("d=" + circle.d);

		System.out.println("===========================");

		Line line = new Line();
		doSomeThing(line);

	}

}
