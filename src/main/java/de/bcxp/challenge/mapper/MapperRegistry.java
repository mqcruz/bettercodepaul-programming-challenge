package de.bcxp.challenge.mapper;

import java.util.Map;

public class MapperRegistry {

    private static final Map<String, Mapper<?>> registry = Map.of(
            "countries.csv", new CountryMapper(),
            "weather.csv", new WeatherMapper());

    public static Mapper<?> getMapper(String fileName) {
        if(registry.containsKey(fileName)) {
            return registry.get(fileName);
        } else {
            throw new RuntimeException("File not found - fileName: " + fileName);
        }
    }
}
