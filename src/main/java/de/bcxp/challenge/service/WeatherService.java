package de.bcxp.challenge.service;

import de.bcxp.challenge.model.Weather;
import java.util.Comparator;
import java.util.List;

/**
 * Service class to provide operations related to weather.
 * It reads weather data from a file and allows operations on weather statistics.
 */
public class WeatherService {
    private final List<Weather> weatherList;

    /**
     * Constructs a new WeatherService with the specified FileReaderService.
     * It reads weather data from a file located in the resources.
     *
     * @param fileReaderService a service for reading files
     */
    public WeatherService(FileReaderService fileReaderService) {
        String filePath = "src/main/resources/de/bcxp/challenge/weather.csv";
        weatherList = fileReaderService.readData(filePath);
    }

    /**
     * Retrieves the day with the smallest temperature spread from the weather data.
     *
     * @return an {@code int} representing the day number with the smallest temperature spread
     * @throws java.util.NoSuchElementException if there is no weather data available
     */
    public int getSmallestTempSpreadDay() {
        return this.weatherList.stream().min(Comparator.comparingDouble(Weather::getTemperatureSpread)).orElseThrow().getDay();
    }
}
