package com.gmail.v.varvaruk89.urltest.controllers;

import com.gmail.v.varvaruk89.urltest.entities.MyHost;
import com.gmail.v.varvaruk89.urltest.entities.MyResponse;
import com.gmail.v.varvaruk89.urltest.entities.MySettings;
import com.gmail.v.varvaruk89.urltest.services.MyResponseService;
import com.gmail.v.varvaruk89.urltest.services.MySettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/response")
public class MyResponseController {

    @Autowired
    MyResponseService myResponseService;

    @Autowired
    MySettingsService mySettingsService;

    @GetMapping(value = "/all")
    public String getAll(Model model) {
        Iterable<MyResponse> myResponses = myResponseService.getAll();
        model.addAttribute("myresponses", myResponses);
        MySettings mySettings = mySettingsService.getbyId((long)1);
        model.addAttribute("mysettings",mySettings);
        return "myresponses";
    }
}
