package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.HouseInfo;
import com.ssafy.model.dto.SidoGugunCode;

public interface HouseDealService {
	List<SidoGugunCode> getSido() throws Exception;
	List<SidoGugunCode> getGugunInSido(String sido) throws Exception;
	List<HouseInfo> getDongInGugun(String gugun) throws Exception;
	List<HouseInfo> getAptInDong(String dong) throws Exception;
}
