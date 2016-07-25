package cn.elvea;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * 应用初始化类
 */
@SpringBootApplication
public class Initializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Initializer.class);
    }

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication();
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(Initializer.class, args);
    }
}
