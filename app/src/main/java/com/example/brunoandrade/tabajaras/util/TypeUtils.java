package com.example.brunoandrade.tabajaras.util;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by pablo.couto on 21/07/2017.
 */

public class TypeUtils <T extends Object> {

    public Type getTypeFromClass(T clazz) {
        Type type = new TypeToken<T>() {
        }.getType();
        return type;
    }
}