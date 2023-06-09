package version2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// BoardService -> Dao 의존하는 클래스.

@Component ("sonata") // bean 태그 역할을 하는 어노테이션이다.

public class Car {
	@Autowired("sonata") // 아래  tire 타입에 올 수 있는 객체가 있는지 스프링이 탐색한다음 끌고옴.
	private Tire tire;
	private String color;
//	public Car(Tire tire) {
//		this.tire = tire;
//	}
	
	public void setTire(Tire tire) {
		this.tire = tire;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void run() {
		System.out.println("차량 주행중(서비스 객체 일하는 중 with Tire)");
		System.out.println("장착 타이어 정보 : "+tire.getModel()+"/"+this.color);
	}
	
	public void aaa() {
		System.out.println("드라이브 가자 유후~");
	}
	
	public void bbb() {
		System.out.println("집에가자 피곤하다..");
	}
}
