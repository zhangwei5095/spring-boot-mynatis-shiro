package cn.elvea.security;

import cn.elvea.commons.utils.Encodes;
import cn.elvea.domain.Role;
import cn.elvea.domain.User;
import cn.elvea.service.UserService;
import org.apache.logging.log4j.util.Strings;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SecurityRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory.getLogger(SecurityRealm.class);

    @Autowired
    UserService userService;

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.debug("doGetAuthorizationInfo......");

        SimpleAuthorizationInfo info = null;

        SecurityUser securityUser = (SecurityUser) principals.getPrimaryPrincipal();
        User user = userService.findByUsername(securityUser.getUsername());

        if (user != null) {
            info = new SimpleAuthorizationInfo();

            for (Role role : user.getRolelst()) {
                // 用户拥有角色
                info.addRole(role.getCode());

                // 角色的授权信息
//                info.addStringPermissions(role.getPermissions().stream().map(Permission::getCode).collect(Collectors.toSet()));
            }
            // 用户的授权信息
//            info.addStringPermissions(user.getPermissions().stream().map(Permission::getCode).collect(Collectors.toSet()));
        }
        return info;
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        logger.debug("doGetAuthenticationInfo......");
        User user = userService.findByUsername(authcToken.getPrincipal().toString());
        if (user != null) {
            byte[] salt = Encodes.decodeHex("12345678");

            SecurityUser securityUser = new SecurityUser();
            securityUser.setName(user.getNickname());
            securityUser.setUsername(user.getEmployeeNumber());
            return new SimpleAuthenticationInfo(securityUser, user.getPassword(), ByteSource.Util.bytes(salt), getName());
        }
        return null;
    }

    @Override
    protected void assertCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) throws AuthenticationException {
        if (token instanceof SecurityToken) {
            SecurityToken securityToken = (SecurityToken) token;

            String loginType = securityToken.getType();
            if (Strings.isNotBlank(loginType) && loginType.equalsIgnoreCase(SecurityConstants.AUTH_TYPE_SSO)) {

            } else if (Strings.isNotBlank(loginType) && loginType.equalsIgnoreCase(SecurityConstants.AUTH_TYPE_FORM)) {
                super.assertCredentialsMatch(token, info);
            } else if (Strings.isNotBlank(loginType) && loginType.equalsIgnoreCase(SecurityConstants.AUTH_TYPE_API)) {
                super.assertCredentialsMatch(token, info);
            }
        } else {
            super.assertCredentialsMatch(token, info);
        }
    }
}
