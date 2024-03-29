package org.technical.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.technical.utils.PropertyReader;

/**
 * Created by bhavesh Patel
 */
public class TestBase {
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init(){
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
    }

}
