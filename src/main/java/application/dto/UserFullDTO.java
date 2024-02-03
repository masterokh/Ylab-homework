package application.dto;

import application.models.MeterReadingImpl;
import application.models.User;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The UserFullDTO class represents a data transfer object (DTO) for user information,
 * including meter readings. It extends the AbstractUserFullDTO class and includes
 * functionality related to managing meter readings, such as adding readings, retrieving
 * the latest reading, getting readings for a specific month, and getting the entire reading history.
 */
public class UserFullDTO extends AbstractUserFullDTO {

    private List<MeterReadingFullDTO> meterReadings;

    /**
     * Constructs a new UserFullDTO with the specified username and password.
     *
     * @param username      The username of the user.
     * @param password      The password of the user.
     * @param meterReadings
     */
    public UserFullDTO(String username, String password, List<MeterReadingFullDTO> meterReadings) {
        super(username, password);
        this.meterReadings = meterReadings;
    }
    public UserFullDTO(String username, String password) {
        super(username, password);
    }

    /**
     * Gets the latest meter reading for the user.
     *
     * @return The latest meter reading, or null if no readings are available.
     */
    public MeterReadingFullDTO getLatestMeterReading() {
        if (meterReadings == null || meterReadings.isEmpty()) {
            return null;
        }
        return meterReadings.get(meterReadings.size() - 1);
    }

    /**
     * Gets all meter readings for a specific month.
     *
     * @param month The month for which readings are retrieved.
     * @return A list of meter readings for the specified month.
     */
    public List<MeterReadingFullDTO> getMeterReadingsForMonth(Integer month) {
        return meterReadings.stream()
                .filter(reading -> reading.getMonth() == month)
                .collect(Collectors.toList());
    }
    /**
     * Gets the entire reading history for the user.
     *
     * @return A list of all meter readings recorded for the user.
     */
    public List<MeterReadingFullDTO> getMeterReadingHistory() {
        return meterReadings;
    }
    /**
     * Converts UserFullDTO to User.
     *
     * @return User object.
     */
    public User toUser() {
        User user = new User(getUsername(), getPassword());

        if (meterReadings != null) {
            List<MeterReadingImpl> meterReadingList = meterReadings.stream()
                    .map(MeterReadingFullDTO::toMeterReadingImpl)
                    .collect(Collectors.toList());

            for (MeterReadingImpl meterReading : meterReadingList) {
                user.addMeterReading(meterReading);
            }
        }

        return user;
    }
}
