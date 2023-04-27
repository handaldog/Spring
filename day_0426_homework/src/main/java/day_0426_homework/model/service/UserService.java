package day_0426_homework.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import day_0426_homework.model.dao.UserMapper;
import day_0426_homework.model.dto.UserDto;


@Service
public class UserService {

	@Autowired
	private UserMapper um;

	public UserDto login(String userId, String userPw) {
		return um.login(userId, userPw);
	}
}
