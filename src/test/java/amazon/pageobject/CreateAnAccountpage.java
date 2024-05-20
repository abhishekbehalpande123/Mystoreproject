package amazon.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAnAccountpage {
	
	private WebDriver driver;
	
	@FindBy(xpath= "//input[@id='id_gender1']")
	private WebElement Mr1;
	
	@FindBy(xpath = "//input[@id='customer_firstname']")
	private WebElement Firstname;
	
	@FindBy(xpath= "//input[@id='customer_lastname']")
	private WebElement lastname ;
	
	@FindBy(xpath= "//input[@id='passwd']")
	private WebElement	password;
	
	@FindBy(xpath = "//select[@id='days']")
	private WebElement days ;
	
	@FindBy(xpath = "//select[@id='months']")
	private WebElement months ;

	@FindBy(xpath = "//select[@id='years']")
	private WebElement years ;

	@FindBy(xpath = "//button[@id='submitAccount']")
	private WebElement submitbutton;

	
	
	
	public CreateAnAccountpage(WebDriver driver ) {
		this.driver= driver ;
		PageFactory.initElements(driver, this );
	}
	
	
	public void clickcheckbox() {
		Mr1.click();
	}
	
	public void sendFirstname() {
		Firstname.sendKeys("Abhishek");
	}
	
	public void sendlastname() {
		lastname.sendKeys("Behalpande");
	}
	
	public void sendpassword() {
		password.sendKeys("Abhishek@123");
	}
	
	public void senddays() {
		Select s1 = new Select(days);
		s1.selectByIndex(2);
	}
	
	public void sendmonths() {
		Select s2 = new Select(months);
		s2.selectByIndex(3);
	}
	
	public void sendyears() {
		Select s3 = new Select(years);
		s3.selectByIndex(4);
	}
	
	public void clicksubmitbutton() {
		submitbutton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
