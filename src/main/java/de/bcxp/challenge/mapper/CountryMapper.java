package de.bcxp.challenge.mapper;

import de.bcxp.challenge.model.Country;
import de.bcxp.challenge.utils.DoubleUtils;

/**
 * A mapper class that implements the {@link Mapper} interface to map string arrays into
 * {@link Country} objects. It reads data fields and populates a Country object with
 * corresponding values.
 */
public class CountryMapper implements Mapper<Country> {

    /**
     * Maps an array of string values to a {@link Country} object based on the given field names.
     *
     * @param values An array of string values to be converted into a Country object.
     * @param fields An array of string field names corresponding to each value in the values array.
     *
     * @return A Country object populated with the provided data.
     *
     * @throws NumberFormatException If there is an error in parsing numerical values.
     * @throws NullPointerException  If any required value or field is missing.
     */
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
