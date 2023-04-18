package aop_ver2_around;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("aop_ver2_around/beans.xml");

		boy sumin = cpx.getBean("sumin", boy.class);
		girl jimin = cpx.getBean("jimin", girl.class);

		sumin.makeFood();
		jimin.makeFood();
	}
}
