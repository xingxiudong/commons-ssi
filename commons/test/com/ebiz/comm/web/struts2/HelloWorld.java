package com.ebiz.comm.web.struts2;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorld extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String message;

	public String getMessage() {
		return message;
	}

	public String execute() {
		if (System.currentTimeMillis() % 2 == 0) {
			message = "It's 0";
			return "zero";
		}

		message = "It's 1";

		return SUCCESS;
	}
	
	public String index() {
		if (System.currentTimeMillis() % 2 == 0) {
			message = "It's 0";
			return "zero";
		}
		
		message = "It's 1";
		
		return SUCCESS;
	}

}