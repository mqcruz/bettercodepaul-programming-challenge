package de.bcxp.challenge.mapper;

import de.bcxp.challenge.model.Weather;

/**
 * A mapper class that implements the {@link Mapper} interface to map string arrays into
 * {@link Weather} objects. It reads data fields and populates a Weather object with
 * corresponding values.
 */
public class WeatherMapper implements Mapper<Weather> {

    /**
     * Maps an array of string values to a {@link Weather} object based on the given field names.
     *
     * @param values An array of string values to be converted into a Weather object.
     * @param fields An array of string field names corresponding to each value in the values array.
     *
     * @return A Weather object populated with the provided data.
     *
     * @throws NumberFormatException If there is an error in parsing numerical values.
     * @throws NullPointerException  If any required value or field is missing.
     */
    @Override
    public Weather map(String[] values, String[] fields) {
        Weather weather  = new Weather();
        try {
            for (int i = 0; i < fields.length; i++) {
                String field = fields[i];
                String value = values[i];

                switch (field) {
                    case "Day":
                        weather.setDay(Integer.parseInt(value));
                        break;
                    case "MxT":
                        weather.setMaxTemp(Double.parseDouble(value));
                        break;
                    case "MnT":
                        weather.setMinTemp(Double.parseDouble(value));
                        break;
                    default:
                        break;
                }
            }
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("Error parsing weather data: " + e.getMessage());
        }
        return weather;
    }
}
