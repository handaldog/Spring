package version2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TomcatMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext("version2/beans.xml");
		
		Car sonata = ctx.getBean("sonata", Car.class);
		Tire tire = ctx.getBean("koreaTire", Tire.class);
		
		sonata.setTire(tire);
		sonata.run();

	}

}
