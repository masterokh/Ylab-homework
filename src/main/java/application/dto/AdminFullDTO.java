package application.dto;

import java.util.List;

/**
 * The AdminFullDTO class represents a data transfer object (DTO) for administrator user information.
 * It extends the AbstractUserFullDTO class and includes additional details such as a list of usernames
 * of other users.
 */
public class AdminFullDTO extends AbstractUserFullDTO {

    private List<String> usernamesOfUsers;

    /**
     * Constructs a new AdminFullDTO with the specified username and password.
     *
     * @param username The username of the admin.
     * @param password The password of the admin.
     */
    public AdminFullDTO(String username, String password) {
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
            System.out.println("This " + username + " username already in a list of users");
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
                    System.out.println("This " + element + " username already in a list of users");
                }
            }
        }
    }
}
