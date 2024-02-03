package application.dto;

/**
 * The AbstractUserFullDTO class represents a data transfer object (DTO) for user information.
 * It includes basic details such as username, password, and login status.
 */
public abstract class AbstractUserFullDTO {

    private String username;
    private String password;
    private boolean isLogin;

    /**
     * Constructs a new AbstractUserFullDTO with the specified username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     */
    public AbstractUserFullDTO(String username, String password) {
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
     * Gets the login status of the user.
     *
     * @return True if the user is logged in, false otherwise.
     */
    public boolean getIsLogin() {
        return isLogin;
    }
}
