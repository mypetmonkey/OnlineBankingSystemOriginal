package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.GenericUtilities.IPathConstantUtilities.IPathConstants;

public class ExcelUtilities {
	
	
	/**
	 * This method is used to read the data from excel file
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return data
	 * @throws Throwable
	 * @author rajhans
	 */
	public String readExcelData(String sheetname,int row,int cell) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		 String data = wb.getSheet(sheetname).getRow(row).getCell(cell).toString();
		return data;
	}
	
	/**
	 * This method is used to get the last row number
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @param value
	 * @throws Throwable
	 * @author rajhans
	 */
	
	public int getLastRowNum(String sheetname) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstants.excelPath) ;
		Workbook wb = WorkbookFactory.create(fis);	
		Sheet sh = wb.getSheet(sheetname);
	    int count=sh. getLastRowNum();
	    return count;
		
	}
	/**
	 * This method is used to write data into excel file
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @param value
	 * @throws Throwable
	 * @author rajhans
	 */
   public void writeDataIntoExcel(String sheetname,int row,int cell,String value) throws Throwable {
	   FileInputStream fis=new FileInputStream(IPathConstants.excelPath) ;
		Workbook wb = WorkbookFactory.create(fis);	
		Sheet sh = wb.getSheet(sheetname);
		sh.getRow(row).createCell(cell).setCellValue(value);
		FileOutputStream fos=new FileOutputStream(IPathConstants.excelPath);
		wb.write(fos);
		
   }
   /**
    * This method is used to read multiple data from excel file
    * @param sheetname
    * @throws Throwable
    * @author rajhans
    */
   public void readMultipleDataFromExcel(WebDriver driver, String sheetname) throws Throwable {
	   FileInputStream fis=new FileInputStream(IPathConstants.excelPath) ;
		Workbook wb = WorkbookFactory.create(fis);	
		Sheet sh = wb.getSheet(sheetname);
	   int count=sh.getLastRowNum();
	   HashMap<String,String> hm=new HashMap<String,String>();
	   for(int i=0;i<=count;i++) {
		   String key=sh.getRow(i).getCell(0).toString();
		   String value=sh.getRow(i).getCell(1).toString();
		   hm.put(key, value);
	   }
	   for(Entry<String, String> set:hm.entrySet()) {
			
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
        }
   }
   
   
   
   public void writeMultipleDataIntoExcel(String sheetname,int cell,ArrayList<String> values) throws Throwable {
	   FileInputStream fis=new FileInputStream(IPathConstants.excelPath) ;
		Workbook wb = WorkbookFactory.create(fis);	
		Sheet sh = wb.getSheet(sheetname);
		int count=sh.getLastRowNum();
		for(int i=0;i<=count;i++) {
			@SuppressWarnings("unchecked")
			List<ArrayList<String>> l=Arrays.asList(values);
			sh.getRow(i).createCell(cell).setCellValue((RichTextString) l.get(i));

			FileOutputStream fos=new FileOutputStream("./data/getdatafile.xlsx");
			wb.write(fos);
			wb.close();
		}
   }
   
   
   
   
   public Object[][] readMultipleSetofData() throws Throwable {
	   FileInputStream fis=new FileInputStream(IPathConstants.excelPath);
	  Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("DP");
	int lastrow = sh.getLastRowNum()+1;
	int lastcell = sh.getRow(0).getLastCellNum();
	Object [][]obj=new Object[lastrow][lastcell];
	  
	for(int i=0;i<lastrow;i++) {
		for(int j=0;j<lastcell;j++) {
			obj[i][j]=sh.getRow(i).getCell(j).toString();
		}
	}
	return obj;
	
   }
   
}
