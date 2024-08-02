package com.Shopperstack_TestScripts;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.ShopperStackpom.Address_Form_page;
import com.ShopperStackpom.My_Address;
import com.ShopperStackpom.My_Profile;
import com.ShopperStack_GenericUtility.Base_Test1;

public class Verify_user_is_able_to_Add_Address_or_not_Test extends Base_Test1{

  @Test
  public void addAddress() throws EncryptedDocumentException, IOException, InterruptedException {
	 
    homePage.getAccountSettings().click();
    homePage.getMyProfile().click();
    
    My_Profile myProfile =new My_Profile(driver);
    myProfile.getMyAddress().click();
    
    My_Address myAddress =new My_Address(driver);
    myAddress.getAddAddressbtn().click();
    
    Address_Form_page addressForm = new Address_Form_page(driver);
    addressForm.getOfficeTf().click();
    Thread.sleep(1000);
    addressForm.getNameTf().sendKeys(file.readExcelData("Sheet1",1,0));
    Thread.sleep(1000);

    addressForm.getHouseoffice().sendKeys(file.readExcelData("Sheet1",1,1));
    Thread.sleep(1000);

    addressForm.getStreetInfo().sendKeys(file.readExcelData("Sheet1",1,2));
    Thread.sleep(1000);

    addressForm.getLandmarkTf().sendKeys(file.readExcelData("Sheet1",1,3));
    
    addressForm.getCountryDd().sendKeys(file.readPropertyData("country"));
    Thread.sleep(1000);
    addressForm.getStateDd().sendKeys(file.readPropertyData("state"));
    Thread.sleep(1000);
    addressForm.getCityDd().sendKeys(file.readPropertyData("city"));
    Thread.sleep(1000);

    addressForm.getPincodeTf().sendKeys(file.readExcelData("Sheet1",1,4));
    addressForm.getPhoneNumber().sendKeys(file.readExcelData("Sheet1",1,5));
    Thread.sleep(1000);
  
    addressForm.getAddAddress().click();
    
    Thread.sleep(2000);

  }

}
	


