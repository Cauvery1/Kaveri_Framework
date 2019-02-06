package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DashboardForAdmin_POM {
private WebDriver driver; 
    
	public DashboardForAdmin_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@id='menu-customer']//a[@class='parent']")
	private WebElement customerIcon;
	
	@FindBy(xpath="//ul[@class='collapse in']//a[contains(text(),'Customers')]")
	private WebElement customers;
	
	@FindBy(xpath="//span[contains(text(),'Reports')]")
	private WebElement reports;
	
	@FindBy(xpath="//a[contains(text(),'Sales')]")
	private WebElement sales;
	
	@FindBy(linkText="Orders")
	private WebElement order;
	
	@FindBy(xpath="//h1[contains(text(),'Sales Report')]")
	private WebElement ordersPageTitle;
	
	@FindBy(linkText="Tax")
	private WebElement tax;
	
	@FindBy(xpath="//h1[contains(text(),'Tax Report')]")
	private WebElement taxPageTitle;
	
	@FindBy(linkText="Shipping")
	private WebElement shippingReport;
	
	@FindBy(xpath="//h1[contains(text(),'Shipping Report')]")
	private WebElement shippingPageTitle;
	
	@FindBy(linkText="Returns")
	private WebElement returns;
	
	@FindBy(xpath="//h1[contains(text(),'Returns Report')]")
	private WebElement returnsPageTitle;
	
	@FindBy(xpath="//select[@id='input-group']")
	private WebElement groupBy;
	
	@FindBy(xpath="//button[@id='button-filter']")
	private WebElement filter;
	
	
	public void clickCustomerIcon() throws InterruptedException {
        this.customerIcon.click();
		
	}
	public void clickCustomersLink() {
		this.customers.click();
		
	}
	
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
	
	public String taxLink() {
		this.tax.click();  
		return this.taxPageTitle.getText();
	}
	public String shippingLink() throws InterruptedException {
		Thread.sleep(3000);
		this.shippingReport.click();  
		return this.shippingPageTitle.getText();
	}
	
	public String returnsLink() throws InterruptedException {
		Thread.sleep(3000);
		this.returns.click();  
		return this.returnsPageTitle.getText();
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
