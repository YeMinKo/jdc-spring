package com.example.springmvcscopeddemo.controller;

import com.example.springmvcscopeddemo.beans.ApplicationScopeBean;
import com.example.springmvcscopeddemo.beans.RequestScopeBean;
import com.example.springmvcscopeddemo.beans.SessionScopeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private RequestScopeBean requestScopeBean;
    @Autowired
    private SessionScopeBean sessionScopeBean;
    @Autowired
    private ApplicationScopeBean applicationScopeBean;

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model, HttpServletRequest request) {
        model.addAttribute("servletContext",webApplicationContext.getServletContext());
        model.addAttribute("requestScopeValue", requestScopeBean.getValue());
        model.addAttribute("sessionScopeValue", sessionScopeBean.getValue());
        model.addAttribute("applicationScopedValue", applicationScopeBean.getValue());
        return "index";
    }

    @PostMapping("/saveRequestScopeValue")
    public String saveRequestScopedValue(@RequestParam("requestScopeValue") int requestScopeValue) {
        requestScopeBean.setValue(requestScopeValue);
        return "forward:/";
    }

    @PostMapping("/saveSessionScopeValue")
    public String saveSessionScopedValue(@RequestParam("sessionScopeValue") int sessionScopeValue) {
        sessionScopeBean.setValue(sessionScopeValue);
        return "forward:/";
    }

    @PostMapping("/saveApplicatonScopeValue")
    public String saveApplicationScopeValue(@RequestParam("applicationScopeValue") int applicationScopeValue) {
        applicationScopeBean.setValue(applicationScopeValue);
        return "forward:/";
    }
}
