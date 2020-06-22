package br.com.financa.exceptionhandler;

public class BusinessException extends RuntimeException {

    private static final long serialversionUID = 1L;

    public BusinessException(String message){
        super(message);
    }
}
