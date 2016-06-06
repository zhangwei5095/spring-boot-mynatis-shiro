package cn.elvea.security;

import cn.elvea.core.utils.Digests;
import cn.elvea.core.utils.Encodes;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * 封装一些常用的Shiro操作
 */
public class SecurityUtils {
    public final static String HASH_ALGORITHM = "SHA-1";
    public final static int HASH_INTERATIONS = 1024;
    private final static int SALT_SIZE = 8;

    public static String getUsername() {
        Subject subject = getSubject();
        return null;
    }

    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    public static String getSessionId() {
        Session session = getSession();
        if (null == session) {
            return null;
        }
        return getSession().getId().toString();
    }

    public static boolean isAuthenticated() {
        return getSubject().isAuthenticated();
    }

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 对传入的明文密码进行加密
     */
    public static String entryptPassword(String plainPassword, String salt) {
        byte[] saltByte = Encodes.decodeHex(salt);
        return entryptPassword(plainPassword, saltByte);
    }

    public static String entryptPassword(String plainPassword, byte[] saltByte) {
        byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), saltByte, HASH_INTERATIONS);
        return Encodes.encodeHex(hashPassword);
    }

    /**
     * 生成一个随机的Salt,添加用户或者修改用户密码的时候,都会自动生成一个8位的随机数做为密码加密的盐
     */
    public static String generateSalt() {
        return Encodes.encodeHex(Digests.generateSalt(SALT_SIZE));
    }
}
