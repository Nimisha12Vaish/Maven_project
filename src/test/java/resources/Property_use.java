package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Property_use {
  @Test
  public Properties property() {
	  
	  File file = new File("C:\\Users\\IBM_ADMIN\\git\\Maven_project\\src\\test\\java\\property_files\\Property_file.properties");
	  FileInputStream fileinput = null;
	  try
	  {
	   fileinput = new FileInputStream(file);
	  }
	  catch(FileNotFoundException e)
	  {
		  System.out.println(e);
	  }
	  Properties prop2 = new Properties();
	  try{
	  prop2.load(fileinput);
	  }
	  catch(IOException e)
	  {
		  System.out.println(e);
	  }
	  return prop2;
  }
}
