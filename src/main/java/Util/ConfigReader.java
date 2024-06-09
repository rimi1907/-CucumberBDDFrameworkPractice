package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class ConfigReader
{
	
	static Properties prop = new Properties(); //create object of properties file
public static String getPropertValueByKey(String Key) throws Exception
{
	//load data from properties file using prop object
	//location of the file
	String PropFilePath = System.getProperty("user.dir")+"/src/test/resources/config/config.properties";
	FileInputStream fis = null;
	try {
		fis = new FileInputStream(PropFilePath);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		prop.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//read data
	
	String value =prop.get(Key).toString();
	if(StringUtils.isEmpty(value))  //StringUtils check both empty and null
	{
		throw new Exception("Value  is not specified  for key:" + Key+ "in Properties file");
	}
	return value;
}
}
