package cn.elvea.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = ShiroProperties.SHIRO_PREFIX)
public class ShiroProperties {
    public static final String SHIRO_PREFIX = "shiro";
}
