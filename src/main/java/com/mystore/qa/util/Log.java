package com.mystore.qa.util;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;;

public class Log {

    synchronized public static Logger getLogData(String className){
//        String path = new File("").getAbsolutePath();
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        return Logger.getLogger(className);
    }

}