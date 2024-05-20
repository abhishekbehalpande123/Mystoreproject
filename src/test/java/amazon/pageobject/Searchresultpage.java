package amazon.pageobject;


	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class Searchresultpage {

		WebDriver driver;

		//2. Create constructor
		public Searchresultpage(WebDriver driver)
		{
			this.driver = driver ; 
			PageFactory.initElements(driver, this);//driver that will be used to lookup the web element

		}

		//Identify the elements present in search result page



		@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[2]/h5/a")
		WebElement searchResultProduct ;
		
		@FindBy(linkText="More")
		WebElement more;
		
		//action methods on web elements of search result page
		
		public String getSearchResultProductName()
		{
			return(searchResultProduct.getText());
		}
		
		public void ClickOnMoreLink()
		{
			more.click();

		}
		
	
	}
	
	
	
 