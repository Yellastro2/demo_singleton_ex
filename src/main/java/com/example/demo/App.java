package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

@Controller
public class App {

    @Autowired
    private ApplicationContext ctx;

    @RequestMapping("/app")
    public String  getApp(Model model) {
        CounterSingleton fCounter = ctx.getBean(CounterSingleton.class);
        int fValue =  fCounter.get();
        model.addAttribute("getValue",fValue);
        return "app_page.html";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String  gettext() {
        return "some test";
    }
}
