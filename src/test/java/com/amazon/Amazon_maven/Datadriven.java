package com.amazon.Amazon_maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;



public class Datadriven {
	static String value;
	public static String allData(String sheet,int rowNo, int cellNo) throws IOException {
		File f=new File("C:\\Users\\puvana\\Documents\\Puviiw.xlsx");
		FileInputStream ft=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(ft);
		Sheet s=w.getSheet(sheet);
		Row r=s.getRow(rowNo);
		 Cell c = r.getCell(cellNo);
		 CellType cell=c.getCellType();
		 if(cell.equals(CellType.STRING)) {
			 value=c.getStringCellValue();
			 }else if(cell.equals(CellType.NUMERIC)) {
				 double num=c.getNumericCellValue();
				 int p=(int) num;
				 value=String.valueOf(p);
			 }   
		    
		
		return value;
		
		
				
	}
	public static void main(String[] args) throws IOException {
		allData(value, 0, 0);
	}

}
