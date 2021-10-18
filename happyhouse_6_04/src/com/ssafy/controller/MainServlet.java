package com.ssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.ssafy.model.dto.DataInfo;
import com.ssafy.model.dto.PageInfo;

@WebServlet(urlPatterns = {"*.do"}, loadOnStartup = 1)
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Controller userContoller = new UserContorller();
	private Controller houseDealContoller = new HouseDealController();
	
	@Override
	public void init() throws ServletException {
		ServletContext application = getServletContext();
		application.setAttribute("root", application.getContextPath());
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath(); 
		Object info = null;
		System.out.println("url : " + url);
		
		try {
			if(url.startsWith("/user")) {
				info = userContoller.process(request, response);
			}else if(url.startsWith("/housedeal")) {
				info = houseDealContoller.process(request, response);
			}
			
			// 페이지 이동 수행
			if(info instanceof PageInfo) {
				PageInfo pInfo = (PageInfo)info;
				if(pInfo.isForward()) {
					request.getRequestDispatcher(pInfo.getUrl()).forward(request, response);
					return;
				}else {
					response.sendRedirect(request.getContextPath() + pInfo.getUrl());
					return;
				}
			}
			// 데이터 응답
			else {
				DataInfo dInfo = (DataInfo) info;
				String contentType = dInfo.getContentType();
				response.setContentType(contentType);
				
				if(contentType.startsWith("application/json")) {
					PrintWriter out = response.getWriter();
					Gson gson = new Gson();
					out.println(gson.toJson(dInfo.getData()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
	}
}
