package com.fpt.ojtstem.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class Config {
	static Connection con = null;

	public static Connection getCon() {

		try {
			Properties props = getProperties();
			String driver = props.getProperty("jdbc.driver");
			if (driver != null) {
				Class.forName(driver);
			}
			String url = props.getProperty("jdbc.url");
			String username = props.getProperty("jdbc.username");
			String password = props.getProperty("jdbc.password");
			con = DriverManager.getConnection(url, username, password);		
		} catch (Exception e) {
			System.out.println(e);
		}

		return con;
	}

	public static Properties getProperties() throws IOException {
		Properties properties = new Properties();
		URL propertiesURL = Thread.currentThread().getContextClassLoader()
				.getResource(StringUtils.defaultString("db.properties"));
		try (FileInputStream inputStream = new FileInputStream(propertiesURL.getFile())) {
			properties.load(inputStream);
		}
		return properties;
	}
}
