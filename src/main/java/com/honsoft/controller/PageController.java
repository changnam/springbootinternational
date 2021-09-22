package com.honsoft.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.LocaleResolver;

@Controller
public class PageController {
	private static Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private MessageSourceAccessor messageSourceAccessor;
	
	@Autowired
	private LocaleResolver localeResolver;

    @GetMapping("/international")
    public String getInternationalPage() {
        return "international";
    }
    
    @GetMapping("/")
    public String helloPage(HttpServletRequest request) {


    	logger.info("messageSourceAccessor : {}", messageSourceAccessor.getMessage("hello"));
    	logger.info("messageSourceAccessor with LocaleResolver : {}", messageSourceAccessor.getMessage("hello", localeResolver.resolveLocale(request)));
    	
        return "hello";
    }
    
    @GetMapping("/{name}") // <--- 1
    public String hello(@PathVariable String name, Model model) { // <--- 2
        model.addAttribute("name", name); // <--- 3

        return "hello"; // <--- 4
    }
}