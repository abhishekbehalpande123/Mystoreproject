package amazon.pageobject;


	
 

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class orderconfirmationpage {
		 


		private WebDriver driver;

		//2. Create constructor
		public orderconfirmationpage(WebDriver driver)
		{
			this.driver = driver ; 
			PageFactory.initElements(driver, this);//driver that will be used to lookup the web element

		}

		@FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
		WebElement confirmOrder;
		
		
		@FindBy(xpath="//p[@class='alert alert-success']")
		WebElement sucessAlert;

		@FindBy(linkText = "Sign out")
		WebElement signOut;
		
		public void clickOnSignOut()
		{
			signOut.click();
		}
		
		public void cickOnConfirmOrder()
		{
			confirmOrder.click();
		}
		
		public String getOrderSucessMessage()
		{
			return(sucessAlert.getText());
		}
		
		
	}

 
