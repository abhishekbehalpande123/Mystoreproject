package amazon.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class productpage {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//select[@id='group_1']")
	private WebElement selectsize;
	
	@FindBy (xpath = "//input[@id='quantity_wanted']")
	private WebElement selectquantity;
	
	@FindBy(xpath = "//a[@id='color_24']")
	private WebElement selectcolor;
	
	@FindBy (xpath = "//button[@name='Submit']")
	private WebElement clickaddtocart;
	
	@FindBy(linkText = "Proceed to checkout")
	private WebElement proceed;

	
	
	
	public productpage(WebDriver driver) {
		this.driver = driver ; 
	PageFactory.initElements(driver, this);
		
	}

	
	public void  selectsizedress() {
		Select s1 = new  Select(selectsize);
		s1.selectByIndex(1);
	}
	
	public void selectquantitydress() {
		selectquantity.sendKeys("2");
	}
	
	public void selectcolordress() {
		selectcolor.click();
	}
	
	public void clickaddtocartdress() {
		clickaddtocart.click();
	}
	
	public void clickproceedtocheckout() {
		proceed.click();
	}
	
	
	
	
	
	
	
	
}
