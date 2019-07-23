package com.zyx.controller;

import com.zyx.pojo.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/freemarker")
public class FreeMarkerController {

    @Autowired
    private ConfigBean configBean;
    @GetMapping("/test")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("configBean",configBean);
//        System.out.println("freemarker test");
        return "fm/index";
    }

}
