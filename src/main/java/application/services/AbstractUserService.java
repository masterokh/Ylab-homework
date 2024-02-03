package application.services;

import application.dto.AbstractUserFullDTO;
import application.dto.MeterReadingFullDTO;
import application.models.AbstractUser;
import application.models.MeterReadingImpl;
import java.util.List;
import java.util.Map;

/**
 * The AbstractUserService interface defines methods for managing users and meter readings.
 * It provides functionalities such as user registration, login, logout, submitting meter readings,
 * and retrieving information about users and their meter reading history.
 */
public interface AbstractUserService {

    /**
     * Retrieves a map of all registered users.
     *
     * @return A map containing usernames as keys and corresponding user objects.
     */
    Map<String, AbstractUser> getUsers();

    /**
     * Registers a new user or admin based on the provided user DTO.
     *
     * @param userDTO The user DTO containing username and password.
     * @param <T>     A type extending AbstractUserFullDTO.
     */
    <T extends AbstractUserFullDTO> void registerAbstractUser(T userDTO);

    /**
     * Registers a new admin with the provided username and password.
     *
     * @param username The username of the admin.
     * @param password The password of the admin.
     */
    void registerNewAdmin(String username, String password);

    /**
     * Logs in a user based on the provided username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     */
    void loginUser(String username, String password);

    /**
     * Logs out a user based on the provided username.
     *
     * @param username The username of the user.
     */
    void logOut(String username);

    /**
     * Submits a meter reading for a user.
     *
     * @param abstractUserFullDTO The user for whom the meter reading is submitted.
     * @param meterReadingFullDTO The meter reading to be submitted.
     */
    void submitMeterReading(AbstractUserFullDTO abstractUserFullDTO, MeterReadingFullDTO meterReadingFullDTO);

    /**
     * Retrieves the latest meter reading for a user.
     *
     * @param abstractUserFullDTO The user for whom the latest meter reading is retrieved.
     * @return The latest meter reading or null if none is available.
     */
    MeterReadingFullDTO viewLatestMeterReading(AbstractUserFullDTO abstractUserFullDTO);

    /**
     * Retrieves the meter reading history for a user.
     *
     * @param abstractUserFullDTO The user for whom the meter reading history is retrieved.
     * @return The list of meter readings in the history or null if none is available.
     */
    List<MeterReadingImpl> viewMeterReadingHistory(AbstractUserFullDTO abstractUserFullDTO);

    /**
     * Checks if a user with the provided username is available.
     *
     * @param abstractUserFullDTO The user to check for availability.
     * @return True if the user is available, false otherwise.
     */
    boolean abstractUserIsAvailable(AbstractUserFullDTO abstractUserFullDTO);

    /**
     * Retrieves a user with the provided username.
     *
     * @param username The username of the user to retrieve.
     * @return The user with the provided username or null if not found.
     */
    AbstractUser getCertainUser(String username);
}
