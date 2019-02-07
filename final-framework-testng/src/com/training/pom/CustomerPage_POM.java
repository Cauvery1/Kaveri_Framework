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
	
	@FindBy(xpath="//tr[1]//a//i[@class='fa fa-pencil']")
	private WebElement editCustomerIcon;
	
	@FindBy(xpath="//h3[@class='panel-title']")
	private WebElement editCustomerPageTitle;
	
	@FindBy(xpath="//input[@name='address[1][firstname]']")
	private WebElement firstnameField;
	
	@FindBy(xpath="//a[contains(text(),'Address 1')]")
	private WebElement addAddressField1;
	
	@FindBy(xpath="//input[@name='address[1][postcode]']")
	private WebElement postcode;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveAfterEdit;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement msgAfterEdit;
	
	@FindBy(xpath="//a[@href='#tab-reward']")
	private WebElement rewardsTab;
	
	@FindBy(xpath="//input[@id='input-reward-description']")
	private WebElement rewardDescription;
	
	@FindBy(xpath="//input[@id='input-points']")
	private WebElement rewardPoints;
	
	@FindBy(xpath="//button[@id='button-reward']")
	private WebElement addRewardPointsBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement rewardAddedMsg;
	
	@FindBy(xpath="//span[contains(text(),'Reports')]")
	private WebElement reportsLink;
	
	@FindBy(xpath="//a[@class='parent'][contains(text(),'Customers')]")
	private WebElement customerFromReports;
	
	@FindBy(linkText="Reward Points")
	private WebElement rewardpointLink;
	
	@FindBy(xpath="//h1[contains(text(),'Customer Reward Points Report')]")
	private WebElement rewardpointLinkPageTitle;
	
	
	
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
	public String clickCustomerEditIcon()  {
        this.editCustomerIcon.click();
        return this.editCustomerPageTitle.getText();
		
	}
	public void sendFirstName(String firstName) throws InterruptedException {
		this.firstnameField.clear();
		Thread.sleep(3000);
		this.firstnameField.sendKeys(firstName);
		
	}
	public void clickAddressField1()  {
        this.addAddressField1.click();
    		
	}
	public void sendPostcode(String postcode) throws InterruptedException {
		this.postcode.clear();
		Thread.sleep(3000);
		this.postcode.sendKeys(postcode);
	}
	
	public String clickSaveAfterEditngAddressFields() throws InterruptedException {
		this.saveAfterEdit.click();
		Thread.sleep(3000);
		return this.msgAfterEdit.getText();
		//return this.
	}
	public void clickRewardsTab()  {
        this.rewardsTab.click();
    		
	}
	public void sendRewardDescription(String rewardDesc) throws InterruptedException {
		this.rewardDescription.clear();
		Thread.sleep(3000);
		this.rewardDescription.sendKeys(rewardDesc);
		
	}
	public void sendRewardPoints(String rewardPoint) throws InterruptedException {
		this.rewardPoints.clear();
		Thread.sleep(3000);
		this.rewardPoints.sendKeys(rewardPoint);
		
	}
	public String clickAddRewardPointsBtn() throws InterruptedException  {
        this.addRewardPointsBtn.click();
        Thread.sleep(3000);
    	return	this.rewardAddedMsg.getText();
	}
	public void clickReoprtsLink()  {
        this.reportsLink.click();
    		
	}
	
	public void clickCustomersFromReportsLink()  {
        this.customerFromReports.click();
    		
	}
	public String clickRewardpointsFromCustomersLink() throws InterruptedException  {
        this.rewardpointLink.click();
        Thread.sleep(3000);
    	return this.rewardpointLinkPageTitle.getText();	
	}

}
