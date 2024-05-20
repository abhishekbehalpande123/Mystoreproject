package amazon.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {

    public WebDriver driver;

    // Identify web elements
    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    private WebElement signIn;

    @FindBy(xpath = "(//a[text()='T-shirts'])[2]")
    private WebElement tshirtMenu;

    // Constructor
    public indexPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    

	public String getPageTitle()
	{
		return(driver.getTitle());
	}

    // Identify action on web elements
    public void clickOnSignIn() {
        signIn.click();
    }

    public void clickOnTShirtMenu() {
        tshirtMenu.click();
    }
}
