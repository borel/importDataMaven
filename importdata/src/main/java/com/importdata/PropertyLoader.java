package com.importdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

	static Properties prop;

	/**
	 * Load of the propertie files
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static Properties load(String filename) throws IOException {
		Properties properties = new Properties();
		FileInputStream input = new FileInputStream(filename);
		try {
			properties.load(input);
			return properties;
		} finally {
			input.close();
		}

	}

	/**
	 * Constructor of the property loader
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void init() throws IOException {
		prop = new Properties();
		prop.load(PropertyLoader.class.getResourceAsStream("/config/importData.properties"));
	}

	/**
	 * get value of the propertie in importData.properties
	 * 
	 * @param property
	 * @return
	 */
	public static String getValue(String property) {
		return prop.getProperty(property,"empty");
	}
}