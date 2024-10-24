package com.ProiectareSoftware.myLifeStyle.commandAndQuery;


import java.util.List;

public interface RequestHandler<T extends IRequest<R>, R> {

    R handle(T request) throws IllegalAccessException;
}
