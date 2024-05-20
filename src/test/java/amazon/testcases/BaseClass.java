package amazon.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import amazon.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    ReadConfig readConfig = new ReadConfig();

    String url = readConfig.getBaseUrl();
    String browser = readConfig.getBrowser();
    public static WebDriver driver;
    public static Logger logger;

    @BeforeClass
    public void setup() {
        // Setting up WebDriver
       
        ChromeOptions co = new ChromeOptions();
        co.setBinary("D:\\chrome-win64\\chrome-win64\\chrome.exe");
        driver = new ChromeDriver(co);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Initializing logger
        logger = LogManager.getLogger(BaseClass.class);
        
        // Opening URL
        driver.get(url);
        logger.info("URL opened: " + url);
        driver.manage().window().maximize();
    }
 

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

	//user method to capture screen shot
	public void captureScreenShot(WebDriver driver,String testName) throws IOException
	{
		//step1: convert webdriver object to TakesScreenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		
		//step2: call getScreenshotAs method to create image file
		
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");
	
		//step3: copy image file to destination
		FileUtils.copyFile(src, dest);
	}
    
    
}
