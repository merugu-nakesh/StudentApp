package com.student.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static volatile PropertyReader propInstance;
    private PropertyReader(){

    }
    public static synchronized PropertyReader getInstance(){

        if (propInstance==null) {
            propInstance = new PropertyReader();
        }
        return propInstance;
    }
    /*
    * @param propertyName
    * @return
    * */
    public String getProperty(String propertyName){

        Properties prop = new Properties();
        try {

            InputStream inputStream = getClass().getClassLoader()
                    .getResourceAsStream("application.properties");
            prop.load(inputStream);
            if (prop.getProperty(propertyName)!= null){
                return prop.getProperty(propertyName);
            }
        }
        catch (Exception e) {

            System.out.println("Property not found");
        }
        return null;
    }

}
