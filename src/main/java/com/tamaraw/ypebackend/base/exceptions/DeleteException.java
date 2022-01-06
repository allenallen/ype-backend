package com.tamaraw.ypebackend.base.exceptions;

public class DeleteException extends RuntimeException{
    public DeleteException(String format, String... varargs) {
        super(String.format(format, varargs));
    }
}
