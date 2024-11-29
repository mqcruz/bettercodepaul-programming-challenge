package de.bcxp.challenge.service;

import de.bcxp.challenge.model.Weather;

import java.util.Comparator;
import java.util.List;

public class WeatherService {
    private final List<Weather> weatherList;

    public WeatherService(CsvFileReaderService csvFileReaderService) {
        String filePath = "src/main/resources/de/bcxp/challenge/weather.csv";
        String delimiter = ",";
        weatherList = csvFileReaderService.readData(filePath, delimiter);
    }

    public int getSmallestTempSpreadDay() {
        return this.weatherList.stream().min(Comparator.comparingDouble(Weather::getTemperatureSpread)).orElseThrow().getDay();
    }
}
