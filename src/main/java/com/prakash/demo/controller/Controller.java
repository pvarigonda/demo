package com.prakash.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prakash.demo.service.AsyncService;

@RestController
public class Controller {

    private static final Logger log = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/async")
    @ResponseBody
    public Object getMethodName() {
        log.info("Before the async call: "
                + SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        asyncService.executeAsyncTask();

        log.info("After the async call: "
                + SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}