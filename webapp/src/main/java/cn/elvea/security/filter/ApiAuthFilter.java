package cn.elvea.security.filter;

import cn.elvea.security.SecurityToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * todo: 移动端的登录验证拦截器,具体等后面确定移动端开发模式后再来完善
 */
public class ApiAuthFilter extends FormAuthenticationFilter {
    public static final String DEFAULT_TOKEN_PARAM = "token";

    private String tokenParam = DEFAULT_TOKEN_PARAM;

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        SecurityToken token = createToken(request, response);
        if (token == null) {
            throw new IllegalStateException("token cannot be null.");
        }

        try {
            Subject subject = getSubject(request, response);
            subject.login(token);
            return onLoginSuccess(token, subject, request, response);
        } catch (AuthenticationException e) {
            return onLoginFailure(token, e, request, response);
        }
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (isLoginRequest(request, response)) {
            return executeLogin(request, response);
        } else {
            saveRequestAndRedirectToLogin(request, response);
            return false;
        }
    }

    @Override
    protected SecurityToken createToken(ServletRequest request, ServletResponse response) {
        String username = getUsername(request);
        String password = getPassword(request);
        String token = getToken(request);

        return SecurityToken.createApiToken(username, password, token);
    }

    protected String getToken(ServletRequest request) {
        return WebUtils.getCleanParam(request, getTokenParam());
    }

    public String getTokenParam() {
        return tokenParam;
    }

    public void setTokenParam(String tokenParam) {
        this.tokenParam = tokenParam;
    }

}
