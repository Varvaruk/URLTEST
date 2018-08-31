package com.gmail.v.varvaruk89.urltest.services;

import com.gmail.v.varvaruk89.urltest.entities.MyResponse;

import java.util.Set;

public interface MyResponseService {
    Iterable<MyResponse> getAll();

    Set<MyResponse> findFirstByContainsWordTrue();

    void save(MyResponse myResponse);


}
