package config;

import java.util.Locale;

public enum Environment {
    DEV,
    QA,
    STG;

    public static Environment from(String value) {
        if (value == null || value.isBlank()) {
            return QA;
        }

        try {
            return Environment.valueOf(value.trim().toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("Unsupportted environment: " + value, exception);
        }
    }
}
