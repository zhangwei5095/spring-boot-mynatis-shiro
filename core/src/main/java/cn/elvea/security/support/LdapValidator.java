package cn.elvea.security.support;

import cn.elvea.Application;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;
import java.util.Map;

public class LdapValidator extends AuthValidator {
    private final static Logger logger = LoggerFactory.getLogger(LdapValidator.class);

    @Override
    public boolean auth(String username, String passWord, Map<String, Object> params) {
        logger.info("ldap auth begin...");

        if (username == null || passWord == null) {
            return false;
        }

        String adServer = Application.getProperty("auth.ldap.server");
        String adServerPort = Application.getProperty("auth.ldap.port");
        String adDomain = Application.getProperty("auth.ldap.port");

        String url = "ldap://" + adServer + ":" + adServerPort;
        String user = (Strings.isEmpty(adDomain)) ? username : adDomain + "\\" + username;

        Hashtable<String, String> env = new Hashtable<String, String>();

        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, user);
        env.put(Context.SECURITY_CREDENTIALS, passWord);
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, url);

        boolean isLogin = false;

        DirContext ctx = null;
        try {
            ctx = new InitialDirContext(env);
            ctx.close();
            logger.info("ldap auth pass.");
            isLogin = true;
        } catch (NamingException err) {
            isLogin = false;
            logger.error("ldap auth error.", err);
        } finally {
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (Exception e) {
                    logger.error("ldap auth error.", e);
                }
            }
        }
        logger.info("ldap auth finish. result - {}", isLogin);
        return isLogin;
    }
}
