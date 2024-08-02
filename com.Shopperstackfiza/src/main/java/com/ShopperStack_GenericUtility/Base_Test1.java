package com.ShopperStack_GenericUtility;



import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.ShopperStackpom.Home_Page;
import com.ShopperStackpom.Login_Page;
import com.ShopperStackpom.Welcome_Page;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base_Test1 {
  public ExtentSparkReporter spark; // initialization
  public ExtentReports report;
  public File_Utility file = new File_Utility();
  public WebDriver driver;
  public Welcome_Page welcomePage;
  public Login_Page loginPage;
  public Home_Page homePage;
  public WebDriverWait wait;
  public static WebDriver sdriver;
  public WebDriver_Utility web = new WebDriver_Utility();

  @BeforeSuite
  public void beforeSuite() {
    System.out.println("@BeforeSuite");
  }

  @BeforeTest // path given in Framework_Constants , we used that
  public void beforeTest() {
    System.out.println("@BeforeTest"); // No hard coding
    spark = new ExtentSparkReporter(FrameWork_Constants.reportPath);
    report = new ExtentReports();
    report.attachReporter(spark);
    report.createTest("Demo");
  }

  @BeforeClass // launch browser
  public void beforeClass() throws IOException {
    System.out.println("@BeforeClass");
    String browser = file.readPropertyData("browser"); // propery file : url given
    String Url = file.readPropertyData("Url");
//    System.out.println(browser);
    if (browser.contains("chrome")) { // conditions
      driver = new ChromeDriver();
    }

    else if (browser.contains("firefox")) {
      driver = new FirefoxDriver();
    }

    else if (browser.contains("edge")) {
      driver = new EdgeDriver();
    }

    else {
      System.out.println("Enter valid Browser Name");
    }
    sdriver = driver;
    // assigns the instance of the WebDriver to a static variable sdriver This
    // allows the WebDriver instance to be accessible globally within your framework
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
    driver.get(Url);
    homePage = new Home_Page(driver);

  }

  @BeforeMethod // login
  public void beforeMethod() throws IOException, InterruptedException {
    System.out.println("@BeforeMethod");
    welcomePage = new Welcome_Page(driver); // Welcome_Page
    WebElement ele = welcomePage.getLoginBtn();

    wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    wait.until(ExpectedConditions.elementToBeClickable(ele));
    Thread.sleep(3000);
    ele.click();

    loginPage = new Login_Page(driver);
    
    loginPage.getEmail().sendKeys(file.readPropertyData("Username"));
    loginPage.getPassword().sendKeys(file.readPropertyData("Password"));

    loginPage.getLoginBtn().click();

  }

  @AfterMethod
  public void afterMethod() throws InterruptedException { // logout
    System.out.println("@AfterMethod");
    Thread.sleep(3000);
//    WebElement element = homePage.getAccountSettings();
//    wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//    wait.until(ExpectedConditions.elementToBeClickable(element));
//    element.click();
    Thread.sleep(5000);
    homePage.getAccountSettings().click();
    homePage.getLogout().click();
  }

  @AfterClass
  public void afterClass() throws InterruptedException { // browser closing
    System.out.println("@AfterClass");
    Thread.sleep(3000);
    driver.quit();
  }

  @AfterTest
  public void afterTest() {
    System.out.println("@AfterTest");
    report.flush();
  }

}
				