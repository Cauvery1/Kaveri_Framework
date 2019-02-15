package com.training.functional.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.ProductReturnDataproviders;
import com.training.dataproviders.ProductReturnInvalidDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.DashboardForAdmin_POM;
import com.training.pom.LoginPOM;
import com.training.pom.ProductsReturnPage_POM;
import com.training.pom.UserHomePage_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

/*
 * Author 					: Kaveri Waghmode
 * Test Case ID 			: RTTC_083
 * Test Case Description 	: To verify whether application displays error message upon entering invalid details while returning product
 * Precondition				: 1. user should have launched the application & placed the order
 * 							  2. admin should launch the application by entering valid URL
 * 							  3. Login as admin
 * 							  4. 4. User should have placed order

 *						
 */
public class AdminToReturnMultipleProductsOfCustomerInvalidData_083_Tests {
	
	private WebDriver driver;
	private String baseUrladmin;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private DashboardForAdmin_POM dashboard_POM;
	private ProductsReturnPage_POM prodreturnpage_POM;
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
		prodreturnpage_POM = new ProductsReturnPage_POM(driver); 
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
	

	
	@Test(dataProvider = "excel-inputs", dataProviderClass = ProductReturnInvalidDataProviders.class)
	public void verifyAdminAbleToReturnProducts(String orderid,String customervalue,String firstname,String lastname,String email,String phone,String prod,String model) {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		String Expected = "Administrator";
		String Actual = loginPOM.checkLoggedID();
		assertEquals(Actual,Expected);
		screenShot.captureScreenShot("Dashboard for Administrator");
		dashboard_POM.clickSalesIcon();
		dashboard_POM.returnlink();
		prodreturnpage_POM.clickAddNewProdBtn();
		prodreturnpage_POM.sendReturnIDValues(orderid);
		prodreturnpage_POM.sendCustomerValues(customervalue);
		prodreturnpage_POM.sendFirstName(firstname);
		prodreturnpage_POM.sendLastName(lastname);
		prodreturnpage_POM.sendemail(email);
		prodreturnpage_POM.sendtelephone(phone);
		prodreturnpage_POM.sendProduct(prod);
		prodreturnpage_POM.sendmodelvalue(model);
		prodreturnpage_POM.clickSaveBtn();
		String Expected2 = "Success: You have modified returns!";
		String Actual2=prodreturnpage_POM.checkErrorMsgAfterSaveBtn();
		System.out.println(Actual2);
		boolean flag=Actual2.contains(Expected2);
		System.out.println(flag);
		assertTrue(!flag);
		prodreturnpage_POM.clickCancelBtn();
		prodreturnpage_POM.prodToDelete();
		String Expected1 = "Are you sure?";
		String Actual1=prodreturnpage_POM.deleteProduct();
		assertEquals(Actual,Expected);
		String Expected3 = "Success: You have modified returns!";
		String Actual3=prodreturnpage_POM.checkMsgAfterSaveBtn();
		boolean flag1=Actual3.contains(Expected3);
		assertTrue(!flag1);
		System.out.println(flag1);
	}
}
