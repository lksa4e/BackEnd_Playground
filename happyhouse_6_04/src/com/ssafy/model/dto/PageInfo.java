package com.ssafy.model.dto;

// 화면을 이동하고 싶은 경우 항상 PageInfo 객체를 만들어서 주도록 구현함
public class PageInfo {
	private String url;
	private boolean isForward;
	
	public PageInfo(String url, boolean isForward) {
		super();
		this.url = url;
		this.isForward = isForward;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isForward() {
		return isForward;
	}
	public void setForward(boolean isForward) {
		this.isForward = isForward;
	}
}
