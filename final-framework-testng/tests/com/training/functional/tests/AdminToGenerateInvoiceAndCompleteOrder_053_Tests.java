package com.training.functional.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.DashboardForAdmin_POM;
import com.training.pom.LoginPOM;
import com.training.pom.OrderPage_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminToGenerateInvoiceAndCompleteOrder_053_Tests {
	private WebDriver driver;
	private String baseUrladmin1;
	private static Properties properties;
	private ScreenShot screenShot;
	private DashboardForAdmin_POM dashboard_POM;
	private LoginPOM loginPOM;
	private OrderPage_POM orderpage_POM;
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@Test(priority = 0)
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		dashboard_POM = new DashboardForAdmin_POM(driver); 
		loginPOM = new LoginPOM(driver);
		orderpage_POM = new OrderPage_POM(driver);
		baseUrladmin1 = properties.getProperty("baseURLadmin1");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrladmin1);
	}
	
	@Test(priority = 3)
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(priority = 1)
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
	
	@Test(priority = 2)
	public void generateInvoiceAndChangeStatus() throws InterruptedException {
		dashboard_POM.clickViewIcon();
		String Expected = "Orders";
		String Actual = orderpage_POM.checkOrderPageTitle();
		assertEquals(Actual,Expected);
		screenShot.captureScreenShot("Orders Page");
		orderpage_POM.clickInvoiceBtn();
		orderpage_POM.clickOrderStatus("Complete");
		String Expected1 = "Success: You have modified orders!";
		String Actual1 =orderpage_POM.clickAddHistoryBtn();
		boolean flag=Actual1.contains(Expected1);
		assertTrue(flag);
		screenShot.captureScreenShot("Edited Orders Page");
	}

}
