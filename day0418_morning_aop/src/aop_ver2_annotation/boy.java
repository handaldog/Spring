package aop_ver2_annotation;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
// 우리가 구현하는 Dao, Service, Controller 등등 어떤 클래스라도 대상이 될 수 있음.
public class boy {

	public String makeFood() throws Exception {
		String result;

		System.out.println("라면을 끓인다."); // 이 클래스가 수행해야 하는 핵심 관심사항(클래스 존재 이유)

		if (new Random().nextBoolean()) { // 잘 구현 했어도 상황에 따라 에러가 발생 할 수 있음.
			throw new Exception("스프를 쏟았다....");
		}
		
		result = "맛있는 라면";

		return result;
	}
}
