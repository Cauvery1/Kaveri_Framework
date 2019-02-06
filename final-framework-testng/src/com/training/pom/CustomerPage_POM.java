package com.training.pom;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage_POM {
	
	private WebDriver driver;
	public CustomerPage_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[contains(text(),'Customers')]")
	private WebElement customerspage;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement message;
	
	@FindBy(xpath="//div[@class='pull-right']//button[@type='button']")
	private WebElement deleteIcon;
	
	
	private String beforepath ="//td[contains(text(),'";
	private String afterpath ="')]/preceding-sibling::td[2]";
	public void mailIdCheck(String mailId) throws InterruptedException
	{
		String actualpath=beforepath+mailId+afterpath;
		WebElement checkbox = driver.findElement(By.xpath(actualpath));
		checkbox.click();
	}
	
	public String checkCustomersPage() {
		return this.customerspage.getText();
		
	}
	
	public String deleteCustomer() throws InterruptedException {
		this.deleteIcon.click();
		Alert a = driver.switchTo().alert();
		
		a.accept();
		Thread.sleep(3000);
		return this.message.getText();
		
		
	}

}
