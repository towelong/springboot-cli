package com.welong.tpl.utils;

import com.welong.tpl.model.User;

/**
 * @Author WeLong
 * @create 2019/10/25 15:01
 */
public class LocalUser {
    private static ThreadLocal<User> local = new ThreadLocal<>();

    public static User getLocalUser() {
        return LocalUser.local.get();
    }

    public static void setLocalUser(User user) {
        LocalUser.local.set(user);
    }

    public static <T> T getLocalUser(Class<T> clazz) {
        return (T) local.get();
    }
}
