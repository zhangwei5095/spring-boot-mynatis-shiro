package cn.elvea.security;

import java.io.Serializable;
import java.util.Objects;

public class SecurityUser implements Serializable {
    // 用户登录名
    private String username;
    // 用户全名
    private String name;
    // 用户来源,用来区分用户是平台创建或者是同步过来的,某些情况下,同步的用户的登录验证可能会是其他的验证方式
    private String source;

    public SecurityUser() {
    }

    public SecurityUser(String username, String name) {
        this.username = username;
        this.name = name;
    }

    @Override
    public String toString() {
        return username;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        SecurityUser other = (SecurityUser) obj;
        if (username == null) {
            if (other.username != null) {
                return false;
            }
        } else if (!username.equals(other.username)) {
            return false;
        }
        return true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
