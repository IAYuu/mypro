package com.jelly.tic.extension;

import com.jelly.tic.entity.User;

public class UserContext implements AutoCloseable {

    static final ThreadLocal<User> current = new ThreadLocal<User>();

    public UserContext(User user) {
        current.set(user);
    }

    public static User getCurrentUser() {
        return current.get();
    }

    public void close() {
        current.remove();
    }
}
