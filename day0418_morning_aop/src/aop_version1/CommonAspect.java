package aop_version1;



// 여러 클래스에 공통적으로 적용시키고자 하는 기술
//@Component
public class CommonAspect {
	public void bbefore() { // 핵심관심사항(point-cut)을 실행시키기 직전 시점

		System.out.println("배가 많이 고프다. 오늘 급식이 진짜 별로임.");
	}

	public void aaafter() {
		System.out.println("설거리를 한다."); // 예외발생 여부와 상관없이 실행되는 것. finally 개념.

	}

	public void aaafterReturning() {
		System.out.println("냠냠 맛있게 먹어야지!!");
	}

	public void aaafterThrowing() {
		System.out.println("유진쌤한테 울면서 전화할거야..ㅠ");
	}
	
	
}
