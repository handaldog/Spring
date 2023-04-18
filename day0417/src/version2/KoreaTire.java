package version2;

import org.springframework.stereotype.Component;

// class BoardDaoMysql

@Component // 이름안붙이면 자동으로   koreatire

public class KoreaTire implements Tire {
	@Override
	public String getModel() {
		return "국산"; // 실제 sql 실행 구현부
	}
}

// componenet, autowire, qualifier