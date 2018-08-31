package com.gmail.v.varvaruk89.urltest.controllers;

import com.gmail.v.varvaruk89.urltest.entities.MyHost;
import com.gmail.v.varvaruk89.urltest.entities.MySettings;
import com.gmail.v.varvaruk89.urltest.repo.MySettingsRepository;
import com.gmail.v.varvaruk89.urltest.services.MySettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/settings")
public class SettingsController {

    @Autowired
    MySettingsService mySettingsService;

    @GetMapping
    public String mainPage(Model model) {
      Iterable<MySettings> mySettings = mySettingsService.getAll();
      model.addAttribute("settings",mySettings);
        //return "redirect:/myhost/";
        return "settings";
    }


    @GetMapping(value = "/edit")
    public String editSettingsGetForm(@RequestParam("id") String id, ModelMap modelMap) {
        MySettings mySettings = mySettingsService.getbyId(Long.parseLong(id));
        modelMap.addAttribute("settings", mySettings);
        return "mysettingedit";
    }

    @PostMapping(value = "/edit")
    public String saveEditHost(@Valid @ModelAttribute MySettings mySettings, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("BINDING RESuLT ERROR");
            return "mysettingedit";
        }

        mySettingsService.save(mySettings);

        return "redirect:/settings";
    }


}
