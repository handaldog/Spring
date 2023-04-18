package aop_version1;

import java.util.Random;

import org.springframework.stereotype.Component;

//@Component
// Boy가 상품관련이면  girl은 회원관련 등의 기능이 구현되어있음.
public class girl {

	public String makeFood() throws Exception {
		String result;

		System.out.println("햄버거를 조합하자."); // 이 클래스가 수행해야 하는 핵심 관심사항(클래스 존재 이유)

		if (new Random().nextBoolean()) { // 잘 구현 했어도 상황에 따라 에러가 발생 할 수 있음.
			throw new Exception("유이가 빵을 훔쳐먹었다...");
		}

		result = "새우향버거";

		return result;
	}
}
