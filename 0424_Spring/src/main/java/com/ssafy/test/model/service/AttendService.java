package com.ssafy.test.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.ssafy.test.model.dao.AttendanceDao;
import com.ssafy.test.model.dto.AttendanceDto;


@Component
public class AttendService {
	
	@Autowired
	private AttendanceDao dao;

	public List<AttendanceDto> selectAll() throws SQLException {
		return dao.list();
	}
	
	public void removeAll(String[] ano) throws SQLException {
		for (String an : ano) {
			dao.delete(an);
		}

	}
	
	public AttendanceDto detail(String ano) throws SQLException {
		System.out.println(dao.detail(ano).toString());
		return dao.detail(ano);
	}

	public int regist(AttendanceDto attend) throws SQLException {
		return dao.insert(attend);
	}

}
