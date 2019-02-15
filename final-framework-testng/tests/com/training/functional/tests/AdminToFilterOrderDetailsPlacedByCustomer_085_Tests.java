package com.training.functional.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.dataproviders.OrdersDataproviders;
import com.training.generics.ScreenShot;
import com.training.pom.DashboardForAdmin_POM;
import com.training.pom.LoginPOM;
import com.training.pom.OrderPage_POM;
import com.training.pom.ProductsPage_POM;
import com.training.pom.UserHomePage_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

/*
 * Author 					: Kaveri Waghmode
 * Test Case ID 			: RTTC_085
 * Test Case Description 	: To Verify whether application allows admin to filter details of order placed by the user
 * Precondition				: 1. user should have launched the application & placed the order
 * 							  2. admin should launch the application by entering valid URL
 * 							  3. Login as admin

 *						
 */
public class AdminToFilterOrderDetailsPlacedByCustomer_085_Tests {
	private WebDriver driver;
	private String baseUrladmin;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private DashboardForAdmin_POM dashboard_POM;
	private OrderPage_POM orderpage_POM;
	private LoginPOM loginPOM;
	private UserHomePage_POM userHomePage_POM;
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		dashboard_POM = new DashboardForAdmin_POM(driver); 
		orderpage_POM = new OrderPage_POM(driver); 
		loginPOM = new LoginPOM(driver);
		baseUrladmin = properties.getProperty("baseURLadmin1");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrladmin);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	

	
	@Test(dataProvider = "excel-inputs", dataProviderClass = OrdersDataproviders.class)
	public void verifyProductIsAdded(String order_id, String orderstatus,String dateadded,String customervalue,String totalvalue,String datemodified) throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		String Expected = "Administrator";
		String Actual = loginPOM.checkLoggedID();
		assertEquals(Actual,Expected);
		screenShot.captureScreenShot("Dashboard for Administrator");
		//Thread.sleep(3000);
		dashboard_POM.clickSalesIcon();
		dashboard_POM.orderLink();
		orderpage_POM.sendOrderID(order_id);
		orderpage_POM.clickOrderStatus(orderstatus);
		orderpage_POM.sendDateAdded(dateadded);
		orderpage_POM.sendCustomerValue(customervalue);
		orderpage_POM.sendTotalValue(totalvalue);
		orderpage_POM.sendDateModified(datemodified);
		orderpage_POM.clickFilterBtn();
	}
	

}
