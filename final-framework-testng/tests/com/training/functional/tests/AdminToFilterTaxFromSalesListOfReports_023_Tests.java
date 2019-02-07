package com.training.functional.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;

import com.training.pom.DashboardForAdmin_POM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminToFilterTaxFromSalesListOfReports_023_Tests {
	private WebDriver driver;
	private String baseUrladmin;
	private static Properties properties;
	private ScreenShot screenShot;
	private DashboardForAdmin_POM dashboard_POM;
	private LoginPOM loginPOM;
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	//@BeforeMethod
	@Test(priority=0)
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		dashboard_POM = new DashboardForAdmin_POM(driver); 
		loginPOM = new LoginPOM(driver);
		baseUrladmin = properties.getProperty("baseURLadmin");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrladmin);
	}
	//@AfterMethod
	@Test(priority=3)
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(priority=1)
	public void validLoginTest() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		String Expected = "Administrator";
		String Actual = loginPOM.checkLoggedID();
		assertEquals(Actual,Expected);
		screenShot.captureScreenShot("Dashboard for Administrator");
		Thread.sleep(5000);
	}
	
	@Test(priority=2)
	public void sortTaxFromSalesList() throws InterruptedException {
		dashboard_POM.reportsLink();
		screenShot.captureScreenShot("Reports Menu");
		dashboard_POM.salesLink();
		screenShot.captureScreenShot("Sales Menu");
		String Expected = "Tax Report";
		String Actual = dashboard_POM .taxLink();
		assertEquals(Actual,Expected);
		screenShot.captureScreenShot("TAX Sales report page for tax ");
		dashboard_POM.groupByField();
		screenShot.captureScreenShot("TAX Selected Weeks");
		dashboard_POM.filterBtn();
		screenShot.captureScreenShot("TAX Filtered Tax");
		
		
	}
	

}
