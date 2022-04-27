package com.mycom.myboard.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myboard.dto.UserDto;

@Mapper
public interface UserDao {
	public int userRegister(UserDto userDto);
}
