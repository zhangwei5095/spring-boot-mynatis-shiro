package cn.elvea.config;

import cn.elvea.ApplicationInitializer;
import cn.elvea.core.persistence.datasource.DynamicDataSource;
import cn.elvea.core.persistence.repository.BaseRepositoryImpl;
import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Maps;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = {"cn.elvea.repository"}, repositoryBaseClass = BaseRepositoryImpl.class)
public class Config implements TransactionManagementConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(Config.class);

    public final static String DATASOURCE_MASTER = "master";
    public final static String DATASOURCE_SLAVE = "slave";

    public final static String DATASOURCE_MASTER_PREFIX = "datasource.master";
    public final static String DATASOURCE_SLAVE_PREFIX = "datasource.slave";

    // 默认数据源最大连接数
    public final static int DEFAULT_DATASOURCE_MAX_ACTIVE = 100;
    // 默认数据源初始连接数
    public final static int DEFAULT_DATASOURCE_MIN_IDLE = 10;

    @Autowired
    Environment env;

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages/messages");
        messageSource.setDefaultEncoding(ApplicationInitializer.ENCODING);
        return messageSource;
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return transactionManager();
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setDataSource(dataSource());
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        String persistenceUnitName = env.getProperty("hibennate.persistence-unit-name");
        String dialect = env.getProperty("hibernate.dialect", "");
        boolean showSQL = env.getProperty("hibernate.show-sql", Boolean.class, false);

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(showSQL);
        vendorAdapter.setDatabasePlatform(dialect);

        HibernatePersistenceProvider provider = new HibernatePersistenceProvider();

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", dialect);
        properties.setProperty("hibernate.show_sql", String.valueOf(showSQL));

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.sunlearning.domain");
        factory.setDataSource(dataSource());
        factory.setJpaProperties(properties);
        factory.setPersistenceUnitName(persistenceUnitName);
        factory.setPersistenceProvider(provider);
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    // 数据源配置
    @Bean
    public DataSource dataSource() {
        boolean useMasterSlave = env.getProperty("datasource.master-slave.enable", Boolean.class, false);

        if (useMasterSlave) {
            DataSource masterDataSource = createDataSource(DATASOURCE_MASTER_PREFIX);
            DataSource slaveDataSource = createDataSource(DATASOURCE_SLAVE_PREFIX);
            Map<Object, Object> targetDataSources = Maps.newHashMap();
            targetDataSources.put(DATASOURCE_MASTER, masterDataSource);
            targetDataSources.put(DATASOURCE_SLAVE, slaveDataSource);

            DynamicDataSource dynamicDataSource = new DynamicDataSource();
            dynamicDataSource.setTargetDataSources(targetDataSources);
            dynamicDataSource.setDefaultTargetDataSource(masterDataSource);
            return dynamicDataSource;
        } else {
            return createDataSource(DATASOURCE_MASTER_PREFIX);
        }
    }

    private DataSource createDataSource(String prefix) {
        boolean useJndi = env.getProperty(prefix + ".jndi.enable", Boolean.class, false); // 是否使用数据源
        String jndiName = env.getProperty(prefix + ".jndi.name", ""); // 数据源名称
        String url = env.getProperty(prefix + ".url", "");
        String username = env.getProperty(prefix + ".username");
        String password = env.getProperty(prefix + ".password");
        String driverClass = env.getProperty(prefix + ".driver", "");
        int maxActive = env.getProperty(prefix + ".max.active", Integer.class, DEFAULT_DATASOURCE_MAX_ACTIVE);   // 数据源最大连接数
        int minIdle = env.getProperty(prefix + ".min.idle", Integer.class, DEFAULT_DATASOURCE_MIN_IDLE); // 数据源最小连接数

        if (useJndi) {
            try {
                logger.debug("get datasource from jndi - [{}].", jndiName);
                Context ctx = new InitialContext();
                DataSource dataSource = (DataSource) ctx.lookup(jndiName);
                return dataSource;
            } catch (Exception e) {
                logger.error("get jndi datasource error", e);
            }
        } else {
            logger.debug("create druid datasource.");
            logger.debug("url - {}.", url);
            logger.debug("username - {}.", username);
            logger.debug("password - {}.", password);
            logger.debug("driverClass - {}.", driverClass);
            logger.debug("maxActive - {}.", maxActive);
            logger.debug("minIdle - {}.", minIdle);

            try {
                DruidDataSource datasource = new DruidDataSource();
                datasource.setUrl(url);
                datasource.setDriverClassName(driverClass);
                datasource.setUsername(username);
                datasource.setPassword(password);
                datasource.setInitialSize(minIdle);
                datasource.setMaxActive(maxActive);
                datasource.setMinIdle(minIdle);
                datasource.setFilters("stat,slf4j");
                datasource.setProxyFilters(getDruidFilters());
                return datasource;
            } catch (Exception e) {
                logger.error("create datasource error", e);
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Filter> getDruidFilters() {
        List<Filter> filters = new ArrayList<>();

        Slf4jLogFilter slf4jLogFilter = new Slf4jLogFilter();
        slf4jLogFilter.setDataSourceLogEnabled(false);
        slf4jLogFilter.setStatementLogEnabled(false);
        slf4jLogFilter.setStatementExecutableSqlLogEnable(true);
        slf4jLogFilter.setResultSetLogEnabled(false);
        slf4jLogFilter.setResultSetCloseAfterLogEnabled(false);
        slf4jLogFilter.setConnectionLogEnabled(false);

        filters.add(new StatFilter());
        filters.add(slf4jLogFilter);
        return filters;
    }
}
