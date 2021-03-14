package com.github.libkhadir.utils;

import java.util.ResourceBundle;

public class ConfigHelper {
    private static ResourceBundle resourceBundle;

    public static String getValue(final String key) {
        if (resourceBundle == null) {
            resourceBundle = ResourceBundle.getBundle("application");
        }
        return resourceBundle.getString(key);
    }

    public static Integer getIntValue(final String key) {
        return Integer.valueOf(getValue(key));
    }
}
