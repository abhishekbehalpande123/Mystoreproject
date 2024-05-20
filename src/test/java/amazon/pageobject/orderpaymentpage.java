package amazon.pageobject;


	
 

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class orderpaymentpage {
		 public WebDriver ldriver;


		private WebDriver driver;

		//2. Create constructor
		public orderpaymentpage(WebDriver driver)
		{
			this.driver = driver ;
			PageFactory.initElements(driver, this);//driver that will be used to lookup the web element

		}


		@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/div[3]/div[2]/div/p/a")
		WebElement payByCheque;
		
		
		@FindBy(className ="bankwire")
		WebElement payByBankWire;
		
		public String getPageTitle()
		{
			return (driver.getCurrentUrl());
		}
		
		public void clickOnPayByCheque()
		{
			payByCheque.click();
		}

		public void clickOnPayByBankwire()
		{
			payByBankWire.click();
		}

		
	}
 
