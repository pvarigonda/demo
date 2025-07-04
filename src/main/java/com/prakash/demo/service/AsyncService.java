package com.prakash.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    private static final Logger log = LoggerFactory.getLogger(AsyncService.class);

    @Async
    public void executeAsyncTask() {
         log.info(">>>>>> Inside the @Async task: >>>>>>>> "
      + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
