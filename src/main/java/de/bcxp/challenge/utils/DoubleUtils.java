package de.bcxp.challenge.utils;

/**
 * The {@code DoubleUtils} class provides utility methods for handling operations related
 * to {@code double} numbers.
 */
public class DoubleUtils {
    /**
     * Converts a string formatted according to localized number conventions into a {@code double}.
     *
     * @param formattedNumber The string representation of a number
     * @return The {@code double} value parsed from the given string.
     * @throws NumberFormatException if the string does not contain a parsable number.
     */
    public static double fromLocalizedString(String formattedNumber) {
        if (formattedNumber == null || formattedNumber.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }

        String normalized = formattedNumber.replace(".", "").replace(",", ".");
        return Double.parseDouble(normalized);
    }
}
