package de.bcxp.challenge.mapper;

import de.bcxp.challenge.model.Country;
import de.bcxp.challenge.utils.DoubleUtils;

public class CountryMapper implements Mapper<Country> {
    @Override
    public Country map(String[] values, String[] fields) {
        Country country = new Country();
        try {
            for (int i = 0; i < fields.length; i++) {
                String field = fields[i];
                String value = values[i];

                switch (field) {
                    case "Name":
                        country.setName(value);
                        break;
                    case "Population":
                        country.setPopulation(DoubleUtils.fromLocalizedString(value));
                        break;
                    case "Area (km²)":
                        country.setArea(Double.parseDouble(value));
                        break;
                    default:
                        break;
                }
            }
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("Error parsing country data: " + e.getMessage());
        }
        return country;
    }
}
