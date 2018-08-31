package com.gmail.v.varvaruk89.urltest.services;

import com.gmail.v.varvaruk89.urltest.entities.MyResponse;
import com.gmail.v.varvaruk89.urltest.repo.MyResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
@Service
public class MyResponseServiceImpl implements MyResponseService {
    @Autowired
    MyResponseRepository myResponseRepository;

    @Override
    public Iterable<MyResponse> getAll() {
        return myResponseRepository.findAll();
    }

    @Override
    public Set<MyResponse> findFirstByContainsWordTrue() {
        return myResponseRepository.findFirstByContainsWordTrue();
    }
    @Transactional
    @Override
    public void save(MyResponse myResponse) {
        myResponseRepository.save(myResponse);
    }
}
