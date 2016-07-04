package cn.elvea.config;

import cn.elvea.commons.web.mvc.WebArgumentResolver;
import cn.elvea.commons.web.servlet.CaptchaServlet;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
        registry.addResourceHandler("/favicon.ico").addResourceLocations("/static/favicon.ico");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new WebArgumentResolver());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LocaleChangeInterceptor());
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new SessionLocaleResolver();
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean(name = "sitemeshFilter")
    public FilterRegistrationBean sitemeshFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new ConfigurableSiteMeshFilter());
        bean.addUrlPatterns("/*");
        bean.addInitParameter("configFile", "/WEB-INF/config/sitemesh/sitemesh.xml");
        return bean;
    }

    @Bean(name = "captchaServlet")
    public ServletRegistrationBean captchaServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean();
        bean.setServlet(new CaptchaServlet());
        bean.addUrlMappings("/captcha");
        return bean;
    }
}
