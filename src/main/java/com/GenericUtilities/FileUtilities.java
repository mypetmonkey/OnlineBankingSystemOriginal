package com.GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

import com.GenericUtilities.IPathConstantUtilities.IPathConstants;

public class FileUtilities {
	/**
	 * This method is used to read data from property file
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author rajhans
	 */
	public String getPropertyFileData(String key) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.pFilePath);
		Properties p=new Properties();
		p.load(fis);
		 String value = p.getProperty(key);
		 return value;
	}

}
