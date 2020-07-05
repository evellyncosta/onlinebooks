package com.agriness.onlinebooks.dto;

import java.time.LocalDate;
import java.util.List;

public class ErrorMessageDTO {
	 private List<String> messages;

	    private LocalDate dataErro;

	    public List<String> getMensagens() {
	        return messages;
	    }

	    public void setMensagens(List<String> messages) {
	        this.messages = messages;
	    }

	    public LocalDate getDataErro() {
	        return dataErro;
	    }

	    public void setDataErro(LocalDate dataErro) {
	        this.dataErro = dataErro;
	    }

	    public static ErrorMessageDTO build(List<String> message){

	    	ErrorMessageDTO errorMessage = new ErrorMessageDTO();
	    	errorMessage.setMensagens(message);
	    	errorMessage.setDataErro(LocalDate.now());

	        return errorMessage;

	    }

}
