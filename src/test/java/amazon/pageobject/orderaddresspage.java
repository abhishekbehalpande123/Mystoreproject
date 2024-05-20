package amazon.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class orderaddresspage {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//button[@name='processAddress']")
	private WebElement proceedbutton;
	
	 
	
	
	public orderaddresspage(WebDriver driver) {
		this.driver = driver ; 
	PageFactory.initElements(driver, this);
		
	}
	
	 
  public void clickproceedbutton() {
	  proceedbutton.click();
  }
	
	
	

}
