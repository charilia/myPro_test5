package com.my1.business;

import com.my1.intf.HelloBusiness;

public class HelloBusinessImpl implements HelloBusiness{

	@Override
	public void sayHello(String obj) {
		System.out.println("�����ҵ�sayHello�ľ���ʵ�ַ���=="+obj);
		
	}

}
