package de.bcxp.challenge.utils;

public class DoubleUtils {

    public static double fromLocalizedString(String formattedNumber) {
        if (formattedNumber == null || formattedNumber.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }

        String normalized = formattedNumber.replace(".", "").replace(",", ".");
        return Double.parseDouble(normalized);
    }
}
