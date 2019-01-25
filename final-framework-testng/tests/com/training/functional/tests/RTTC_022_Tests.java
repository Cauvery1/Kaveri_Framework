package com.training.functional.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTTC_022_POM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_022_Tests {
	private WebDriver driver;
	private String baseUrladmin;
	private static Properties properties;
	private ScreenShot screenShot;
	private RTTC_022_POM test_022_POM;
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
		test_022_POM = new RTTC_022_POM(driver); 
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
		Thread.sleep(3000);
		
	}
	
	@Test(priority=2)
	public void sortOrdersFromSalesList() throws InterruptedException {
		test_022_POM.reportsLink();
		screenShot.captureScreenShot("Reports Menu");
		test_022_POM.salesLink();
		screenShot.captureScreenShot("Sales Menu");
		String Expected = "Sales Report";
		String Actual = test_022_POM.ordersLink();
		assertEquals(Actual,Expected);
		screenShot.captureScreenShot("ORDERS Sales report page for orders ");
		test_022_POM.groupByField();
		screenShot.captureScreenShot("ORDERS Selecled Weeks");
		test_022_POM.filterBtn();
		screenShot.captureScreenShot("ORDERS Filtered Orders");
		
		
	}
	
	

}
