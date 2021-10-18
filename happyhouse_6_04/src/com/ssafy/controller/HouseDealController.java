package com.ssafy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.dto.DataInfo;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.dto.SidoGugunCode;
import com.ssafy.model.service.HouseDealService;
import com.ssafy.model.service.HouseDealServiceImpl;

public class HouseDealController implements Controller {
	
	HouseDealService houseDealService = new HouseDealServiceImpl();
	
	@Override
	public Object process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String subUrl = request.getServletPath().substring(10, request.getServletPath().lastIndexOf(".do"));
		
		if(subUrl.equals("/sido")) {
			return getSido(request, response);
		}else if(subUrl.equals("/gugun")) {
			return getGugunInSido(request, response);
		}else if(subUrl.equals("/dong")) {
			return getDongInGugun(request, response);
		}else if(subUrl.equals("/dealinfo")) {
			return getDealInfo(request, response);
		}else if(subUrl.equals("/search")) {
			return searchDealInfo(request, response);
		}
			
		return null;
	}


	private Object searchDealInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String dong = request.getParameter("dong");
		request.setAttribute("dong", dong);
		HttpSession session = request.getSession();
		session.setAttribute("dong", dong);
		return new PageInfo("/portfolio_details.jsp", false);
	}


	private Object getDealInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String dong = request.getParameter("dong");
		HttpSession session = request.getSession();
		if(session.getAttribute("dong")!=null) {
			dong = (String) session.getAttribute("dong");
			session.removeAttribute("dong");
		}
		return new DataInfo("application/json;charset=utf-8", houseDealService.getAptInDong(dong));
	}

	private Object getDongInGugun(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String gugun = request.getParameter("gugun");
		return new DataInfo("application/json;charset=utf-8", houseDealService.getDongInGugun(gugun));
	}

	private Object getGugunInSido(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sido = request.getParameter("sido");
		return new DataInfo("application/json;charset=utf-8", houseDealService.getGugunInSido(sido));
	}

	private Object getSido(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new DataInfo("application/json;charset=utf-8", houseDealService.getSido());
	}

}
