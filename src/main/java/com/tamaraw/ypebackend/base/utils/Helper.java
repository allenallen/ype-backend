package com.tamaraw.ypebackend.base.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class Helper {

    @Autowired
    private MessageSource messageSource;

    public String getI18Nmessage(String id, String... arguments) {
        return this.messageSource.getMessage(id, arguments, Locale.getDefault());
    }

}
