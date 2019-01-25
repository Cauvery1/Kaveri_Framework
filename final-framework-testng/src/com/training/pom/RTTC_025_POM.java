package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RTTC_025_POM {
private WebDriver driver; 
    
	public RTTC_025_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[contains(text(),'Reports')]")
	private WebElement reports;
	
	@FindBy(xpath="//a[contains(text(),'Sales')]")
	private WebElement sales;
	
	@FindBy(xpath="//select[@name='filter_group']")
	private WebElement groupBy;
	
	@FindBy(linkText="Returns")
	private WebElement returns;
	
	@FindBy(xpath="//button[@id='button-filter']")
	private WebElement filter;
	
	@FindBy(xpath="//h1[contains(text(),'Returns Report')]")
	private WebElement returnsPageTitle;
	
	
	public void reportsLink() {
		this.reports.click();    
	}
	public void salesLink() {
		this.sales.click();  
		
	}
	public String returnsLink() throws InterruptedException {
		Thread.sleep(3000);
		this.returns.click();  
		return this.returnsPageTitle.getText();
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
