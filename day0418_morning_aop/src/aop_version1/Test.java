package aop_version1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("aop_version1/beans.xml");

		boy sumin = cpx.getBean("sumin", boy.class);
		girl jimin = cpx.getBean("gimin", girl.class);

		sumin.makeFood();
		jimin.makeFood();
	}
}
