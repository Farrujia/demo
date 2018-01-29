package com.example.demo.jpa.springdata.exception;


public class NotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private static final String errorMsg = "Entidad no encontrada";
	
	public NotFoundException(String msg)
	{
		super(msg);
	}
	
	public NotFoundException()
	{
		super(errorMsg);
	}
	
	
	
	

}
