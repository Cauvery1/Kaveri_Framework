package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrderPage_POM {
private WebDriver driver; 
    
	public OrderPage_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(xpath="//h1[contains(text(),'Orders')]")
	private WebElement ordersPage;
	
	@FindBy(xpath="//button[@id='button-invoice']")
	private WebElement invoiceBtn;
	 
	@FindBy(xpath="//select[@id='input-order-status']")
	private WebElement orderStatus;
	
	@FindBy(xpath="//button[@id='button-history']")
	private WebElement addHistoryBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement addHistoryMsg;
	
	@FindBy(xpath="//a[@data-original-title = 'Add New']")
	private WebElement addNewBtn;
	
	@FindBy(xpath="//h3[@class='panel-title']")
	private WebElement addNewOrderPagetitle;
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement telephone;
	
	@FindBy(xpath="//button[@id='button-customer']")
	private WebElement continueBtnFromCustomers;
	
	@FindBy(linkText="2. Products")
	private WebElement productsTab;
	
	@FindBy(xpath="//input[@id='input-product']")
	private WebElement chooseProduct;
	
	@FindBy(xpath="//input[@id='input-quantity']")
	private WebElement quantity;
	
	@FindBy(xpath="//button[@id='button-product-add']")
	private WebElement addProductBtn;
	
	//@FindBy(xpath="//tbody[@id='cart']//td[1]")
	//private WebElement productVerify;
	
	@FindBy(xpath="//button[@id='button-cart']")
	private WebElement continueBtnFromProducts;
	
	@FindBy(linkText="3. Payment Details")
	private WebElement paymentDetailsTab;
	
	@FindBy(xpath="//input[@id='input-payment-firstname']")
	private WebElement firstnameInPayment;
	
	@FindBy(xpath="//input[@id='input-payment-lastname']")
	private WebElement lastnameInPayment;
	
	@FindBy(xpath="//input[@id='input-payment-address-1']")
	private WebElement address1InPayment;
	
	@FindBy(xpath="//input[@id='input-payment-address-2']")
	private WebElement address2InPayment;
	
	@FindBy(xpath="//input[@id='input-payment-city']")
	private WebElement cityInPayment;
	
	@FindBy(xpath="//input[@id='input-payment-postcode']")
	private WebElement postcodeInPayment;
	
	@FindBy(xpath="//select[@id='input-payment-country']")
	private WebElement countryInPayment;
	
	@FindBy(xpath="//select[@id='input-payment-zone']")
	private WebElement regionInPayment;
	
	@FindBy(xpath="//button[@id='button-payment-address']")
	private WebElement continueBtnFromPayment;
	
	@FindBy(linkText="4. Shipping Details")
	private WebElement shippingDetailsTab;
	
	@FindBy(xpath="//input[@id='input-shipping-firstname']")
	private WebElement firstnameInShippingDetails;
	
	@FindBy(xpath="//input[@id='input-shipping-lastname']")
	private WebElement lastnameInShippingDetails;
	
	@FindBy(xpath="//input[@id='input-shipping-address-1']")
	private WebElement address1InShippingDetails;
	
	@FindBy(xpath="//input[@id='input-shipping-address-2']")
	private WebElement address2InShippingDetails;
	
	@FindBy(xpath="//input[@id='input-shipping-city']")
	private WebElement cityInShippingDetails;
	
	@FindBy(xpath="//input[@id='input-shipping-postcode']")
	private WebElement postcodeInShippingDetails;
	
	@FindBy(xpath="//select[@id='input-shipping-country']")
	private WebElement countryInShippingDetails;
	
	@FindBy(xpath="//select[@id='input-shipping-zone']")
	private WebElement regionInShippingDetails;
	
	@FindBy(xpath="//button[@id='button-shipping-address']")
	private WebElement continueBtnFromShippingDetails;
	
	@FindBy(linkText="5. Totals")
	private WebElement totalsTab;
	
	@FindBy(xpath="//select[@id='input-shipping-method']")
	private WebElement shippingMethod;
	
	@FindBy(xpath="//button[@id='button-shipping-method'][contains(text(),'Apply')]")
	private WebElement applyshippingMethod;
	
	@FindBy(xpath="//select[@id='input-payment-method']")
	private WebElement paymentMethod;
	
	@FindBy(xpath="//button[@id='button-payment-method'][contains(text(),'Apply')]")
	private WebElement applypaymentMethod;
	
	@FindBy(xpath="//button[@id='button-save']")
	private WebElement finalSave;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement msgAfterFinalSave;
	
	
	
	public String clickAddNewBtn()  {
        this.addNewBtn.click();
    	return this.addNewOrderPagetitle.getText();	
	}
	
	public void sendFirstAndLastName(String firstName,String lastName) throws InterruptedException {
		this.firstName.clear();
		Thread.sleep(3000);
		this.firstName.sendKeys(firstName);
		this.lastName.clear();
		Thread.sleep(3000);
		this.lastName.sendKeys(lastName);
	}
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	public void sendTelephone(String phone) {
		this.telephone.clear();
		this.telephone.sendKeys(phone);
	}
	public String clickContinueBtnFromCustomerDetails()  {
        this.continueBtnFromCustomers.click();
        return this.productsTab.getText();
    		
	}
	public void sendChooseProduct(String productname) {
		this.chooseProduct.clear();
		this.chooseProduct.sendKeys(productname);
	}
	public void sendQuantity(String quantity) {
		this.quantity.clear();
		this.quantity.sendKeys(quantity);
	}
	public void clickAddProductBtn()  {
        this.addProductBtn.click();
        //return this.productVerify.getText();
    		
	}
	public String clickContinueBtnFromProducts()  {
        this.continueBtnFromProducts.click();
        return this.paymentDetailsTab.getText();
    		
	}
	public void sendFirstAndLastNameINPaymentTab(String firstName,String lastName){
		this.firstnameInPayment.clear();
		this.firstnameInPayment.sendKeys(firstName);
		this.lastnameInPayment.clear();
		this.lastnameInPayment.sendKeys(lastName);
	}
	public void sendAddress1INPaymentTab(String address1) {
		this.address1InPayment.clear();
		this.address1InPayment.sendKeys(address1);
	}
	public void sendAddress2INPaymentTab(String address2) {
		this.address2InPayment.clear();
		this.address2InPayment.sendKeys(address2);
	}
	public void sendCityINPaymentTab(String city) {
		this.cityInPayment.clear();
		this.cityInPayment.sendKeys(city);
	}
	public void sendPostcodeINPaymentTab(String postcode) {
		this.postcodeInPayment.clear();
		this.postcodeInPayment.sendKeys(postcode);
	}
	public void sendCountryINPaymentTab(String country) {
		Select countryVar = new Select(countryInPayment);
		countryVar.selectByVisibleText(country);
		
	}
	public void sendRegionINPaymentTab(String region) {
		Select regionVar = new Select(regionInPayment);
		regionVar.selectByVisibleText(region);
	}
	public String clickContinueBtnFromPaymentTab()  {
        this.continueBtnFromPayment.click();
        return this.shippingDetailsTab.getText();
    		
	}
	
	public void sendFirstAndLastNameINShippingDetailsTab(String firstName,String lastName){
		this.firstnameInShippingDetails.clear();
		this.firstnameInShippingDetails.sendKeys(firstName);
		this.lastnameInShippingDetails.clear();
		this.lastnameInShippingDetails.sendKeys(lastName);
	}
	public void sendAddress1INShippingDetailsTab(String address1) {
		this.address1InShippingDetails.clear();
		this.address1InShippingDetails.sendKeys(address1);
	}
	public void sendAddress2INShippingDetailsTab(String address2) {
		this.address2InShippingDetails.clear();
		this.address2InShippingDetails.sendKeys(address2);
	}
	public void sendCityINShippingDetailsTab(String city) {
		this.cityInShippingDetails.clear();
		this.cityInShippingDetails.sendKeys(city);
	}
	public void sendPostcodeINShippingDetailsTab(String postcode) {
		this.postcodeInShippingDetails.clear();
		this.postcodeInShippingDetails.sendKeys(postcode);
	}
	public void sendCountryINShippingDetailsTab(String country1) {
		Select countryVar1 = new Select(countryInShippingDetails);
		countryVar1.selectByVisibleText(country1);
		
	}
	public void sendRegionINShippingDetailsTab(String region) throws InterruptedException {
		Select regionVar1 = new Select(regionInShippingDetails);
		regionVar1.selectByVisibleText(region);
		Thread.sleep(3000);
	}
	
	public void clickContinueBtnFromShippingDetailsTab() throws InterruptedException  {
        this.continueBtnFromShippingDetails.click();
        //Thread.sleep(3000);
        //return this.totalsTab.getText();
    		
	}
	
	public void sendShippingMethod(String shippingmethod) {
		Select shippingmethodVar = new Select(this.shippingMethod);
		shippingmethodVar.selectByVisibleText(shippingmethod);
		//this.applyshippingMethod.click();
	}
	public void sendPaymentMethod(String paymentmethod) {
		Select paymentmethodVar = new Select(this.paymentMethod);
		paymentmethodVar.selectByVisibleText(paymentmethod);
		//this.applypaymentMethod.click();
	}
	public void clickFinalSave()  {
        this.finalSave.click();
    	//return this.msgAfterFinalSave.getText();
	}
	
	public String checkOrderPageTitle()  {
       
        return this.ordersPage.getText();
    		
	}
	public void clickInvoiceBtn()  {
        this.invoiceBtn.click();
    		
	}
	public void clickOrderStatus(String status)  {
        //this.orderStatus.click();
    	Select orderstatusVar = new Select(orderStatus);
    	orderstatusVar.selectByVisibleText(status);
	}
	public String clickAddHistoryBtn()  {
        this.addHistoryBtn.click();
        return this.addHistoryMsg.getText();
    		
	}
}
