package com.practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadDataFromExcel {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/getdatafile.xlsx");
	   Workbook wb = WorkbookFactory.create(fis);
	  String data = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
	  System.out.println(data);
	  
	}

}
