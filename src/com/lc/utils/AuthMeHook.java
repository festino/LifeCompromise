package com.lc.utils;

import org.bukkit.entity.Player;

import fr.xephi.authme.api.v3.AuthMeApi;

/**
 * AuthMe hook - class that handles talking with the AuthMe plugin.
 * <p>
 * It is a good idea to wrap all of your interactions with another plugin
 * into a separate class; this way you can keep track of the third-party
 * methods you use and you can easily change them or disable them,
 * e.g. when AuthMe is disabled.
 */
public class AuthMeHook {

    private AuthMeApi authMeApi = null;

    public void initializeAuthMeHook() {
        authMeApi = AuthMeApi.getInstance();
    }

    public void removeAuthMeHook() {
        authMeApi = null;
    }

    public boolean isHookActive() {
        return authMeApi != null;
    }

    public boolean isNameRegistered(String name) {
        return isHookActive() && authMeApi.isRegistered(name);
    }

    public boolean isLoggedIn(Player p) {
        return isHookActive() && authMeApi.isAuthenticated(p);
    }

    public void forceLogin(Player p) {
        if (isHookActive())
        	authMeApi.forceLogin(p);
    }
}
