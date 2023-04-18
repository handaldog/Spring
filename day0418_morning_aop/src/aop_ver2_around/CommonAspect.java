package aop_ver2_around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

// 여러 클래스에 공통적으로 적용시키고자 하는 기술
// @Component
public class CommonAspect {

	public void aaaround(ProceedingJoinPoint joinPoint) {

		// before
		try {
			
			joinPoint.proceed(); // 이게 boy, girl 에 있는 핵심관심사항 수행 시점
			System.out.println(); // after returning
		} catch (Throwable e) {
			// afterthrowing
			System.out.println("양유쌤한테 전화할래"); // after throwing
			e.printStackTrace();

		} finally {
			// after
			System.out.println("설거지를 한다."); // after
		}
	}

}
