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

import com.training.dataproviders.OrdersDataproviders;
import com.training.generics.ScreenShot;
import com.training.pom.DashboardForAdmin_POM;
import com.training.pom.LoginPOM;
import com.training.pom.ProductsReturnPage_POM;
import com.training.pom.UserHomePage_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

/*
 * Author 					: Kaveri Waghmode
 * Test Case ID 			: RTTC_081
 * Test Case Description 	: To verify whether application allows admin to return product of customer & delete from return list & same get displayed in database
 * Precondition				: 1. user should have launched the application & placed the order
 * 							  2. admin should launch the application by entering valid URL
 * 							  3. Login as admin
 * 							  4. User should have placed order
 * 							  

 *						
 */
public class AdminToReturnProductsOfCustomerAndDeleteFromDatabase_081_Tests {
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
	

	
	@Test(dataProvider = "db-inputs", dataProviderClass = OrdersDataproviders.class)
	public void verifyAdminAbleToReturnProductsAndDelete(String orderid,String customervalue,String firstname,String lastname,String email,String phone,String prod,String model) {
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
		String orderid_var=prodreturnpage_POM.returnOrderid();
		assertEquals(orderid,orderid_var);
		prodreturnpage_POM.sendCustomerValues(customervalue);
		String customervalue_var=prodreturnpage_POM.returnCustomerValues();
		assertEquals(customervalue,customervalue_var);
		prodreturnpage_POM.sendFirstName(firstname);
		String firstname_var=prodreturnpage_POM.returnFirstName();
		assertEquals(firstname,firstname_var);
		prodreturnpage_POM.sendLastName(lastname);
		String lastname_var=prodreturnpage_POM.returnLastName();
		assertEquals(lastname,lastname_var);
		prodreturnpage_POM.sendemail(email);
		String email_var=prodreturnpage_POM.returnEmail();
		assertEquals(email,email_var);
		prodreturnpage_POM.sendtelephone(phone);
		String phone_var=prodreturnpage_POM.returnPhone();
		assertEquals(phone,phone_var);
		prodreturnpage_POM.sendProduct(prod);
		String prod_var=prodreturnpage_POM.returnProduct();
		assertEquals(prod,prod_var);
		prodreturnpage_POM.sendmodelvalue(model);
		String model_var=prodreturnpage_POM.returnModel();
		assertEquals(model,model_var);
		prodreturnpage_POM.clickSaveBtn();
		String Expected2 = "Success: You have modified returns!";
		String Actual2=prodreturnpage_POM.checkMsgAfterSaveBtn();
		boolean flag=Actual2.contains(Expected2);
		assertTrue(flag);
		prodreturnpage_POM.prodToDelete();
		prodreturnpage_POM.deleteProduct();
		String Expected3 = "Success: You have modified returns!";
		String Actual3=prodreturnpage_POM.checkMsgAfterSaveBtn();
		boolean flag1=Actual3.contains(Expected3);
		assertTrue(flag1);
	}

}
