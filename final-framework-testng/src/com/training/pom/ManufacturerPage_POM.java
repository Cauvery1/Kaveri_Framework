package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManufacturerPage_POM {
private WebDriver driver; 
    
	public ManufacturerPage_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@class='btn btn-primary']")
	private WebElement addManufacturerBtn;
	
	@FindBy(xpath="//input[@id='input-name']")
	private WebElement manufacturerName;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement manufacturerSaveBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement msgAfterSavingManufacturer;
	
	public void clickAddManufacturerBtn()  {
        this.addManufacturerBtn.click();
    		
	}
	public void sendManufacturerName(String ManufacturerName) {
		this.manufacturerName.clear();
		this.manufacturerName.sendKeys(ManufacturerName);
	}
	public String clickSaveManufacturerBtn()  {
        this.manufacturerSaveBtn.click();
    	return this.msgAfterSavingManufacturer.getText();	
	}
}
