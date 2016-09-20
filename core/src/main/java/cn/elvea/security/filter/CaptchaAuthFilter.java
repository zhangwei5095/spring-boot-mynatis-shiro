package cn.elvea.security.filter;

import cn.elvea.security.SecurityToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CaptchaAuthFilter extends FormAuthenticationFilter {
    private static Logger logger = LoggerFactory.getLogger(CaptchaAuthFilter.class);

    public final static String Shiro_Session_Username_Key = "Shiro_Session_Username_Key";

    private String captchaParam = "captcha";

    private String getCaptcha(ServletRequest request) {
        return WebUtils.getCleanParam(request, getCaptchaParam());
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        SecurityToken token = createToken(request, response);
        if (token == null) {
            throw new IllegalStateException("token cannot be null.");
        }
        try {
            // 验证图形验证码是否正确
            doCaptchaValidate((HttpServletRequest) request, token);

            Subject subject = getSubject(request, response);
            subject.login(token);
            return onLoginSuccess(token, subject, request, response);
        } catch (AuthenticationException e) {
            return onLoginFailure(token, e, request, response);
        }
    }

    // 验证码校验
    protected void doCaptchaValidate(HttpServletRequest request, SecurityToken token) {
//        String captcha = (String) request.getSession().getAttribute(CaptchaServlet.CAPTCHA);
//        if (captcha != null && !captcha.equalsIgnoreCase(token.getCaptcha())) {
//            throw new IncorrectCaptchaException("Incorrect Captcha.");
//        }
    }

    @Override
    protected SecurityToken createToken(ServletRequest request, ServletResponse response) {
        String username = getUsername(request);
        String password = getPassword(request);
        String captcha = getCaptcha(request);
        String host = getHost(request);
        boolean rememberMe = isRememberMe(request);

        return SecurityToken.createFormToken(username, password, captcha, host, rememberMe);
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        String username = token.getPrincipal().toString();
        subject.getSession().setAttribute(Shiro_Session_Username_Key, username);
        return super.onLoginSuccess(token, subject, request, response);
    }

    public String getCaptchaParam() {
        return captchaParam;
    }

    public void setCaptchaParam(String captchaParam) {
        this.captchaParam = captchaParam;
    }
}
