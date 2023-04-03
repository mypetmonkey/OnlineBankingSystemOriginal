package com.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class WrieMltipleDataExcelList {
	public static void main(String[] args) throws Throwable{
		FileInputStream fis=new FileInputStream("./data/getdatafile.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	    Sheet sh = wb.getSheet("Sheet1");
		for(int i=0;i<=sh.getLastRowNum();i++) {
			List<String> l=Arrays.asList("kundan","kumar","dunu","rahul","misti");
			sh.getRow(i).createCell(6).setCellValue(l.get(i));
			
			FileOutputStream fos=new FileOutputStream("./data/getdatafile.xlsx");
			wb.write(fos);

			
		}
		wb.close();
			} 

}
