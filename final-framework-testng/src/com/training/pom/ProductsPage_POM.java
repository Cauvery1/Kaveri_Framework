package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage_POM {
private WebDriver driver; 
    
	public ProductsPage_POM (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement addNewProductBtn;
	
	@FindBy(xpath="//input[@type='text' and @id='input-name1']")
	private WebElement productNameField;
	
	@FindBy(xpath="//input[@id='input-meta-title1' and @name='product_description[1][meta_title]']")
	private WebElement metaTagTitleField;
	
	@FindBy(linkText="Data")
	private WebElement dataTab;
	
	@FindBy(xpath="//input[@id='input-model']")
	private WebElement modelInDataTab;
	
	@FindBy(xpath="//input[@id='input-price']")
	private WebElement priceInDataTab;
	
	@FindBy(xpath="//input[@id='input-quantity']")
	private WebElement quantityInDataTab;
	
	@FindBy(linkText="Links")
	private WebElement linksTab;
	
	@FindBy(xpath="//input[@id='input-manufacturer']")
	private WebElement manufacturerInLinksTab;
	
	@FindBy(xpath="//input[@placeholder='Categories']")
	private WebElement catogoriesInLinksTab;
	
	@FindBy(xpath="//input[@id='input-category']//parent::div//ul//li[1]//a[contains(text(),'Earrings')]")
	private WebElement catogorySelection;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveBtn;
	
	public void clickAddNewProductBtn()  {
        this.addNewProductBtn.click();
    		
	}
	public void sendProductName(String productname) {
		this.productNameField.clear();
		this.productNameField.sendKeys(productname);
	}
	public void sendMetaTagTitle(String metatagtitle) {
		this.productNameField.clear();
		this.productNameField.sendKeys(metatagtitle);
	}
	public void clickDataTab()  {
        this.dataTab.click();
    		
	}
	public void sendModelInDataTab(String model) {
		this.modelInDataTab.clear();
		this.modelInDataTab.sendKeys(model);
	}
	public void sendPriceInDataTab(String price) {
		this.priceInDataTab.clear();
		this.priceInDataTab.sendKeys(price);
	}
	public void sendQuantityInDataTab(String quantity) {
		this.quantityInDataTab.clear();
		this.quantityInDataTab.sendKeys(quantity);
	}
	public void clickLinksTab()  {
        this.linksTab.click();
    		
	}
	public void sendManufacturerInLinksTab(String manufacturer) {
		this.manufacturerInLinksTab.clear();
		this.manufacturerInLinksTab.sendKeys(manufacturer);
	}
	public void clickCategoriesInLinksTab()  {
        this.catogoriesInLinksTab.click();
        Actions action = new Actions(driver);
        action.moveToElement(catogorySelection).perform();
    		
	}
	public void clickSaveBtnAfterAddingProduct()  {
        this.saveBtn.click();
    		
	}
}
