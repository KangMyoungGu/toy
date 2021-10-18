package com.example.toy.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

@Configuration
public class WebConfig implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        registerCharacterEncodingFilter(servletContext);
        registerDispatcherServlet(servletContext);
    }

    private void registerCharacterEncodingFilter(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(ApplicationContext.class);

        servletContext.addListener(new ContextLoaderListener(context));

        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(WebConfig.class);

        ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(webContext));
        dispatcherServlet.setLoadOnStartup(1);
        dispatcherServlet.addMapping("/*");
    }

    private void registerDispatcherServlet(ServletContext servletContext) {
        FilterRegistration.Dynamic dispatcherServlet =servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());

        dispatcherServlet.setInitParameter("encoding", "UTF-8");
        dispatcherServlet.setInitParameter("forceEncoding", "true");
        dispatcherServlet.addMappingForServletNames(EnumSet.allOf(DispatcherType.class),true,"/*");
    }
}
