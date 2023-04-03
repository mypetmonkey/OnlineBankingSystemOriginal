package com.practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDatafromExcel {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/getdatafile.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");
	int count=sh.getLastRowNum();
	for(int i=0;i<=count;i++) {
		Cell org = sh.getRow(i).getCell(0);
		  Cell st = sh.getRow(i).getCell(1);
		  System.out.println(org+"    "+st);
	}
		
	}

}
 