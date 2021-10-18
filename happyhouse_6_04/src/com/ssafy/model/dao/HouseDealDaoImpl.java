package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.dto.HouseInfo;
import com.ssafy.model.dto.SidoGugunCode;
import com.ssafy.util.DBUtil;

public class HouseDealDaoImpl implements HouseDealDao {
	
	private DBUtil dbUtil = DBUtil.getInstance();

	@Override
	public List<SidoGugunCode> getSido() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<SidoGugunCode> list = new ArrayList<SidoGugunCode>();
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select left(sidoCode,2) sidoCode, sidoName \n");
			sql.append("from sidocode \n");
			sql.append("order by sidoCode");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SidoGugunCode dto = new SidoGugunCode();
				dto.setSidoCode(rs.getString("sidoCode"));
				dto.setSidoName(rs.getString("sidoName"));
				list.add(dto);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public List<SidoGugunCode> getGugunInSido(String sido) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<SidoGugunCode> list = new ArrayList<SidoGugunCode>();
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select left(gugunCode,5) gugunCode, gugunName \n");
			sql.append("from guguncode \n");
			sql.append("where left(gugunCode,2) = ?");
			sql.append("order by gugunCode");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, sido);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SidoGugunCode dto = new SidoGugunCode();
				dto.setGugunCode(rs.getString("gugunCode"));
				dto.setGugunName(rs.getString("gugunName"));
				list.add(dto);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public List<HouseInfo> getDongInGugun(String gugun) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HouseInfo> list = new ArrayList<HouseInfo>();
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select distinct dongName, dongCode \n");
			sql.append("from houseinfo \n");
			sql.append("where left(dongCode, 5) = ? \n");
			sql.append("order by dongName");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, gugun);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HouseInfo dto = new HouseInfo();
				dto.setDongCode(rs.getString("dongCode"));
				dto.setDongName(rs.getString("dongName"));
				list.add(dto);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		System.out.println(list.size());
		return list;
	}

	@Override
	public List<HouseInfo> getAptInDong(String dong) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HouseInfo> list = new ArrayList<HouseInfo>();
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select hi.aptCode, hi.aptName, hi.dongCode, hi.dongName, hi.jibun, "
					+ "hd.no, hd.dealAmount, hd.dealYear, hd.dealMonth, hd.dealDay, hd.area, hd.floor  \n");
			sql.append("from houseinfo hi, housedeal hd \n");
			sql.append("where hi.aptCode = hd.aptCode and dongCode = ? \n");
			sql.append("order by hd.dealYear, hd.dealMonth, hd.dealDay limit 10");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HouseInfo dto = new HouseInfo();
				dto.setAptCode(rs.getInt("aptCode"));
				dto.setAptName(rs.getString("aptName"));
				dto.setDongCode(rs.getString("dongCode"));
				dto.setDongName(rs.getString("dongName"));
				dto.setJibun(rs.getString("jibun"));
				
				dto.setNo(rs.getString("no"));
				dto.setDealAmount(rs.getString("dealAmount"));
				dto.setDealYear(rs.getString("dealYear"));
				dto.setDealMonth(rs.getString("dealMonth"));
				dto.setDealDay(rs.getString("dealDay"));
				dto.setArea(rs.getString("area"));
				dto.setFloor(rs.getString("floor"));
				
				list.add(dto);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		System.out.println(list.size());
		return list;
	}

}
