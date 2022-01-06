package com.tamaraw.ypebackend.base.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String format, String... varargs) {
        super(String.format(format, varargs));
    }
}
