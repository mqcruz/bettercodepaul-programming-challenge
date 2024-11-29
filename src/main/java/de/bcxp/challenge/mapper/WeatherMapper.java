package de.bcxp.challenge.mapper;

import de.bcxp.challenge.model.Weather;

public class WeatherMapper implements Mapper<Weather> {
    @Override
    public Weather map(String[] values, String[] fields) {
        Weather weather  = new Weather();

        for(int i = 0; i < fields.length; i++) {
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
            } //TODO: handle errors
        }
        return weather;
    }
}
