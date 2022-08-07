package com.gt.utils;

import com.gt.constants.FrameworkConstants;
import com.gt.exceptions.PropertyNotFoundException;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyFileReader {
    private PropertyFileReader() {}

    private static Properties properties = new Properties();
    private static Map<String, String> propertyMap = new HashMap<>();

    static {
        String envName = System.getenv("env") == "qa" ? FrameworkConstants.PROPERTYNAME_QA
                : FrameworkConstants.PROPERTYNAME_DEV;
        try {
            File file = new File(FrameworkConstants.DIRECTORY_TEST_RESOURCE + "/" +envName);
            InputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
            properties.entrySet().forEach((property) -> {
                propertyMap.put(String.valueOf(property.getKey()), String.valueOf(property.getValue()));
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        if(Objects.isNull(key) || !propertyMap.containsKey(key)) {
            throw new PropertyNotFoundException("The Propery value is either null or not present in " +
                    " property file");
        }
        return propertyMap.get(key);
    }
}
