package com.gmail.v.varvaruk89.urltest.services;

import com.gmail.v.varvaruk89.urltest.entities.MySettings;


public interface MySettingsService {



    Iterable<MySettings> getAll();

    void save(MySettings mySettings);

    MySettings getbyId(Long id);


}
