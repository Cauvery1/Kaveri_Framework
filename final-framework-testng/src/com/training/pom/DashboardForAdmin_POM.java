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
	
	@FindBy(linkText="Customer Groups")
	private WebElement customerGroups;
	
	@FindBy(xpath="//h1[contains(text(),'Customer Groups')]")
	private WebElement customerGroupspage;
	
	@FindBy(xpath="//tr[1]//td[6]//a[@data-original-title='View']")
	private WebElement viewIcon;
	
	@FindBy(xpath="//span[contains(text(),'Catalog')]")
	private WebElement catalogIcon;
	
	@FindBy(linkText="Manufacturers")
	private WebElement manufacturerLink;
	
	@FindBy(xpath="//span[contains(text(),'Catalog')]//ancestor::li//a[contains(text(),'Products')]")
	private WebElement productsLink;
	
	
	
	@FindBy(xpath="//li[@id='menu-sale']//a[contains(text(),'Orders')]")
	private WebElement ordersLink;
	
	@FindBy(xpath="//span[contains(text(),'Sales')]")
	private WebElement salesIcon;
	
	public void clickManufacturersLink()  {
        this.manufacturerLink.click();
    	//return this.manufacturerPageTitle.getText();
        //System.out.println(this.manufacturerPageTitle.getText());
	}
	
	public void clickCatelogLink()  {
        this.catalogIcon.click();
    		
	}
	
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
	
	public void clickCustomerGroupsLink() {
        this.customerGroups.click();
		
	}
	public String checkCustomerGroupspage()  {
        return this.customerGroupspage.getText();
		
	}
	
	public void clickViewIcon()  {
        this.viewIcon.click();
        
    		
	}
	public void clickProductsLinks()  {
        this.productsLink.click();
    		
	}
	
	public void clickSalesIcon()  {
        this.salesIcon.click();
    		
	}
	
	public void clickOrdersFromSalesIcon()  {
        this.ordersLink.click();
    		
	}
}
