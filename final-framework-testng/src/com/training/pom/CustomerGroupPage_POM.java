package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerGroupPage_POM {
private WebDriver driver; 
    
	public CustomerGroupPage_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[contains(text(),'Customer Groups')]")
	private WebElement customerGroupspage;
	
	@FindBy(xpath="//a[@class='btn btn-primary' and @data-original-title='Add New']")
	private WebElement addnewbtn;
	
	@FindBy(xpath="//input[@placeholder='Customer Group Name']")
	private WebElement customerGroupName;
	
	@FindBy(xpath="//textarea[@id='input-description1']")
	private WebElement customerDescription;
	
	@FindBy(xpath="//input[@value='1']")
	private WebElement approveNewCustomerRadio;

	@FindBy(xpath="//input[@id='input-sort-order']")
	private WebElement sortOrder;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement savebtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement customerAddedMsg;
	
	@FindBy(xpath="//ul[@class='collapse in']//a[contains(text(),'Customers')]")
	private WebElement customers1;
	
	@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement addUserBtn;
	
	@FindBy(xpath="//h3[@class='panel-title']")
	private WebElement addCustomer;
	
	@FindBy(xpath="//select[@id='input-customer-group']")
	private WebElement customerGroupField;
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement firstnameField;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement lastnameField;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement telephoneField;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement confirmpasswordField;
	
	@FindBy(xpath="//a[@onclick='addAddress();']")
	private WebElement addAddressField;
	
	@FindBy(xpath="//a[contains(text(),'Address 1')]")
	private WebElement addAddressField1;
	
	@FindBy(id="input-firstname1")
	private WebElement firstnameField1;
	
	@FindBy(id="input-lastname1")
	private WebElement lastnameField1;
	
	@FindBy(xpath="//input[@name='address[1][address_1]']")
	private WebElement AddressField1;
	
	@FindBy(xpath="//input[@name='address[1][address_2]']")
	private WebElement AddressField2;
	
	@FindBy(xpath="//input[@id='input-city1']")
	private WebElement city;
	
	@FindBy(xpath="//input[@id='input-postcode1']")
	private WebElement postcode;
	
	@FindBy(xpath="//select[@id='input-country1']")
	private WebElement country;
	
	@FindBy(xpath="//select[@id='input-zone1']")
	private WebElement region;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveFinal;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement msgFinal;
	
	public String checkCustomerGroupspage()  {
        return this.customerGroupspage.getText();
		
	}
	public void clickaddNewBtn() {
        this.addnewbtn.click();
		
	}
	public void sendCustomerGroupName(String customerGroupName) {
		this.customerGroupName.clear();
		this.customerGroupName.sendKeys(customerGroupName);
	}
	
	public void sendCustomerDescirption(String customerDescirption) {
		this.customerDescription.clear();
		this.customerDescription.sendKeys(customerDescirption);
	}
	
	public void clickRadioBtn() {
        this.approveNewCustomerRadio.click();
		
	}
	public String clickSave() {
        this.savebtn.click();
        return this.customerAddedMsg.getText();
		
	}
	public void clickCustomersLink1() {
		this.customers1.click();
		
	}
	public String  clickAddUserBtn() {
		this.addUserBtn.click();
		return this.addCustomer.getText();
	}
	public void sendCustomerGroupFeild(String customerGrouptext) {
		Select customerGroup = new Select(customerGroupField);
		customerGroup.selectByVisibleText(customerGrouptext);
	}
	
	public void sendFirstLastName(String firstName,String lastName) {
		this.firstnameField.clear();
		this.firstnameField.sendKeys(firstName);
		this.lastnameField.clear();
		this.lastnameField.sendKeys(lastName);
		
	}
	public void sendemailField(String email) {
		this.emailField.clear();
		this.emailField.sendKeys(email);
	}
	public void sendtelephoneField(String telephonenumber ) {
		this.telephoneField.clear();
		this.telephoneField.sendKeys(telephonenumber);
	}
	public void sendPasswordAndConfirmPassword(String password) {
		this.passwordField.clear();
		this.passwordField.sendKeys(password);
		this.confirmpasswordField.clear();
		this.confirmpasswordField.sendKeys(password);
		
	}
	public void clickAddressBtn() throws InterruptedException {
        Actions a = new Actions(driver);
        a.moveToElement(addAddressField).click().perform();
		//this.addAddressField.click();
        Thread.sleep(5000);
        //this.addAddressField1.click();
		
	}
	public void sendFirstLastName1(String firstName1,String lastName1) {
		this.firstnameField1.clear();
		this.firstnameField1.sendKeys(firstName1);
		this.lastnameField1.clear();
		this.lastnameField1.sendKeys(lastName1);
		
	}
	public void sendAddressField1(String adress1) {
		this.AddressField1.clear();
		this.AddressField1.sendKeys(adress1);
	}
	public void sendAddressField2(String adress2) {
		this.AddressField2.clear();
		this.AddressField2.sendKeys(adress2);
	}
	public void sendPostcode(String postcode) throws InterruptedException {
		this.postcode.clear();
		Thread.sleep(3000);
		this.postcode.sendKeys(postcode);
	}
	public void sendCity(String cityname) {
		this.city.clear();
		this.city.sendKeys(cityname);
	}
	public void sendCountry(String countryname) {
		Select countryfield = new Select(country);
		countryfield.selectByVisibleText(countryname);
	}
	public void sendRegion(String regionname) {
		Select regionfield = new Select(region);
		regionfield.selectByVisibleText(regionname);
	}
	public String clickSaveAfterAddingAddress() throws InterruptedException {
		this.saveFinal.click();
		Thread.sleep(3000);
		return this.msgFinal.getText();
		//return this.
	}
}