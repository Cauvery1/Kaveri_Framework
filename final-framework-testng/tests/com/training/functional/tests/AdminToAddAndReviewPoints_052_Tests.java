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

public class AdminToAddAndReviewPoints_052_Tests {
	private WebDriver driver;
	private String baseUrladmin1;
	private static Properties properties;
	private ScreenShot screenShot;
	private CustomerPage_POM customerpage_POM;
	private DashboardForAdmin_POM dashboard_POM;
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
		customerpage_POM = new CustomerPage_POM(driver); 
		dashboard_POM = new DashboardForAdmin_POM(driver);
		loginPOM = new LoginPOM(driver);
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
	public void addRewardPointsToCustomerAndViewInReportsSection() throws InterruptedException {
		dashboard_POM.clickCustomerIcon();
		dashboard_POM.clickCustomersLink();
        String Expected = "Edit Customer";
		String Actual = customerpage_POM.clickCustomerEditIcon();
		assertEquals(Actual,Expected);
		screenShot.captureScreenShot("Edit Customer Page");
		customerpage_POM.clickAddressField1();
		customerpage_POM.sendFirstName("Asmita");
		screenShot.captureScreenShot("Edited first name field");
		customerpage_POM.sendPostcode("8796545");
		customerpage_POM.clickRewardsTab();
		screenShot.captureScreenShot("Rewards points Page");
		customerpage_POM.sendRewardDescription("review");
		customerpage_POM.sendRewardPoints("50");
		String Expected1 = "Success: You have modified customers!";
		String Actual1 =customerpage_POM.clickAddRewardPointsBtn();
		boolean flag=Actual1.contains(Expected1);
		assertTrue(flag);
		String Expected2 = "Success: You have modified customers!";
		String Actual2 =customerpage_POM.clickSaveAfterEditngAddressFields();
		boolean flag1=Actual2.contains(Expected2);
		customerpage_POM.clickReoprtsLink();
		screenShot.captureScreenShot("Reports Link clicked options displayed");
		customerpage_POM.clickCustomersFromReportsLink();
		screenShot.captureScreenShot("Customers Link from reports clicked and options displayed");
		String Expected3 = "Customer Reward Points Report";
		String Actual3 = customerpage_POM.clickRewardpointsFromCustomersLink();
		assertEquals(Actual3,Expected3);
		screenShot.captureScreenShot("Final Page Reward points displayed");
	}
}
