package com.ssafy.model.service;

import java.sql.SQLException;

import com.ssafy.model.dao.UserDao;
import com.ssafy.model.dao.UserDaoImpl;
import com.ssafy.model.dto.User;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao = UserDaoImpl.getUserInfoDao();
	
	@Override
	public boolean register(User user) throws SQLException {
		if(userDao.searchByUserId(user.getUserId()) != null) return false;
		return userDao.register(user);
	}
	
	@Override
	public User login(String userId, String password) throws SQLException {
		// 회원정보 확인 후 인증
		return userDao.getUser(userId, password);
	}
	
	@Override
	public boolean update(User user) throws SQLException {
		// 회원정보 확인 후 인증
		return userDao.updateUser(user);
	}

	@Override
	public boolean delete(String userId) throws SQLException {
		return userDao.deleteUser(userId);
	}
}
