package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dao.HouseDealDao;
import com.ssafy.model.dao.HouseDealDaoImpl;
import com.ssafy.model.dto.HouseInfo;
import com.ssafy.model.dto.SidoGugunCode;

public class HouseDealServiceImpl implements HouseDealService {
	
	HouseDealDao houseDealDao = new HouseDealDaoImpl();
	
	@Override
	public List<SidoGugunCode> getSido() throws Exception {
		return houseDealDao.getSido();
	}

	@Override
	public List<SidoGugunCode> getGugunInSido(String sido) throws Exception {
		return houseDealDao.getGugunInSido(sido);
	}

	@Override
	public List<HouseInfo> getDongInGugun(String gugun) throws Exception {
		return houseDealDao.getDongInGugun(gugun);
	}

	@Override
	public List<HouseInfo> getAptInDong(String dong) throws Exception {
		return houseDealDao.getAptInDong(dong);
	}

}
