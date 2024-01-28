package application.models;

import java.util.List;

/**
 * The Admin class represents an administrator user, extending the AbstractUser class.
 * It includes additional functionality related to managing usernames of other users.
 */
public class Admin extends AbstractUser {

    private List<String> usernamesOfUsers;

    /**
     * Constructs a new Admin with the specified username and password.
     *
     * @param username The username of the admin.
     * @param password The password of the admin.
     */
    public Admin(String username, String password) {
        super(username, password);
    }

    /**
     * Gets the list of usernames of other users managed by the admin.
     *
     * @return The list of usernames.
     */
    public List<String> getUsernamesOfUsers() {
        return usernamesOfUsers;
    }

    /**
     * Adds a username to the list of usernames managed by the admin.
     *
     * @param username The username to be added.
     */
    public void addUserInUsernamesOfUser(String username) {
        if (!usernamesOfUsers.contains(username)) {
            usernamesOfUsers.add(username);
        } else {
            System.out.println("Этот логин " + username + " уже присутствует в списке пользователей");
        }
    }

    /**
     * Adds a list of usernames to the list of usernames managed by the admin.
     *
     * @param listOfUsers The list of usernames to be added.
     */
    public void addUsersInUsernamesOfUser(List<String> listOfUsers) {
        while (!listOfUsers.isEmpty()) {
            for (String element : listOfUsers) {
                if (!usernamesOfUsers.contains(element)) {
                    usernamesOfUsers.add(element);
                } else {
                    System.out.println("Этот логин " + element + " уже присутствует в списке пользователей");
                }
            }
        }
    }
}
