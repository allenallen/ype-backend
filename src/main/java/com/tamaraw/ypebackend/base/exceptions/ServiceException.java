package com.tamaraw.ypebackend.base.exceptions;

public class ServiceException extends RuntimeException{
    public ServiceException(String format, String... varargs) {
        super(String.format(format, varargs));
    }
}
