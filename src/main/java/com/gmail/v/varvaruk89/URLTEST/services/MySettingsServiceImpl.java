package com.gmail.v.varvaruk89.urltest.services;

import com.gmail.v.varvaruk89.urltest.entities.MySettings;
import com.gmail.v.varvaruk89.urltest.repo.MySettingsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
public class MySettingsServiceImpl implements MySettingsService {


    @Autowired
    MySettingsRepository mySettingsRepository;

    @Override
    public Iterable<MySettings> getAll() {
        return mySettingsRepository.findAll();
    }
    @Transactional
    @Override
    public void save(MySettings mySettings) {
        mySettingsRepository.save(mySettings);
    }

    @Override
    public MySettings getbyId(Long id) {
        return mySettingsRepository.getOne(id);
    }

    @PostConstruct
    void in() {
        MySettings mySettings = new MySettings();
        mySettings.setId((long) 1);
        mySettings.setAcceptableResponseTime(2000);
        mySettings.setExpectedAnswerCode(200);
        mySettings.setExpectedLengthOfAnswer((long) 15000);
        mySettingsRepository.save(mySettings);

    }
}


