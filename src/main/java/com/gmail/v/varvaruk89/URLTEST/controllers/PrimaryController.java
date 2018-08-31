package com.gmail.v.varvaruk89.urltest.controllers;

import com.gmail.v.varvaruk89.urltest.services.MyCurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class PrimaryController {




    @GetMapping(value = "/")
    public String mainPage(Model model) {
        //return "redirect:/myhost/";
        return "index";
    }


}
