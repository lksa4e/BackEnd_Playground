package com.ssafy.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.dto.DataInfo;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.dto.User;
import com.ssafy.model.service.UserService;
import com.ssafy.model.service.UserServiceImpl;

public class UserContorller implements Controller{
	private UserService userService = new UserServiceImpl();
	
	@Override
	public Object process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String subUrl = request.getServletPath().substring(5); // user/login 에서 user 뒤에 있는거만 가져옴
		if(subUrl.equals("/login.do")) {
			return login(request, response);
		}else if(subUrl.equals("/logout.do")) {
			return logout(request, response);
		}else if(subUrl.equals("/register.do")) {
			return register(request, response);
		}else if(subUrl.equals("/loginCheck.do")) {
			return logincheck(request, response);
		}else if(subUrl.equals("/update.do")) {
			return update(request, response);
		}else if(subUrl.equals("/delete.do")) {
			return delete(request, response);
		}
		return null;
	}
	
	protected DataInfo register(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("userpw");
		String name = request.getParameter("username");
		String useraddress = request.getParameter("useraddress");
		String uesrphone = request.getParameter("userphone");
		
		boolean flag = userService.register(new User(userId, password, name, useraddress, uesrphone));
		
		if(flag) {
			// 로그인 화면으로 이동
			return new DataInfo("application/json;charset=utf-8", 0);
		}
		
		request.setAttribute("errorMessage", "아이디를 가진 회원이 이미 존재합니다.");
		return new DataInfo("application/json;charset=utf-8", -1);
	}
	
	
	protected DataInfo logincheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("userInfo") != null) {
			return new DataInfo("application/json;charset=utf-8", session.getAttribute("userInfo"));
		}
		return new DataInfo("application/json;charset=utf-8", null);
	}
	
	
	
	protected DataInfo login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String password = request.getParameter("userpw");
		
		ArrayList<String> errorMessages = new ArrayList<String>();
		if(userId == null || userId.trim().length() == 0) {
			errorMessages.add("아이디가 올바르지 않습니다.");
		}
		if(password == null || password.trim().length() == 0) {
			errorMessages.add("비밀번호가 올바르지 않습니다.");
		}
		
		if(errorMessages.size() > 0) {
//			request.setAttribute("errorMessages", errorMessages);
			return new DataInfo("application/json;charset=utf-8", errorMessages);
		}
		
		User user = userService.login(userId, password);
		if(user != null) {
			HttpSession session = request.getSession();
			if(session.getAttribute("userInfo") != null) {
				session.removeAttribute("userInfo");
			}
			session.setAttribute("userInfo", user);
			session.setMaxInactiveInterval(30);
			return new DataInfo("application/json;charset=utf-8", user);
		}
		
		errorMessages.add("아이디 또는 비밀번호가 일치하지 않습니다.");
		request.setAttribute("errorMessages", errorMessages);
		return new DataInfo("/login.jsp", -1);
	}
	
	protected DataInfo update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String password = request.getParameter("userpw");
		String name = request.getParameter("username");
		String useraddress = request.getParameter("useraddress");
		String userphone = request.getParameter("userphone");
		
		boolean flag = userService.update(new User(userId, password, name, useraddress, userphone));
		
		if(flag) {
			HttpSession session = request.getSession();
			if(session.getAttribute("userInfo") != null) {
				session.removeAttribute("userInfo");
			}
			session.setAttribute("userInfo", new User(userId, password, name, useraddress, userphone));
			session.setMaxInactiveInterval(30);
			return new DataInfo("application/json;charset=utf-8", 0);
		}
		return new DataInfo("application/json;charset=utf-8", -1);
	}
	
	protected DataInfo delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userId = request.getParameter("userId");
		
		boolean flag = userService.delete(userId);
		
		if(flag) {
			request.getSession().invalidate();
			return new DataInfo("application/json;charset=utf-8", 0);
		}
		return new DataInfo("application/json;charset=utf-8", -1);
	}
	
	protected DataInfo logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().invalidate();
		return new DataInfo("application/json;charset=utf-8" , 0);
	}
}
