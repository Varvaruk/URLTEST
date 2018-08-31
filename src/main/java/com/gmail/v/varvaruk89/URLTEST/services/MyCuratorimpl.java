package com.gmail.v.varvaruk89.urltest.services;

import com.gmail.v.varvaruk89.urltest.entities.MyHost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class MyCuratorimpl implements MyCurator {

    @Autowired
    MySettingsService mySettingsService;

    @Autowired
    MyResponseService myResponseService;

    @Autowired
    MyListener myListener;

    @Autowired
    MyHostService myHostService;


    @Override

    @Scheduled(fixedRate = 140000)
    public void runCurator() {
        if (!(myHostService.findByActiveIsTrue().isEmpty())) {
            for (MyHost myHost : myHostService.findByActiveIsTrue()) {
                try {
                    myResponseService.save(myListener.listen(myHost));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
