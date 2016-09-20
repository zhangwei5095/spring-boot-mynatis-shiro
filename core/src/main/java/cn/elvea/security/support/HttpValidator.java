package cn.elvea.security.support;

import cn.elvea.Application;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

public class HttpValidator extends AuthValidator {
    private final static Logger logger = LoggerFactory.getLogger(HttpValidator.class);

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Override
    public boolean auth(String username, String password, Map<String, Object> params) {
        boolean result = false;


        String httpUrl = Application.getProperty("auth.http.url");
        String httpUsernameParamName = Application.getProperty("auth.http.username.param.name");
        String httpPasswordParamName = Application.getProperty("auth.http.password.param.name");

        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder().url(httpUrl).build();
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                // 调用Http请求后成功返回,根据返回结果自行检查是否验证通过
                String resp = response.body().string();

                result = true;
            } else {
                throw new IOException("Unexpected code " + response);
            }
        } catch (Exception e) {
            logger.error("http auth error");
        }
        return false;
    }
}
