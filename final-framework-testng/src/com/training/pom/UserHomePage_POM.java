package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage_POM {
private WebDriver driver; 
    
	public UserHomePage_POM (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Shop Now')]")
	private WebElement shopNowBtn;
	
	@FindBy(xpath="//a[@id='search_button']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//input[@id='filter_keyword']")
	private WebElement searchField;
	
	private String beforepath ="//span[contains(text(),'";
	private String afterpath ="')]";
	public void clickShopNowBtn(String ShopNowMenu)  {
		this.shopNowBtn.click();
        String actualpath=beforepath+ShopNowMenu+afterpath;
		WebElement menuSelection = driver.findElement(By.xpath(actualpath));
        Actions action = new Actions(driver);
        action.moveToElement(menuSelection).click().perform();
    		
	}
	
	public void clickSearchBtn() {
		//this.searchBtn.click();
		Actions action = new Actions(driver);
        action.moveToElement(searchBtn).click().build().perform();
	}
	
	public void sendTextInSearchField(String TextSearch) {
		this.searchField.clear();
		this.searchField.sendKeys(TextSearch);
	}
	

}
