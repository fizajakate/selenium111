package com.ShopperStackpom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class My_Profile {
  
  public My_Profile(WebDriver driver) {
    PageFactory.initElements(driver, this);  
}

  @FindBy(xpath = "//div[text()='My Addresses']")
  private WebElement myAddress;

  public WebElement getMyAddress() {
    return myAddress;
  }
  
  
  

}
