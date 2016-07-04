package cn.elvea.security.support;

import java.util.Map;

public class CasValidator extends AuthValidator {
    @Override
    public boolean auth(String username, String password, Map<String, Object> params) {
        return false;
    }
}
