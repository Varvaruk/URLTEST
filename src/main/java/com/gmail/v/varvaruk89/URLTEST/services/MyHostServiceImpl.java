package com.gmail.v.varvaruk89.urltest.services;

import com.gmail.v.varvaruk89.urltest.entities.MyHost;
import com.gmail.v.varvaruk89.urltest.repo.MyHostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
@Service
public class MyHostServiceImpl implements  MyHostService {
   @Autowired
   private MyHostRepository myHostRepository;

    @Override
    public Iterable<MyHost> getAll() {

        return  myHostRepository.findAll();
    }

    @Override
    public MyHost getById(String id) {
        return myHostRepository.getOne(Long.parseLong(id));
    }

    @Transactional
    @Override
    public void save(MyHost myHost) {
        myHostRepository.save(myHost);

    }

    @Override
    public Set<MyHost> findByActiveIsTrue() {
        return myHostRepository.findByActiveIsTrue();
    }
}
