package de.bcxp.challenge.mapper;

import java.util.Map;

/**
 * The {@code MapperRegistry} class provides a static registry of mappers that
 * links file names to their corresponding {@link Mapper} implementations.
 * It is used to retrieve the appropriate mapper based on the name of a file.
 */
public class MapperRegistry {

    private static final Map<String, Mapper<?>> registry = Map.of(
            "countries.csv", new CountryMapper(),
            "weather.csv", new WeatherMapper());

    /**
     * Retrieves the appropriate {@link Mapper} instance based on the file name.
     *
     * @param fileName The name of the file whose mapper is to be retrieved.
     * @return The {@link Mapper} instance associated with the provided file name.
     *         Returns {@code null} if no mapper is found for the file name.
     */
    public static Mapper<?> getMapper(String fileName) {
        if (registry.containsKey(fileName)) {
            return registry.get(fileName);
        } else {
            throw new RuntimeException("File not found - fileName: " + fileName);
        }
    }
}
