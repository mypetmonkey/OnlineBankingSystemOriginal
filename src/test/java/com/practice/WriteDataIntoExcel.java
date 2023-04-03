package com.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/getdatafile.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		  wb.getSheet("Sheet1").getRow(1).createCell(3).setCellValue("PYSPIDERS");
		  FileOutputStream fos=new FileOutputStream("./data/getdatafile.xlsx");
		  wb.write(fos);
		  wb.close();
	}

}
