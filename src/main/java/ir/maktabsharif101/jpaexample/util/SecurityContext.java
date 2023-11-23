package ir.maktabsharif101.jpaexample.util;

import ir.maktabsharif101.jpaexample.domain.BaseUser;

public class SecurityContext {

    private SecurityContext() {
    }

    private static BaseUser currentUser;

    public static void fillContext(BaseUser baseUser) {
        currentUser = baseUser;
    }

    public static void logout() {
        currentUser = null;
    }

    public static boolean isAnyoneAuthenticated() {
        return currentUser != null;
    }

    public static BaseUser getCurrentUser() {
        return currentUser;
    }

    public static Long getCurrentUserId() {
        return currentUser.getId();
    }

    public static String getCurrentUserType() {
        return currentUser.getUserType();
    }

}
