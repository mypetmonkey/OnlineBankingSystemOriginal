package com.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteMultipledataIntoExcel {
	public static void main(String[] args) throws Throwable {
		//FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\New Microsoft Excel Worksheet.xlsx");
		Workbook wb = WorkbookFactory.create(new FileInputStream("./data/getdatafile.xlsx"));
		Sheet sh = wb.getSheet("Sheet1");
		for(int i=0;i<=sh.getLastRowNum();i++) {
		//	ArrayList<String> al=(ArrayList<String>) Arrays.asList("raju","nasir","vivek","kundan","chandan);
			String st[]= {"raju","nasir","vivek","kundan","chandan","guru"};
			 sh.getRow(i).createCell(4).setCellValue(st[i]); 
			 FileOutputStream fos=new FileOutputStream("./data/getdatafile.xlsx");
				wb.write(fos);
		}
		
		wb.close();
	}

}
