package amazon.pageobject;


	
 
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	
	public class orderusummarrypage {
		
		  WebDriver driver;

		//2. Create constructor
		public orderusummarrypage(WebDriver driver) {
			this.driver = driver ; 
		PageFactory.initElements(driver, this);
			
		}


		@FindBy(linkText = "Proceed to checkout")
		private WebElement proceed;
		
		
		
		
		public void cickOnProceedToCheckout()
		{
			proceed.click();
		}
		
		

	}
 
