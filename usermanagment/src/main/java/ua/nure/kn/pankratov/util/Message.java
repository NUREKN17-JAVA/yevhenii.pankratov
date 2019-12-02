package main.java.ua.nure.kn.pankratov.util;

import java.util.ResourceBundle;

public class Message {
    private static final String BUNDLE_NAME = "messages";

    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);

    private Message() {}

    public static String getString(String element) {
        return resourceBundle.getString(element);
    }
}