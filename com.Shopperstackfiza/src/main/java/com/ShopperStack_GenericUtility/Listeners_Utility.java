package com.ShopperStack_GenericUtility;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners_Utility implements ITestListener,ISuiteListener{
	@Override
	public void onTestFailure(ITestResult result ) {
		TakesScreenshot ts=(TakesScreenshot) Base_Test1.sdriver;
		File temp=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+result.getName()+".png");
		try {
			FileHandler.copy(temp,dest );
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		
	}
}


