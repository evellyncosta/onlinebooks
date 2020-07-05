package com.agriness.onlinebooks.exception;


import java.util.ArrayList;
import java.util.List;

public class BusinessException extends Exception{
	
	private List<String> messages;
	
	public BusinessException() {
		super();
		messages = new ArrayList<>();
	}
	
	public BusinessException(String message) {
		super(message);
		messages = new ArrayList<>();
		messages.add(message);
	}

	public List<String> getmessages() {
		return messages;
	}

	public void addmessage(String message) {
		this.messages.add(message);
	}
	
	

}
