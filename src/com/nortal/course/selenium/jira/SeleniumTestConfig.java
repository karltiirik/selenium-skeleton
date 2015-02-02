package com.nortal.course.selenium.jira;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by jevgeni on 1/30/15.
 */
public class SeleniumTestConfig {

    private Properties properties;

    public void init() {
        properties = new Properties(makePropertiesFromFile("selenium-common-rc.properties"));
        loadPropertiesFromFile(properties, "selenium-rc.properties");
    }

    private void loadPropertiesFromFile(Properties p, String filename) {
        try {
            p.load(getClass().getClassLoader().getResourceAsStream(filename));
        } catch (IOException e) {
            throw new RuntimeException("Error reading properties from file " + filename, e);
        }
    }

    private Properties makePropertiesFromFile(String filename) {
        Properties p = new Properties();
        loadPropertiesFromFile(p, filename);
        return p;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}