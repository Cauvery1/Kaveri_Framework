package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class RTTC_021_POM {
	
    private WebDriver driver; 
    
	public RTTC_021_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@id='menu-customer']//a[@class='parent']")
	private WebElement customerIcon;
	
	@FindBy(xpath="//ul[@class='collapse in']//a[contains(text(),'Customers')]")
	private WebElement customers;
	
	@FindBy(xpath="//h1[contains(text(),'Customers')]")
	private WebElement customerspage;
	
	@FindBy(xpath="//td[contains(text(),'manzoor@gmail.com')]/preceding-sibling::td[2]")
	private WebElement checkBox;
		
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement message;
	
	@FindBy(xpath="//div[@class='pull-right']//button[@type='button']")
	private WebElement deleteIcon;
		
	public void clickCustomerIcon() throws InterruptedException {
        this.customerIcon.click();
		
	}
	public void clickCustomersLink() {
		this.customers.click();
		
	}
	public String checkCustomersPage() {
		return this.customerspage.getText();
		
	}
	public void clickCheckBox() {
		this.checkBox.click();    
	}
	public String deleteCustomer() throws InterruptedException {
		this.deleteIcon.click();
		Alert a = driver.switchTo().alert();
		Thread.sleep(3000);
		a.accept();
		return this.message.getText();
		
		
	}

}
