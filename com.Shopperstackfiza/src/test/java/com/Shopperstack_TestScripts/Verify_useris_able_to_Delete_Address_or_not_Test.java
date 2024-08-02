package com.Shopperstack_TestScripts;

import org.testng.annotations.Test;

import com.ShopperStack_GenericUtility.Base_Test1;
import com.ShopperStackpom.My_Profile;

import com.ShopperStackpom.My_Address;

public class Verify_useris_able_to_Delete_Address_or_not_Test extends Base_Test1 {
	
	@Test
	public void deleteAddress() throws InterruptedException {
		homePage.getAccountSettings().click();;
		homePage.getMyProfile().click();
		
		My_Profile myprofilee=new My_Profile(driver);
		myprofilee.getMyAddress().click();;
		
		My_Address myAddress=new My_Address(driver);
		Thread.sleep(1000);
		myAddress.getDeleteBtn().click();
		Thread.sleep(1000);
		myAddress.getYesBtn().click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}

}
