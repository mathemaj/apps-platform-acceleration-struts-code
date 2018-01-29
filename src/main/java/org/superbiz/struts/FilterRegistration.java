package org.superbiz.struts;

import com.opensymphony.module.sitemesh.filter.PageFilter;
import org.apache.struts2.dispatcher.ActionContextCleanUp;
import org.apache.struts2.dispatcher.FilterDispatcher;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;


@Configuration
public class FilterRegistration {

    @Bean
    public FilterRegistrationBean filterDispatcher() {
        FilterRegistrationBean frb = buildFilter("struts2", new FilterDispatcher(), 0);
        frb.addInitParameter("actionPackages", "com.lq");
        return frb;
    }

    @Bean
    public FilterRegistrationBean actionContextCleanUp() {
       return buildFilter("struts-cleanup", new ActionContextCleanUp(), 1);

    }

    @Bean
    public FilterRegistrationBean pageFilter() {
        return buildFilter("sitemesh", new PageFilter(), 2);

    }



    private FilterRegistrationBean buildFilter(String name, Filter filter, int order){
        FilterRegistrationBean frb = new FilterRegistrationBean();

        frb.setName(name);
        frb.setFilter(filter);
        frb.setOrder(order);
        frb.addUrlPatterns("/*");
        return frb;
    }
}
