package cn.elvea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component("application")
public class Application {
    // 应用是否启用调试模式
    public static boolean DEBUG = false;

    //
    private static Environment env = null;

    @Autowired
    public Application(Environment env) {
        Application.env = env;

        DEBUG = getProperty("app.debug", Boolean.class, false);
    }

    public static String getProperty(String key) {
        return env.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return env.getProperty(key, defaultValue);
    }

    public static <T> T getProperty(String key, Class<T> clazz) {
        return env.getProperty(key, clazz);
    }

    public static <T> T getProperty(String key, Class<T> clazz, T defaultValue) {
        return env.getProperty(key, clazz, defaultValue);
    }
}
