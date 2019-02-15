package com.training.functional.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ProductsPage_POM;
import com.training.pom.DashboardForAdmin_POM;
import com.training.pom.LoginPOM;
import com.training.pom.UserHomePage_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
/*
 * Author 					: Kaveri Waghmode
 * Test Case ID 			: RTTC_084
 * Test Case Description 	: To Verify whether added product details get displayed in home screen
 * Precondition				: 1. admin should launch the application by entering valid URL
 * 							  2. Login as admin
 * 							  

 *						
 */
public class VerifyAddedProductDisplayedInHomeScreen_084_Tests {
	private WebDriver driver;
	private String baseUrladmin;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private DashboardForAdmin_POM dashboard_POM;
	private ProductsPage_POM ProductsPage_POM;
	private LoginPOM loginPOM;
	private UserHomePage_POM userHomePage_POM;
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
		ProductsPage_POM = new ProductsPage_POM(driver); 
		loginPOM = new LoginPOM(driver);
		baseUrladmin = properties.getProperty("baseURLadmin1");
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
	public void verifyProductIsAdded() throws InterruptedException {
		
		dashboard_POM.clickCatelogLink();
		dashboard_POM.clickProductsLinks();
		ProductsPage_POM.clickAddNewProductBtn();
		ProductsPage_POM.sendProductName("MRF BAT");
		ProductsPage_POM.sendMetaTagTitle("Cricket Bat");
		ProductsPage_POM.clickDataTab();
		//screenShot.captureScreenShot("");
		ProductsPage_POM.sendModelInDataTab("SKU-012");
		ProductsPage_POM.sendPriceInDataTab("500");
		ProductsPage_POM.sendQuantityInDataTab("50");
		ProductsPage_POM.clickLinksTab();
		ProductsPage_POM.sendCategoryText("Sports");
		//ProductsPage_POM.clickCategoriesInLinksTab("Sports");
		screenShot.captureScreenShot("Category selected");
		ProductsPage_POM.clickSaveBtnAfterAddingProduct();
		String Expected = "Success: You have modified products!";
		String Actual = ProductsPage_POM.checkMessageAfterSavingProduct();
		boolean flag = Actual.contains(Expected);
		assertTrue(flag);
		ProductsPage_POM.clickLogoutBtn();
			
	}
	
	@Test(priority = 4)
	public void setUpForUser() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		userHomePage_POM = new UserHomePage_POM(driver); 
		baseUrl = properties.getProperty("baseURL1");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}
	
	@Test(priority = 5)
	public void verifyAddedProductIsDisplayedInHomeScreen() throws InterruptedException, AWTException {
		
		userHomePage_POM.clickShopNowBtn("Earrings");
		userHomePage_POM.clickSearchBtn();
		userHomePage_POM.sendTextInSearchField("MRF BAT");
		screenShot.captureScreenShot("Product dteails displayed part-1");
		//Robot robot = new Robot();
		//robot.keyPress(KeyEvent.VK_DOWN);
		//robot.keyPress(KeyEvent.VK_DOWN);
		//screenShot.captureScreenShot("Product dteails displayed part-2");
	}
	
	@Test(priority = 6)
	public void tearDownForUser() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
}
