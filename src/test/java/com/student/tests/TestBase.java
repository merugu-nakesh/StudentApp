package com.student.tests;

import com.student.util.PropertyReader;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase {

    public static PropertyReader prop;

    @BeforeClass
    public static void initUrl(){

        prop = PropertyReader.getInstance();
        RestAssured.baseURI = prop.getProperty("baseURi");
        RestAssured.port = Integer.valueOf(prop.getProperty("port"));
    }
}
