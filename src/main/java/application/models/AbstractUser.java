package application.models;

/**
 * The AbstractUser class represents a generic user with basic login credentials.
 * It provides methods to access and modify the user's information.
 */
public abstract class AbstractUser {

    private String username;
    private String password;
    private boolean isLogin;

    /**
     * Constructs a new AbstractUser with the specified username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     */
    public AbstractUser(String username, String password) {
        this.username = username;
        this.password = password;
        isLogin = false;
    }

    /**
     * Gets the username of the user.
     *
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the password of the user.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the login status of the user.
     *
     * @param isLogin True if the user is logged in, false otherwise.
     */
    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    /**
     * Checks whether the user is currently logged in.
     *
     * @return True if the user is logged in, false otherwise.
     */
    public boolean getIsLogin() {
        return isLogin;
    }
}
