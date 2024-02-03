package application.dto;

import application.models.MeterReadingImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeterReadingFullDTO {

    private int month;
    private int year;
    private Map<String, Double> readings = new HashMap<>();

    public MeterReadingFullDTO(int month, int year) {
        this.month = month;
        this.year = year;
        readings = new HashMap<>();
    }

    /**
     * Converts MeterReadingFullDTO to MeterReadingImpl.
     *
     * @return The MeterReadingImpl object.
     */
    public MeterReadingImpl toMeterReadingImpl() {
        MeterReadingImpl meterReading = new MeterReadingImpl(this.month, this.year);

        Map<String, Double> readings = this.readings;
        for (Map.Entry<String, Double> entry : readings.entrySet()) {
            meterReading.addReading(entry.getKey(), entry.getValue());
        }

        return meterReading;
    }
}
