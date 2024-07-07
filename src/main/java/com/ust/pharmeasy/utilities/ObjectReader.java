package com.ust.pharmeasy.utilities;


import java.io.FileInputStream;
import java.util.Properties;

public class ObjectReader {
	private static Properties prop;
	public static Properties initProperties() {
		if(prop==null)
			prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/configs/Config.properties");
			prop.load(file);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}

}
