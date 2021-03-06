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
import com.training.pom.CustomerPage_POM;
import com.training.pom.DashboardForAdmin_POM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminAccessToDeleteCust_021_Tests {
	private WebDriver driver;
	private String baseUrladmin;
	private static Properties properties;
	private ScreenShot screenShot;
	private DashboardForAdmin_POM dashboard_POM;
	private CustomerPage_POM customerpage_POM;
	private LoginPOM loginPOM;
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
		customerpage_POM = new CustomerPage_POM(driver); 
		loginPOM = new LoginPOM(driver);
		baseUrladmin = properties.getProperty("baseURLadmin");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrladmin);
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
	public void deleteCustomerDetailsFromCustomerList() throws InterruptedException {
		dashboard_POM.clickCustomerIcon();		
		screenShot.captureScreenShot("CustomerMenu");
		dashboard_POM.clickCustomersLink();
		String Expected1 = "Customers";
		String Actual1 = customerpage_POM.checkCustomersPage();
		assertEquals(Actual1,Expected1);
		screenShot.captureScreenShot("CustomersPage");
		customerpage_POM.mailIdCheck("admin@gmail.com");
		Thread.sleep(3000);
		screenShot.captureScreenShot("Selected customer to delete");
		String Expected2 = "Success: You have modified customers!";
		String Actual2=customerpage_POM.deleteCustomer();
		boolean flag=Actual2.contains(Expected2);
		assertTrue(flag);
		screenShot.captureScreenShot("Success Message");
		Thread.sleep(3000);
		
	}
	
	
}
