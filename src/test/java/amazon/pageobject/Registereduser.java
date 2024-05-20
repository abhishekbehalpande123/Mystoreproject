package amazon.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registereduser {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//a[@title='View my customer account']")
	private WebElement reguser;
	
	@FindBy(xpath  ="//a[@title='Log me out']")
	private  WebElement signout;
	
	@FindBy(xpath = "//input[@id='search_query_top']")
	private WebElement searchbox ; 
	
	@FindBy(xpath = "//button[@name='submit_search']")
	private WebElement searchbutton ; 
	
	@FindBy(linkText = "Women")
	private WebElement WomenMenu;
	
	@FindBy(linkText="T-shirts")
	private WebElement TShirtMenu;
	
	
	
	public Registereduser(WebDriver driver) {
		this.driver = driver ; 
	PageFactory.initElements(driver, this);
		
	}
	
	
	public void clicknonsignout() {
		signout.click();
	}
	
	public String validateregisteruser() {
		String text = reguser.getText();
		return text;
	}
	

	public void EnterDataInSearchBox( )
	{
		searchbox.sendKeys("Dress ");
	}

	public void ClickOnSearchButton()
	{
		searchbutton.click();

	}

	
	public void MouseOverTShirtMenu()
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(WomenMenu).moveToElement(TShirtMenu).click().perform();
	}
	
	
	
	
	
	
}