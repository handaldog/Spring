package day_0426_homework.model.dao;

import org.apache.ibatis.annotations.Mapper;

import day_0426_homework.model.dto.UserDto;

@Mapper
public interface UserMapper {

	public UserDto login(String userId, String userPw);
}
