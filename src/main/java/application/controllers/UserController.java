package application.controllers;

import application.dto.AbstractUserFullDTO;
import application.dto.MeterReadingFullDTO;
import application.models.AbstractUser;
import application.models.MeterReadingImpl;
import java.util.List;
import java.util.Map;

/**
 * Represents the interface for user input operations.
 * Acts as a boundary between the application's business logic and user interactions.
 */
public interface UserController {

    /**
     * Retrieves a map of all users in the system.
     *
     * @return A map containing usernames as keys and corresponding user DTOs.
     */
    Map<String, AbstractUser> getUsers();

    /**
     * Registers a new user in the system.
     *
     * @param userDTO The user data transfer object to be registered.
     * @param <T>     Type parameter for the user data transfer object.
     */
    <T extends AbstractUserFullDTO> void registerAbstractUser(T userDTO);

    /**
     * Registers a new admin in the system.
     *
     * @param username The username for the new admin.
     * @param password The password for the new admin.
     */
    void registerNewAdmin(String username, String password);

    /**
     * Logs in a user with the specified username and password.
     *
     * @param username The username of the user attempting to log in.
     * @param password The password associated with the specified username.
     */
    void loginUser(String username, String password);

    /**
     * Logs out the user with the specified username.
     *
     * @param username The username of the user to log out.
     */
    void logOut(String username);

    /**
     * Submits a meter reading for a specific user.
     *
     * @param abstractUserFullDTO The user for whom the meter reading is submitted.
     * @param meterReadingFullDTO The meter reading data transfer object.
     */
    void submitMeterReading(AbstractUserFullDTO abstractUserFullDTO, MeterReadingFullDTO meterReadingFullDTO);

    /**
     * Retrieves the latest meter reading for a specific user.
     *
     * @param abstractUserFullDTO The user for whom to retrieve the latest meter reading.
     * @return The latest meter reading data transfer object.
     */
    MeterReadingFullDTO viewLatestMeterReading(AbstractUserFullDTO abstractUserFullDTO);

    /**
     * Retrieves the meter reading history for a specific user.
     *
     * @param abstractUserFullDTO The user for whom to retrieve the meter reading history.
     * @return A list of meter reading data transfer objects representing the history.
     */
    List<MeterReadingImpl> viewMeterReadingHistory(AbstractUserFullDTO abstractUserFullDTO);

    /**
     * Checks if a specific user is available in the system.
     *
     * @param abstractUserFullDTO The user to check for availability.
     * @return {@code true} if the user is available, {@code false} otherwise.
     */
    boolean abstractUserIsAvailable(AbstractUserFullDTO abstractUserFullDTO);

    /**
     * Retrieves a specific user by username.
     *
     * @param username The username of the user to retrieve.
     * @return The user data transfer object corresponding to the specified username.
     */
    AbstractUser getCertainUser(String username);
}
