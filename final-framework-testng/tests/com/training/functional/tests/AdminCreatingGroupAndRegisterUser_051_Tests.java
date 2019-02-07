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
import com.training.pom.CustomerGroupPage_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminCreatingGroupAndRegisterUser_051_Tests {
	
	private WebDriver driver;
	private String baseUrladmin1;
	private static Properties properties;
	private ScreenShot screenShot;
	private DashboardForAdmin_POM dashboard_POM;
	private CustomerGroupPage_POM customergrouppage_POM;
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
		customergrouppage_POM = new CustomerGroupPage_POM(driver);
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
	public void creatingGroupAndRegisterNewUser() throws InterruptedException {
		dashboard_POM.clickCustomerIcon();		
		screenShot.captureScreenShot("CustomerMenu");
		dashboard_POM.clickCustomerGroupsLink();	
		String Expected = "Customer Groups";
		String Actual = dashboard_POM.checkCustomerGroupspage();
		assertEquals(Actual,Expected);
		screenShot.captureScreenShot("Customer Groups Page");
		customergrouppage_POM.clickaddNewBtn();
		customergrouppage_POM.sendCustomerGroupName("privileged customer");
		customergrouppage_POM.sendCustomerDescirption("privileged customer");
		customergrouppage_POM.clickRadioBtn();
		//customergrouppage_POM.clickSave();
		String Expected1 = "Success: You have modified customer groups!";
		String Actual1 =customergrouppage_POM.clickSave();
		boolean flag=Actual1.contains(Expected1);
		screenShot.captureScreenShot("Message displayed");
		//customergrouppage_POM.clickCustomerLink();
		customergrouppage_POM.clickCustomersLink1();
		String Expected2 = "Add Customer";
		String Actual2 = customergrouppage_POM.clickAddUserBtn();
		assertEquals(Actual2,Expected2);
		screenShot.captureScreenShot("Add Customer Page");
		customergrouppage_POM.sendCustomerGroupFeild("privileged customer");
		customergrouppage_POM.sendFirstLastName("manzoor","mehadi");
		customergrouppage_POM.sendemailField("manzoor@gmail.com");
		customergrouppage_POM.sendtelephoneField("9876543210");
		customergrouppage_POM.sendPasswordAndConfirmPassword("manzoor1");
		customergrouppage_POM.clickAddressBtn();
		customergrouppage_POM.sendFirstLastName1("manzoor","mehadi");
		customergrouppage_POM.sendAddressField1("yeswanthpur");
		customergrouppage_POM.sendAddressField2("bangalore");
		customergrouppage_POM.sendCity("bangalore");
		customergrouppage_POM.sendPostcode("560022");
		customergrouppage_POM.sendCountry("India");
		customergrouppage_POM.sendRegion("Karnataka");
		
		String Expected3 = "Success: You have modified customers!";
		String Actual3 =customergrouppage_POM.clickSaveAfterAddingAddress();
		boolean flag1=Actual3.contains(Expected3);
		screenShot.captureScreenShot("Added Customer message");
		
	}

}
