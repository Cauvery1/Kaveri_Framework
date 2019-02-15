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

//import com.training.dataproviders.OrdersDataproviders;
import com.training.dataproviders.ProductReturnDataproviders;
import com.training.generics.ScreenShot;
import com.training.pom.DashboardForAdmin_POM;
import com.training.pom.LoginPOM;
import com.training.pom.OrderPage_POM;
import com.training.pom.ProductsReturnPage_POM;
import com.training.pom.UserHomePage_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

/*
 * Author 					: Kaveri Waghmode
 * Test Case ID 			: RTTC_082
 * Test Case Description 	: To verify whether application allows admin to return multiple product of customer & delete from return list
 * Precondition				: 1. user should have launched the application & placed the order
 * 							  2.admin should launch the application by entering valid URL
 * 							  3. Login as admin

 *						
 */
public class AdminToReturnMultipleProductOfCustomerAndDeleteFromReturnList_082_Tests {
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
	

	
	@Test(dataProvider = "excel-inputs", dataProviderClass = ProductReturnDataproviders.class)
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
		String Actual2=prodreturnpage_POM.checkMsgAfterSaveBtn();
		boolean flag=Actual2.contains(Expected2);
		assertTrue(flag);
		prodreturnpage_POM.prodToDelete();
		String Expected1 = "Are you sure?";
		String Actual1=prodreturnpage_POM.deleteProduct();
		assertEquals(Actual,Expected);
		String Expected3 = "Success: You have modified returns!";
		String Actual3=prodreturnpage_POM.checkMsgAfterSaveBtn();
		boolean flag1=Actual3.contains(Expected3);
		assertTrue(flag1);
	}
	

}
