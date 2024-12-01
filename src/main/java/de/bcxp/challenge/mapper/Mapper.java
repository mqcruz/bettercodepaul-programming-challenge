package de.bcxp.challenge.mapper;

/**
 * The {@code Mapper} interface defines a contract for mapping an array of string values
 * to an instance of type {@code T}. It serves as a generic interface to transform data
 * into a structured object.
 *
 * @param <T> The type of object that this mapper generates from the string values.
 */
public interface Mapper<T> {
    /**
     * Maps an array of string values to an instance of type {@code T} based on the
     * associated field names.
     *
     * @param values An array of string values representing the data to be mapped.
     * @param fields An array of string field names corresponding to each value in the
     *               values array, defining the structure of the target object.
     * @return An instance of type {@code T} populated with the provided data.
     */
    T map(String[] values, String[] fields);
}
