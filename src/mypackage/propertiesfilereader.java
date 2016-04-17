package mypackage;

import java.util.Properties;

public class propertiesfilereader {
	static propertiesfilereader instance = null;
	
	Properties prop = new Properties();
	
	private propertiesfilereader(){
	}
	
	public static propertiesfilereader getInstance(){
		if (instance == null){
			instance = new propertiesfilereader();
		}
		return instance;
	}
	
	public void readProperties(String filename){
		prop.load(propertiesfilereader.class.getResourceAsStream(filename));
				}
	
	public String getProperty(String key){
		return prop.getProperty(key);
	}
}
