package application.dto;

/**
 * The AdminFullDTO class represents a data transfer object (DTO) for administrator user information.
 * It extends the AbstractUserFullDTO class and includes additional details such as a list of usernames
 * of other users.
 */
public class AdminFullDTO extends AbstractUserFullDTO {

    /**
     * Constructs a new AdminFullDTO with the specified username and password.
     *
     * @param username The username of the admin.
     * @param password The password of the admin.
     */
    public AdminFullDTO(String username, String password) {
        super(username, password);
    }
}
