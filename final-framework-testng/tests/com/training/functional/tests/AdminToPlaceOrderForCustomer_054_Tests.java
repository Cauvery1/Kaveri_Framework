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

public class AdminToPlaceOrderForCustomer_054_Tests {
	private WebDriver driver;
	private String baseUrladmin1;
	private static Properties properties;
	private ScreenShot screenShot;
	private OrderPage_POM orderpage_POM;
	private LoginPOM loginPOM;
	private DashboardForAdmin_POM dashboard_POM;
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@Test(priority = 0)
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		orderpage_POM = new OrderPage_POM(driver); 
		loginPOM = new LoginPOM(driver);
		dashboard_POM = new DashboardForAdmin_POM(driver);
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
	public void verifyAdminToPlaceOrderForCustomer() throws InterruptedException {
		dashboard_POM.clickSalesIcon();
		//dashboard_POM.salesLink();
		dashboard_POM.clickOrdersFromSalesIcon();
		screenShot.captureScreenShot("Orders Page is displayed");
		String Expected = "Add Order";
		String Actual = orderpage_POM.clickAddNewBtn();
		assertEquals(Actual,Expected);
		screenShot.captureScreenShot("Add Order page");
		orderpage_POM.sendFirstAndLastName("manzoor","mehadi");
		orderpage_POM.sendEmail("manzoor@gmail.com");
		orderpage_POM.sendTelephone("9876543210");
		String Expected1= "2. Products";
		String Actual1 = orderpage_POM.clickContinueBtnFromCustomerDetails();
		assertEquals(Actual1,Expected1);
		screenShot.captureScreenShot("Products tab open");
		orderpage_POM.sendChooseProduct("Lorem ipsum dolor sit amet");
		orderpage_POM.sendQuantity("1");
		orderpage_POM.clickAddProductBtn();
		screenShot.captureScreenShot("Added product visible in Products tab");
	    //orderpage_POM.clickContinueBtnFromProducts();
		String Expected3= "3. Payment Details";
		String Actual3 = orderpage_POM.clickContinueBtnFromProducts();
		assertEquals(Actual3,Expected3);
		screenShot.captureScreenShot("Payment Details tab open");
		orderpage_POM.sendFirstAndLastNameINPaymentTab("manzoor","mehadi");
		orderpage_POM.sendAddress1INPaymentTab("Yeswanthapur");
		orderpage_POM.sendAddress2INPaymentTab("bangalore");
		orderpage_POM.sendCityINPaymentTab("bangalore");
		orderpage_POM.sendPostcodeINPaymentTab("560022");
		orderpage_POM.sendCountryINPaymentTab("India");
		orderpage_POM.sendRegionINPaymentTab("Karnataka");
		orderpage_POM.clickContinueBtnFromPaymentTab();
		String Expected4= "4. Shipping Details";
		String Actual4 = orderpage_POM.clickContinueBtnFromPaymentTab();
		assertEquals(Actual4,Expected4);
		System.out.println("check");
		screenShot.captureScreenShot("Shipping Details tab open");
		orderpage_POM.sendFirstAndLastName("manzoor","mehadi");
		orderpage_POM.sendAddress1INShippingDetailsTab("Yeswanthapur");
		orderpage_POM.sendAddress2INShippingDetailsTab("bangalore");
		orderpage_POM.sendCityINShippingDetailsTab("bangalore");
		orderpage_POM.sendPostcodeINShippingDetailsTab("560022");
		orderpage_POM.sendCountryINShippingDetailsTab("India");
		orderpage_POM.sendRegionINShippingDetailsTab("Karnataka");
		System.out.println("check");
		orderpage_POM.clickContinueBtnFromShippingDetailsTab();
		System.out.println("check");
		//orderpage_POM.sendPaymentMethod("Cash On Delivery");
		System.out.println("check");
		//orderpage_POM.sendShippingMethod("Free Shipping - Rs.0");
		//orderpage_POM.clickFinalSave();
		//orderpage_POM.clickFinalSave();
		screenShot.captureScreenShot("Order placed");
	}
	

}
