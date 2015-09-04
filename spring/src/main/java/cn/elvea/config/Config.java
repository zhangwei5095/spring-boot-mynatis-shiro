package cn.elvea.config;

import cn.elvea.persistence.mybatis.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:application.properties")
@MapperScan(basePackages = "cn.elvea.repository")
public class Config implements TransactionManagementConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(Config.class);

    @Autowired
    Environment env;

    @Autowired
    DataSource dataSource;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return transactionManager();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
        txManager.setDataSource(dataSource);
        return txManager;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
        sf.setDataSource(dataSource);
        sf.setTypeAliasesPackage("cn.elvea.domain");
        sf.setPlugins(getMyBatisPlugins());
        sf.setConfigurationProperties(new Properties());
        return sf.getObject();
    }

    private Interceptor[] getMyBatisPlugins() {
        Interceptor[] interceptors = new Interceptor[1];
        interceptors[0] = new PageInterceptor();
        return interceptors;
    }
}
