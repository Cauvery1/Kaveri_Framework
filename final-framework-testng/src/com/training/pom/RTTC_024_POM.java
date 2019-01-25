package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RTTC_024_POM {
private WebDriver driver; 
    
	public RTTC_024_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[contains(text(),'Reports')]")
	private WebElement reports;
	
	@FindBy(xpath="//a[contains(text(),'Sales')]")
	private WebElement sales;
	
	@FindBy(xpath="//select[@name='filter_group']")
	private WebElement groupBy;
	
	@FindBy(linkText="Shipping")
	private WebElement shippingReport;
	
	@FindBy(xpath="//button[@id='button-filter']")
	private WebElement filter;
	
	@FindBy(xpath="//h1[contains(text(),'Shipping Report')]")
	private WebElement shippingPageTitle;
	
	
	public void reportsLink() {
		this.reports.click();    
	}
	public void salesLink() {
		this.sales.click();  
		
	}
	public String shippingLink() throws InterruptedException {
		Thread.sleep(3000);
		this.shippingReport.click();  
		return this.shippingPageTitle.getText();
	}
	public void groupByField() throws InterruptedException {
		Thread.sleep(3000);
		this.groupBy.click(); 
		Select groupby = new Select(groupBy);
		groupby.selectByValue("week");
		
	}
	public void filterBtn() throws InterruptedException {
		Thread.sleep(3000);
		this.filter.click();    
	}


}
