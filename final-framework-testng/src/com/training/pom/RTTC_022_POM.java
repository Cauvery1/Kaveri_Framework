package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
//import com.training.pom.LoginPOM;



public class RTTC_022_POM {
private WebDriver driver; 
    
	public RTTC_022_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[contains(text(),'Reports')]")
	private WebElement reports;
	
	@FindBy(xpath="//a[contains(text(),'Sales')]")
	private WebElement sales;
	
	@FindBy(xpath="//select[@id='input-group']")
	private WebElement groupBy;
	
	@FindBy(linkText="Orders")
	private WebElement order;
	
	@FindBy(xpath="//button[@id='button-filter']")
	private WebElement filter;
	
	@FindBy(xpath="//h1[contains(text(),'Sales Report')]")
	private WebElement ordersPageTitle;

	public void reportsLink() {
		this.reports.click();    
	}
	public void salesLink() {
		this.sales.click();  
		
	}
	public String ordersLink() {
		this.order.click();  
		return this.ordersPageTitle.getText();
	}
	public void groupByField() {
		this.groupBy.click(); 
		Select groupby = new Select(groupBy);
		groupby.selectByValue("week");
		
	}
	public void filterBtn() {
		this.filter.click();    
	}
}
