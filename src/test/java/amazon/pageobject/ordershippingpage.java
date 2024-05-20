package amazon.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ordershippingpage {
	
	
	private WebDriver driver;
	
	@FindBy(xpath = "//input[@id='cgv']")
	private WebElement terms;

	
	@FindBy(xpath = "//button[@name='processCarrier']")
	private WebElement proceedbutton12;



	
	public ordershippingpage(WebDriver driver) {
		this.driver = driver ; 
	PageFactory.initElements(driver, this);
		
	}
	
	
	public void clicktermcheckbox() {
		terms.click();
	}
	
	public void clickproceedbutton() {
		proceedbutton12.click();
	}
	
	
	
	
	
	
}
