package com.gt.constants;

public final class FrameworkConstants {
    private FrameworkConstants(){}

    public static final String DIRECTORY_SYSTEM = System.getProperty("user.dir");
    public static final String DIRECTORY_TEST_RESOURCE = DIRECTORY_SYSTEM + "/src/test/resources/";

    public static final String PROPERTYNAME_QA = "qa.properties";
    public static final String PROPERTYNAME_DEV = "dev.properties";

}
