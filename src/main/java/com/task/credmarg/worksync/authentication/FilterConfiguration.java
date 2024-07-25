package com.task.credmarg.worksync.authentication;

import com.task.credmarg.worksync.authentication.user.DefaultUserManagementService;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilterConfiguration {

    /*
    @Bean
    FilterRegistrationBean<RequestFilter> requestFilter(){
        FilterRegistrationBean<RequestFilter> requestFilterBean = new FilterRegistrationBean<>();
        requestFilterBean.setFilter(new RequestFilter(new DefaultUserManagementService()));
        requestFilterBean.setUrlPatterns(List.of("/"));
        return requestFilterBean;
    }
     */
}
