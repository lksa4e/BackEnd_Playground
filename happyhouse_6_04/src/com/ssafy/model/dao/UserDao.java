package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.User;

public interface UserDao {
	boolean register(User user) throws SQLException;       	  // 회원 등록
	User searchByUserId(String userId) throws SQLException;   // ID 기반 검색
	User getUser(String userId, String passWd) throws SQLException; // ID, PW 기반 Name 리턴
	List<User> searchAll() throws SQLException;				  // 전체 회원리스트 조회
	boolean updateUser(User user) throws SQLException; // 전체 항목 기반 업데이트
	boolean deleteUser(String userId) throws SQLException; // ID 기반 회원 삭제
}
