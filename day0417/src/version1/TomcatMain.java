package version1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TomcatMain {
	
	// 내일 모레부터는 실제로 톰캣 돌리겠지만 오늘은 없으니깐 그냥 테스트용 메인
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("version1/beans.xml");
		
		Car sonata = ctx.getBean("sonata", Car.class);
//		Tire tire = ctx.getBean("kkk", Tire.class);
		
//		sonata.setTire(tire);
		sonata.run();
		
	}
	
	// 빈, 프로퍼티 태그
}
