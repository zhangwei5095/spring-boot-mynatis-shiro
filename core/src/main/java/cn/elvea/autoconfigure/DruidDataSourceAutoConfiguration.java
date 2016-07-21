package cn.elvea.autoconfigure;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ConditionalOnClass({DruidDataSource.class})
@ConditionalOnMissingBean(DataSource.class)
@EnableConfigurationProperties(DruidDataSourceProperties.class)
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class DruidDataSourceAutoConfiguration {
    private static Logger logger = LoggerFactory.getLogger(DruidDataSourceAutoConfiguration.class);

    @Autowired
    private DruidDataSourceProperties properties;

    @Autowired(required = false)
    private Filter[] filters;

    @Bean
    @ConfigurationProperties(prefix = DataSourceProperties.PREFIX)
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }
}
