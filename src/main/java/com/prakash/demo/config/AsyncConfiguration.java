package com.prakash.demo.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.task.DelegatingSecurityContextAsyncTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfiguration {

    private static final Logger log = LoggerFactory.getLogger(AsyncConfiguration.class);


    @Bean
    ThreadPoolTaskExecutor customTaskExecutor() {
        log.info("Creating custom ThreadPoolTaskExecutor bean");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5); // Min number of threads
        executor.setMaxPoolSize(10); // Max number of threads
        executor.setQueueCapacity(25); // Queue capacity for tasks
        executor.setThreadNamePrefix("customAsyncTask-"); // Prefix for thread names
        executor.initialize();
        return executor;
    }

    @Bean 
    DelegatingSecurityContextAsyncTaskExecutor taskExecutor(ThreadPoolTaskExecutor delegate) { 
        log.info("Creating DelegatingSecurityContextAsyncTaskExecutor bean");
        return new DelegatingSecurityContextAsyncTaskExecutor(delegate); 
    }
}