package application.models;

/**
 * The Admin class represents an administrator user, extending the AbstractUser class.
 * It includes additional functionality related to managing usernames of other users.
 */
public class Admin extends AbstractUser {
     /**
     * Constructs a new Admin with the specified username and password.
     *
     * @param username The username of the admin.
     * @param password The password of the admin.
     */
    public Admin(String username, String password) {
        super(username, password);
    }
}
