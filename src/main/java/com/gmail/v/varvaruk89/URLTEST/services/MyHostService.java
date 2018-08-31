package com.gmail.v.varvaruk89.urltest.services;

import com.gmail.v.varvaruk89.urltest.entities.MyHost;

import java.util.Set;

public interface MyHostService {

    Iterable<MyHost> getAll();

    MyHost getById(String id);

    void save(MyHost myHost);

    Set<MyHost> findByActiveIsTrue();
}
