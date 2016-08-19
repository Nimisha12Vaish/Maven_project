package resources;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excel_input {
  @Test
  public XSSFSheet readExcel() throws Exception {
	  
	  File src = new File("C:\\Users\\IBM_ADMIN\\Documents\\Selenium\\workbook_data.xlsx");
	  FileInputStream fls = new FileInputStream(src);
	  XSSFWorkbook wb = new XSSFWorkbook(fls);
	  XSSFSheet sh = wb.getSheet("form page data");
	  return sh;
	  
	  
	  
	  
  }
}
