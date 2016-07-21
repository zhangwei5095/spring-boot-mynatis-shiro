package cn.elvea.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = DruidDataSourceProperties.DRUID_PREFIX)
public class DruidDataSourceProperties {
    public static final String DRUID_PREFIX = "druid";
}
