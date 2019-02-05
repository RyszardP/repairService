package com.htp.repairService.controller.command.util;

import java.util.ResourceBundle;

/**
 * The class for basic settings of the property file for the pages addresses
 */
public class PagesConfigManager {

    private static PagesConfigManager instance;
    private ResourceBundle resourceBundle;

    private static final String BUNDLE_NAME = "pages";

    private static final String ADMIN_PAGE = "ADMIN";
    private static final String RESULT_PAGE = "RESULT";


    public static PagesConfigManager getInstance() {
        if (instance == null) {
            instance = new PagesConfigManager();
            instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getProperty(String key) {
        return (String) resourceBundle.getObject(key);
    }
}