package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.User;
import com.ssafy.model.dto.User;

public interface UserService {

	boolean register(User user) throws SQLException;
	
	boolean update(User user) throws SQLException;
	
	boolean delete(String userId) throws SQLException;

	User login(String userId, String password) throws SQLException;

}