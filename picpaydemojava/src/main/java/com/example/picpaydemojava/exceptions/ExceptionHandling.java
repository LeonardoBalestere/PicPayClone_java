package com.example.picpaydemojava.exceptions;

public class ExceptionHandling extends RuntimeException {

	private static final long serialVersionUID = -7507642233804283142L;

	public ExceptionHandling(String mensagem) {
		super(mensagem);
	}

	public ExceptionHandling(String mensagem, Exception exception) {
		super(mensagem, exception);
	}

	
}
