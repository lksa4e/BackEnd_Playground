package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.util.*;
import com.ssafy.model.dto.User;

public class UserDaoImpl implements UserDao{

	private static UserDao userInfoDao;
	private DBUtil dbUtil = DBUtil.getInstance();
	
	private UserDaoImpl() {}

	public static UserDao getUserInfoDao() {
		if (userInfoDao == null)
			userInfoDao = new UserDaoImpl();
		return userInfoDao;
	}
	
	@Override
	public boolean register(User user) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into userinfo (id, pw, username, address, tel) values (?, ?, ?, ?, ?)";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPw());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserAddress());
			pstmt.setString(5, user.getUserTel());
			return pstmt.executeUpdate() > 0;
			
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

	// user 아이디로 회원정보 조회 
	@Override
	public User searchByUserId(String userId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select id, pw, username, address, tel from userinfo where id = ?";

		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		} finally {
			dbUtil.close(conn, pstmt, rs);
		}
		return null;
	}

	// 모든 user 정보 조회 
	@Override
	public List<User> searchAll() throws SQLException {
		List<User> userList = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			String sql = "select id, pw, username, address, tel from userinfo";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			userList = new ArrayList<User>();
			while (rs.next()) {
				userList.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} finally {
			dbUtil.close(conn, pstmt, rs);
		}
		return userList;
	}

	@Override
	public boolean updateUser(User user) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update userinfo set pw = ?, username = ?, address = ?, tel = ? where id = ?";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserPw());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getUserAddress());
			pstmt.setString(4, user.getUserTel());
			pstmt.setString(5, user.getUserId());

			return pstmt.executeUpdate() > 0;
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

	@Override
	public boolean deleteUser(String userId) throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from userinfo where id = ?";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			return pstmt.executeUpdate() > 0;
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

	@Override
	public User getUser(String userId, String userPw) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select id, pw, username, address, tel from userinfo where id = ? and pw = ?";
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
		} finally {
			dbUtil.close(conn, pstmt, rs);
		}
		return null;
	}

}
