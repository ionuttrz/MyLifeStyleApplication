package com.ProiectareSoftware.myLifeStyle.commandAndQuery;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class Mediator {
    HashMap<Class<?>, Object> map = new HashMap<>();

    public <T, R> R send(T request) {
        Object req = map.get(request.getClass());
        System.out.println(req);
        if (req == null) {
            throw new RuntimeException("No handler found for the request: " + request.getClass());
        }
        try {
            Method method = req.getClass().getMethod("handle", request.getClass());
            return (R) method.invoke(req, request);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Error handling request: " + request.getClass());
        }
    }

    public <T> void registerHandler(Class<T> requestClass, Object handler) {
        map.put(requestClass, handler);
    }
}
