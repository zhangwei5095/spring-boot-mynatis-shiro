package cn.elvea.autoconfigure;

import cn.elvea.config.CacheConfig;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

public class ShiroConfiguration {
    @Bean(name = "lifecycleBeanPostProcessor")
    @ConditionalOnMissingBean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean(name = "defaultAdvisorAutoProxyCreator")
    @ConditionalOnMissingBean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean(name = "shiroCacheManager")
    @ConditionalOnMissingBean
    public CacheManager cacheManager() {
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManager(CacheConfig.ehCacheManagerFactoryBean().getObject());
        return cacheManager;
    }

    @Bean(name = "securityManager")
    @ConditionalOnMissingBean
    public DefaultSecurityManager securityManager(CacheManager shiroCacheManager) {
        DefaultSecurityManager sm = new DefaultWebSecurityManager();
        sm.setCacheManager(shiroCacheManager);
        return sm;
    }

    @Bean
    @ConditionalOnMissingBean
    public RememberMeManager rememberMeManager() {
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        simpleCookie.setHttpOnly(true);
        simpleCookie.setMaxAge(2592000);

        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        rememberMeManager.setCookie(simpleCookie);
        return rememberMeManager;
    }
}
