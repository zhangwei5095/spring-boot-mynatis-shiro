package cn.elvea.security.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class WsValidator extends AuthValidator {
    private final static Logger logger = LoggerFactory.getLogger(HttpValidator.class);

    @Override
    public boolean auth(String username, String password, Map<String, Object> params) {
        return false;
    }
}
