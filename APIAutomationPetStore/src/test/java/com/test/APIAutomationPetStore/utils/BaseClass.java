package com.test.APIAutomationPetStore.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;




public class BaseClass {
	static String filePath      =    "./Config/Config.properties";

	public static Properties properties;

	public static void init(){
		properties = new Properties();
		try {
			FileInputStream ip = new FileInputStream(filePath);
			properties.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

} 

