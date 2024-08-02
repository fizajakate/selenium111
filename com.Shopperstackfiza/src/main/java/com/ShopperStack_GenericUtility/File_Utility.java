package com.ShopperStack_GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class File_Utility {
	
	public String readPropertyData(String key) throws IOException{
		FileInputStream fis =  new FileInputStream(FrameWork_Constants.propertyPath);		//External File -> Property ->read
		Properties pro = new Properties();													
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
		
	}
	
	public String readExcelData (String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis =  new FileInputStream(FrameWork_Constants.excelPath);				//External File -> Excel ->read
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
	}

}


