package com.app;

import com.jk.core.util.JK;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class VeryImportant {
    public static void main(String[] args) {
//        JK.print("Hello",", Uncle", "Jalal");
        ConfigReader configReader = new ConfigReader();


        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/properties.config")){
           Properties properties = configReader.getProperties();
           properties.load(fileInputStream);
           int test = Integer.parseInt(properties.getProperty("test"));
            System.out.println(test);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
