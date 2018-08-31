package com.gmail.v.varvaruk89.urltest.controllers;

import com.gmail.v.varvaruk89.urltest.entities.MyHost;
import com.gmail.v.varvaruk89.urltest.services.MyHostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/myhost")
public class MyHostController {

    @Autowired
    MyHostService myHostService;


    @GetMapping(value = "/all")
    public String getAll(Model model) {
        Iterable<MyHost> myHosts = myHostService.getAll();
        model.addAttribute("myHost", myHosts);
        return "myhostall";
    }

    @GetMapping(value = "/add")
    public String getFormAdd(Model model) {
        MyHost myHost = new MyHost();
        model.addAttribute("myHost", myHost);
        return "myhost";
    }

    @PostMapping(value = "/add")
    public String addHost(@ModelAttribute @Valid MyHost myHost, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("BINDING RESuLT ERROR");
            return "myhost";
        }
        myHostService.save(myHost);
        return "redirect:/myhost/all";
    }


    @GetMapping(value = "/edit")
    public String editHostGetForm(@RequestParam("id") String id, ModelMap modelMap) {
        MyHost myHost = myHostService.getById(id);
        modelMap.addAttribute("myHost", myHost);
        return "myhostedit";
    }

    @PostMapping(value = "/edit")
    public String saveEditHost(@Valid @ModelAttribute MyHost myHost,  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("BINDING RESuLT ERROR");
            return "myhost";
        }

        myHostService.save(myHost);

        return "redirect:/myhost/all";
    }

}
