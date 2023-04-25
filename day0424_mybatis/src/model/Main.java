package model;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		BoardMapper bm = ctx.getBean("boardMapper", BoardMapper.class);
		List<BoardDto> list = bm.selectAll();
		System.out.println(list);
		for (BoardDto BoardDto : list) {
			System.out.println(BoardDto);
		}
	}

}
