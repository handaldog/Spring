package wsmodel2;

import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TomcatTest {
public static void main(String[] args) throws SQLException {
	// 여기가 들어갈 수 있도록 실습하세요
	// ws1 : xml 태그로 객체 등록해서 실행시키기
	// ws2 : annotation을 스캔해서 실행시키기
	
	ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("wsmodel2/beans.xml");
	
	BoardService service = (BoardService) cxt.getBean("boardService");
	
	for(BoardDto dto : service.getBoards()) {
		System.out.println(dto);
	}
}
}
