package com.happydesk.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileHelper {
	
	//by SA. Code to create folders and give path to save uploaded file.
	public static String getPathFromId(Integer id)
	{
		int f1 = (id & 0xFF000000) >> 24;
		int f2 = (id & 0x00FF0000) >> 16;
		int f3 = (id & 0x0000FF00) >> 8;
		StringBuilder builder = new StringBuilder("");
		builder.append(f1);
		builder.append("/");
		builder.append(f2);
		builder.append("/");
		builder.append(f3);
		return builder.toString();
	}
	
	public static Iterator<Row>  ReadExcelFile(File file , String fileExtention) {
		try {
			Iterator<Row> rowIterator  =null;
			FileInputStream fileInputStream = new FileInputStream(file);
			if(fileExtention.equalsIgnoreCase("xls")) {
			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);//Get the workbook instance for XLS file 
			HSSFSheet sheet = workbook.getSheetAt(0);//Get first sheet from the workbook
			 rowIterator = sheet.iterator();
			}else {
			XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
			XSSFSheet sheet   = wb.getSheetAt(0);
			 rowIterator = sheet.iterator();
			}
			return rowIterator;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
}
