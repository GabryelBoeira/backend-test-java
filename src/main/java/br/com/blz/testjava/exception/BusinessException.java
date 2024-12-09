package br.com.blz.testjava.exception;

public class BusinessException extends ArrayStoreException {

    public BusinessException(String message) {
        super(message);
    }
}
