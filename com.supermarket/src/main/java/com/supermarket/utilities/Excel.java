package com.supermarket.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel 
{
	XSSFSheet sheet;
	XSSFWorkbook workbook;
	
	XSSFRow row;
	XSSFCell cell;
	public void setExcelFile(String workBookName,String sheetName)
	{
		try {
			String path=System.getProperty("user.dir")+"//src/main/resources/ExcelFiles/"+ workBookName + ".xlsx";
			File src=new File(path);
			FileInputStream fi=new FileInputStream(src);
			workbook=new XSSFWorkbook(fi);
			sheet=workbook.getSheet(sheetName);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String get_CellData(int rowNo,int columnNo)
	{
		row = sheet.getRow(rowNo);
		cell = row.getCell(columnNo);
		
		switch (cell.getCellType()) {
		case STRING: {
			String x;
			x = cell.getStringCellValue();
			return x;
		}
		case NUMERIC: {
			long d = (long) cell.getNumericCellValue();
			return String.valueOf(d);
		}

		default:
			return null;
			
		}
	}
}
