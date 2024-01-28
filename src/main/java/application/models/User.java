package application.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * The User class represents a user in the application, extending the AbstractUser class.
 * It includes functionality related to managing meter readings, such as adding readings,
 * retrieving the latest reading, getting readings for a specific month, and getting the entire
 * reading history.
 */
public class User extends AbstractUser {

    private List<MeterReadingImpl> meterReadings;

    /**
     * Constructs a new User with the specified username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     */
    public User(String username, String password) {
        super(username, password);
    }

    /**
     * Adds a meter reading to the user's list of readings.
     *
     * @param reading The meter reading to be added.
     */
    public void addMeterReading(MeterReadingImpl reading) {
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
    public MeterReadingImpl getLatestMeterReading() {
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
    public List<MeterReadingImpl> getMeterReadingsForMonth(int month) {
        List<MeterReadingImpl> readingsForMonth = new ArrayList<>();
        for (MeterReadingImpl reading : meterReadings) {
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
    public List<MeterReadingImpl> getMeterReadingHistory() {
        return meterReadings;
    }
}
