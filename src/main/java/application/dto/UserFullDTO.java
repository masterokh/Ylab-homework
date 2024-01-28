package application.dto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
     * @param username The username of the user.
     * @param password The password of the user.
     */
    public UserFullDTO(String username, String password) {
        super(username, password);
    }

    /**
     * Adds a meter reading to the user's list of readings.
     *
     * @param reading The meter reading to be added.
     */
    public void addMeterReading(MeterReadingFullDTO reading) {
        if (meterReadings == null) {
            meterReadings = new LinkedList<>();
        }
        this.meterReadings.add(reading);
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
    public List<MeterReadingFullDTO> getMeterReadingsForMonth(int month) {
        List<MeterReadingFullDTO> readingsForMonth = new ArrayList<>();
        for (MeterReadingFullDTO reading : meterReadings) {
            if (reading.getMonth() == month) {
                readingsForMonth.add(reading);
            }
        }
        return readingsForMonth;
    }

    /**
     * Gets the entire reading history for the user.
     *
     * @return A list of all meter readings recorded for the user.
     */
    public List<MeterReadingFullDTO> getMeterReadingHistory() {
        return meterReadings;
    }
}
