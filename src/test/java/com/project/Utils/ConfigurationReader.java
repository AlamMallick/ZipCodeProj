package com.project.Utils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This util class is use to read values from configuration.properties file
 */
public class ConfigurationReader {
    private  static Properties properties = new Properties();

    static{
        try {
            //open the file using inputstream
            FileInputStream inputStream = new FileInputStream("configuration.properties");

            //load to properties obj
            properties.load(inputStream);

            //close the file after loading. free memory
            inputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Error while reading configuration");
        }
    }
    /**
     * Method is used to read value from a configuration.properties file
     * @param key -> key name in properties file
     * @return -> value for the key. returns null if key not found
     * EX: driver.get( ConfigurationReader.getProperty("url") ) ;
     */
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
