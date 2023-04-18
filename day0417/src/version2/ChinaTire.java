package version2;

import org.springframework.stereotype.Component;

// class BoardDaoOracle
@Component
public class ChinaTire implements Tire {
	@Override
	public String getModel() {
		return "대륙";
	}
}
