package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsReturnPage_POM {
	
private WebDriver driver; 
    
	public ProductsReturnPage_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement addNewPrdBtn;
	
	public void clickAddNewProdBtn()  {
        this.addNewPrdBtn.click();
       
    		
	}
	
	@FindBy(xpath="//input[@id='input-order-id']")
	private WebElement orderId;
	
	public void sendReturnIDValues(String orderid)  {
        this.orderId.clear();
        this.orderId.sendKeys(orderid);
    		
	}
	
	public String returnOrderid() {
		return this.orderId.getAttribute("value");
	}
	
	@FindBy(xpath="//input[@id='input-customer']")
	private WebElement customer;
	
	public void sendCustomerValues(String customervalue)  {
        this.customer.clear();
        this.customer.sendKeys(customervalue);
    		
	}
	public String returnCustomerValues() {
		return this.customer.getAttribute("value");
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement firstName;
	
	public void sendFirstName(String firstname)  {
        this.firstName.clear();
        this.firstName.sendKeys(firstname);
    		
	}
	
	public String returnFirstName() {
		return this.firstName.getAttribute("value");
	}
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement lastName;
	
	public void sendLastName(String lastname)  {
        this.lastName.clear();
        this.lastName.sendKeys(lastname);
    		
	}
	
	public String returnLastName() {
		return this.lastName.getAttribute("value");
	}
	
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement email;
	
	public void sendemail(String email)  {
        this.email.clear();
        this.email.sendKeys(email);
    		
	}
	
	public String returnEmail() {
		return this.email.getAttribute("value");
	}
	
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement telephone;
	
	public void sendtelephone(String phone)  {
        this.telephone.clear();
        this.telephone.sendKeys(phone);
    		
	}
	
	public String returnPhone() {
		return this.telephone.getAttribute("value");
	}
	
	@FindBy(xpath="//input[@id='input-product']")
	private WebElement product;
	
	public void sendProduct(String prod)  {
        this.product.clear();
        this.product.sendKeys(prod);
    		
	}
	
	public String returnProduct() {
		return this.product.getAttribute("value");
	}
	
	@FindBy(xpath="//input[@id='input-model']")
	private WebElement model;
	
	public void sendmodelvalue(String model)  {
        this.model.clear();
        this.model.sendKeys(model);
    		
	}
	
	public String returnModel() {
		return this.model.getAttribute("value");
	}
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveBtn;
	
	public void clickSaveBtn()  {
        this.saveBtn.click();
        		
	}
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement message;
	
	public String checkMsgAfterSaveBtn()  {
       return this.message.getText();
       
    }
	
	//private String beforepath ="//td[contains(text(),'";
	//private String afterpath ="')]/preceding-sibling::td[2]";
	@FindBy(xpath="//tr[2]//td[1]//input[@type='checkbox']")
	private WebElement checkBox;
	public void prodToDelete() 
	{
		//String actualpath=beforepath+product+afterpath;
		//WebElement checkbox = driver.findElement(By.xpath(actualpath));
		this.checkBox.click();
	}
	
	
	@FindBy(xpath="//div[@class='pull-right']//button[@type='button']")
	private WebElement deleteIcon;
	
	public String deleteProduct() {
		this.deleteIcon.click();
		Alert a = driver.switchTo().alert();
		a.accept();
		//Thread.sleep(3000);
		return this.message.getText();
		
		
	}
	@FindBy(xpath="//div[@class='alert alert-danger']")
	private WebElement errormessage;
	
	public String checkErrorMsgAfterSaveBtn()  {
       return this.errormessage.getText();
       
    }
	@FindBy(xpath="//a[@class='btn btn-default']")
	private WebElement cancelBtn;
	
	public void clickCancelBtn()  {
       this.cancelBtn.click();
       
    }
}
