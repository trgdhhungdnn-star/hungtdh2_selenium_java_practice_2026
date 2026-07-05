package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {
    private static final String CONFIG_FILE = "config.properties";

    private final Properties properties = new Properties();

    private ConfigReader() {
        try (InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream(CONFIG_FILE))
        {
            if (inputStream == null) {
                throw new IllegalStateException(CONFIG_FILE + "not found in test resource");
            }
            properties.load(inputStream);
        } catch (IOException exception) {
            throw new IllegalStateException("Can not load" + CONFIG_FILE, exception);
        }
    }

    private static final class Holder {
        private static final ConfigReader INSTANCE = new ConfigReader();
    }

    private String getValue(String key, String defaultValue) {
        String systemValue = System.getProperty(key);
        if (systemValue != null && !systemValue.isBlank()) {
            return systemValue;
        }
        return properties.getProperty(key,defaultValue);
    }

    private int parseNonNegativeInt(String key, String defaultValue) {
        try {
            int value = Integer.parseInt(getValue(key,defaultValue));
            if (value < 0) {
                throw new IllegalArgumentException(key + "must not be negative");
            }
            return value;
        } catch (NumberFormatException exception) {
            throw new IllegalStateException(key + " must be an Integer", exception);
        }
    }

    private String getRequiredValue(String key) {
        String value = getValue(key,null);
        if (value == null || value.isBlank()){
            throw new IllegalStateException("Missing required config " + key);
        }
        return value;
    }

    public static ConfigReader getInstance() {
        return Holder.INSTANCE;
    }

    public String getBrowser() {
        return getValue("browser", "chrome");
    }

    public boolean isHeadless() {
        return Boolean.parseBoolean(getValue("headless","false"));
    }

    public int getTimeoutSeconds() {
        return parseNonNegativeInt("timeout", "10");
    }

    public String getBaseUrl() {
        Environment environment = Environment.from(System.getProperty("env","QA"));
        return getRequiredValue("baseURL." + environment.name().toLowerCase());
    }

    public int getRetryCount() {
        return parseNonNegativeInt("retryCount","0");
    }
}
