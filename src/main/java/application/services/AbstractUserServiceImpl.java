package application.services;

import application.dto.AbstractUserFullDTO;
import application.dto.MeterReadingFullDTO;
import application.dto.UserFullDTO;
import application.mappers.MeterReadingMapper;
import application.models.AbstractUser;
import application.models.Admin;
import application.models.MeterReadingImpl;
import application.models.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The AbstractUserServiceImpl class provides implementations for user-related operations.
 * It includes methods for user registration, login, logout, submitting meter readings, and
 * viewing meter reading history.
 */
public class AbstractUserServiceImpl implements AbstractUserService {

    private Map<String, AbstractUser> users;

    /**
     * Constructs a new AbstractUserServiceImpl with an empty map of users.
     */
    public AbstractUserServiceImpl() {
        users = new HashMap<>();
    }

    /**
     * Registers a new user or admin based on the provided user DTO.
     *
     * @param userDTO The user DTO containing username and password.
     * @param <T>     A type extending AbstractUserFullDTO.
     */
    public <T extends AbstractUserFullDTO> void registerAbstractUser(T userDTO) {
        if (!users.containsKey(userDTO.getUsername())) {
            users.put(userDTO.getUsername(), new User(userDTO.getUsername(), userDTO.getPassword()));
            System.out.println("User registered successfully!");
        } else {
            System.out.println("Username already exists. Please choose another username.");
        }
    }

    /**
     * Registers a new admin with the provided username and password.
     *
     * @param username The username of the admin.
     * @param password The password of the admin.
     */
    public void registerNewAdmin(String username, String password) {
        if (!users.containsKey(username)) {
            users.put(username, new Admin(username, password));
            System.out.println("Admin registered successfully!");
        } else {
            System.out.println("Username already exists. Please choose another username.");
        }
    }

    /**
     * Logs in a user based on the provided username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     */
    public void loginUser(String username, String password) {
        if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
            users.get(username).setIsLogin(true);
            System.out.println("Log in successful!");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    /**
     * Logs out a user based on the provided username.
     *
     * @param username The username of the user.
     */
    public void logOut(String username) {
        if (users.containsKey(username)) {
            users.get(username).setIsLogin(false);
            System.out.println("Logged out successfully!");
        } else {
            System.out.println("User not found");
        }
    }

    /**
     * Retrieves the map of registered users.
     *
     * @return The map of registered users.
     */
    public Map<String, AbstractUser> getUsers() {
        return users;
    }

    /**
     * Submits a meter reading for a user.
     *
     * @param abstractUserFullDTO The user for whom the meter reading is submitted.
     * @param meterReadingFullDTO The meter reading to be submitted.
     */
    public void submitMeterReading(AbstractUserFullDTO abstractUserFullDTO, MeterReadingFullDTO meterReadingFullDTO) {
        if (abstractUserIsAvailable(abstractUserFullDTO)) {
            if (abstractUserFullDTO instanceof UserFullDTO && meterReadingFullDTO != null) {
                ((User)users.get(abstractUserFullDTO.getUsername())).addMeterReading(MeterReadingMapper.toMeterReadingImpl(meterReadingFullDTO));
                System.out.println("Meter reading submitted successfully!");
            } else {
                System.out.println("Something went wrong, try again");
            }
        } else {
            System.out.println("User not found");
        }
    }

    /**
     * Retrieves the latest meter reading for a user.
     *
     * @param abstractUserFullDTO The user for whom the latest meter reading is retrieved.
     * @return The latest meter reading or null if none is available.
     */
    public MeterReadingFullDTO viewLatestMeterReading(AbstractUserFullDTO abstractUserFullDTO) {
        if (abstractUserIsAvailable(abstractUserFullDTO)) {
            if (abstractUserFullDTO instanceof UserFullDTO) {
                System.out.println("Got the last meter reading successfully!");
                return ((UserFullDTO) abstractUserFullDTO).getLatestMeterReading();
            } else {
                System.out.println("Something went wrong, try again");
                return null;
            }
        } else {
            System.out.println("User not found");
            return null;
        }
    }

    /**
     * Retrieves the meter reading history for a user.
     *
     * @param abstractUserFullDTO The user for whom the meter reading history is retrieved.
     * @return The list of meter readings in the history or null if none is available.
     */
    public List<MeterReadingImpl> viewMeterReadingHistory(AbstractUserFullDTO abstractUserFullDTO) {
        if (abstractUserIsAvailable(abstractUserFullDTO)) {
            if (abstractUserFullDTO instanceof UserFullDTO) {
                User user = (User) users.get(abstractUserFullDTO.getUsername());
                List<MeterReadingImpl> readingHistory = user.getMeterReadingHistory();
                return readingHistory;
            } else {
                System.out.println("Incorrect type of param");
                return null;
            }
        } else {
            System.out.println("User not found");
            return null;
        }
    }

    /**
     * Checks if a user with the provided username is available.
     *
     * @param abstractUserFullDTO The user to check for availability.
     * @return True if the user is available, false otherwise.
     */
    public boolean abstractUserIsAvailable(AbstractUserFullDTO abstractUserFullDTO) {
        return users.containsKey(abstractUserFullDTO.getUsername());
    }

    /**
     * Retrieves a user with the provided username.
     *
     * @param username The username of the user to retrieve.
     * @return The user with the provided username or null if not found.
     */
    public AbstractUser getCertainUser(String username) {
        return users.get(username);
    }
}
