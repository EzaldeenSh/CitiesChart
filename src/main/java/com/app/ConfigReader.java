package com.app;

import java.util.Properties;

public class ConfigReader {
    private final Properties properties;

    public ConfigReader() {
        properties = new Properties();
    }

    public Properties getProperties() {
        return properties;
    }
}
