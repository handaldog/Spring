package com.ssafy.board;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.context.annotation.Configuration;


// 예전 root-contex.xml이나 servlet-context.xml 같이 객체관리 해주는 파일 자바버전
@Configuration
@MapperScan("com.ssafy.board.model.dao") // 인터페이스 매퍼 스캔.
public class DBconfig {
	
	
}
