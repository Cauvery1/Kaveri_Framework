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
import com.training.pom.ManufacturerPage_POM;
import com.training.pom.ProductsPage_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminToCreateManufacturerAndAddProduct_055_Tests {
	private WebDriver driver;
	private String baseUrladmin1;
	private static Properties properties;
	private ScreenShot screenShot;
	private DashboardForAdmin_POM dashboard_POM;
	private ManufacturerPage_POM manufacturerpage_POM;
	private LoginPOM loginPOM;
	private ProductsPage_POM productpage_POM;
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
		manufacturerpage_POM = new ManufacturerPage_POM(driver);
		loginPOM = new LoginPOM(driver);
		productpage_POM = new ProductsPage_POM(driver);
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
	public void createManuFacturerDetailsAndAddProducts() throws InterruptedException {
		dashboard_POM.clickCatelogLink();
		screenShot.captureScreenShot("Catelog Options displayed");
		dashboard_POM.clickManufacturersLink();
		//assertEquals(Actual,Expected);
		//test_055_POM.clickManufacturersLink();
		manufacturerpage_POM.clickAddManufacturerBtn();
		manufacturerpage_POM.sendManufacturerName("manzoor");
		String Expected1 = "Success: You have modified manufacturers!";
		String Actual1 =manufacturerpage_POM.clickSaveManufacturerBtn();
		boolean flag = Actual1.contains(Expected1);
		assertTrue(flag);
		screenShot.captureScreenShot("Manufacturer Added");
		//screenShot.captureScreenShot("Catelog options");
		dashboard_POM.clickProductsLinks();
		screenShot.captureScreenShot("Products page displayed");
		productpage_POM.clickAddNewProductBtn();
		productpage_POM.sendProductName("Finger Ring");
		productpage_POM.sendMetaTagTitle("Finger Ring for ladies");
		productpage_POM.clickDataTab();
		screenShot.captureScreenShot("Data tab is displayed");
		productpage_POM.sendModelInDataTab("SKU-012");
		productpage_POM.sendPriceInDataTab("500");
		productpage_POM.sendQuantityInDataTab("50");
		productpage_POM.clickLinksTab();
		screenShot.captureScreenShot("Links tab is displayed");
		productpage_POM.sendManufacturerInLinksTab("manzoor");
		productpage_POM.clickCategoriesInLinksTab("Earrings");
		productpage_POM.clickSaveBtnAfterAddingProduct();
		
		
	}

}
