package com.property;

import java.io.IOException;

public class ConfigurationHelperA {
	public static ConfigurationReaderA getInstance() throws IOException {
		ConfigurationReaderA cr=new ConfigurationReaderA();
		return cr;
	} 
	private ConfigurationHelperA() {
		
	}
}
