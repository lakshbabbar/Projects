package com.hcl.ProductDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.Order;

public class MainProg {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("wire.xml");
		OrderLogic ol=(OrderLogic)ctx.getBean("orderLogic");
		ol.display();
	}
}
