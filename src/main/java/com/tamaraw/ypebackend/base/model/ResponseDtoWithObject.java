package com.tamaraw.ypebackend.base.model;

public class ResponseDtoWithObject extends ResponseDto{

    private Object data;

    public ResponseDtoWithObject(Object data, int code, String message) {
        super(code,message);
        this.data = data;
    }

    public ResponseDtoWithObject(int code, String message) {
        super(code, message);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
