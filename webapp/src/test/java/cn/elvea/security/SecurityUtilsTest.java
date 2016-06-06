package cn.elvea.security;

import cn.elvea.core.utils.Encodes;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.util.ByteSource;
import org.junit.Assert;
import org.junit.Test;

public class SecurityUtilsTest {
    /**
     * 密码加密测试
     */
    @Test
    public void encryptPasswordTest() {
        String username = "root";
        String password = "123456";
        byte[] salt = Encodes.decodeHex("12345678");
        String entryptedPassword = SecurityUtils.entryptPassword("123456", salt);

        System.out.println("Plain Password - " + password);
        System.out.println("Encrypted Password - " + entryptedPassword);

        SecurityToken token = SecurityToken.createFormToken(username, password, null, null, false);
        AuthenticationInfo info = new SimpleAuthenticationInfo(
                new SecurityUser(token.getUsername(), token.getUsername()),
                entryptedPassword, ByteSource.Util.bytes(salt), token.getUsername()
        );

        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher(SecurityUtils.HASH_ALGORITHM);
        credentialsMatcher.setHashIterations(SecurityUtils.HASH_INTERATIONS);

        Assert.assertTrue(credentialsMatcher.doCredentialsMatch(token, info));
    }
}
