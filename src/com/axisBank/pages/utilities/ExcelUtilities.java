package com.axisBank.pages.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
	
	public static void setCellData(String Path,String SheetName,String cellValueToBeSet) throws Exception 
	{
		File file=new File("");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet(SheetName);
		sheet.createRow(0).createCell(0).setCellValue(cellValueToBeSet);
		wb.write(new FileOutputStream(file));
		wb.close();
				
	}
	public static String getCellData(int RowNum, int ColNum) throws Exception
	{
		File file=new File("C:\\Users\\aparna chowdary\\Desktop\\Sample.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		String cellValue=sheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
		return cellValue;
	}
	
}
