package cn.elvea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, CacheAutoConfiguration.class})
public class Application extends SpringBootServletInitializer {
    public final static int DEFAULT_DATASOURCE_INIT_SIZE = 1;
    public final static int DEFAULT_DATASOURCE_MAX_ACTIVE = 100;
    public final static int DEFAULT_DATASOURCE_MIN_IDLE = 1;
    public final static int DEFAULT_DATASOURCE_MAX_WAIT = 6000;

    public final static String MASTER_DATASOURCE_PREFIX = "master";
    public final static String SLAVE_DATASOURCE_PREFIX = "slave";

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
