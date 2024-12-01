package de.bcxp.challenge.service;

import de.bcxp.challenge.model.Weather;
import java.util.Comparator;
import java.util.List;

/**
 * Service class to provide operations related to weather.
 * It reads weather data from a file and allows operations on weather statistics.
 */
public class WeatherService {
    /**
     * Retrieves the day with the smallest temperature spread from the weather data.
     *
     * @param weatherList a list of countries
     * @return an {@code int} representing the day number with the smallest temperature spread
     * @throws java.util.NoSuchElementException if there is no weather data available
     */
    public static int getSmallestTempSpreadDay(List<Weather> weatherList) {
        return weatherList.stream().min(Comparator.comparingDouble(Weather::getTemperatureSpread)).orElseThrow().getDay();
    }
}
