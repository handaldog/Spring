package aop_ver2_annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("aop_ver2_annotation/beans.xml");

		boy sumin = cpx.getBean("boy", boy.class);
		girl jimin = cpx.getBean("girl", girl.class);

		sumin.makeFood();
		jimin.makeFood();
	}
}
