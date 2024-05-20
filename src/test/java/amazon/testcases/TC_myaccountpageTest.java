package amazon.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import amazon.pageobject.CreateAnAccountpage;
import amazon.pageobject.Registereduser;
import amazon.pageobject.indexPage;
import amazon.pageobject.myAccount;

public class TC_myaccountpageTest extends BaseClass {
    
    indexPage pg;

    @Test(enabled=false)
    public void verifiedRegistrationandlogin() throws InterruptedException {
        
        
        pg = new indexPage(driver);
        
        Thread.sleep(3000);
        pg.clickOnSignIn();
        logger.info("usfrl opefafned");
        Thread.sleep(3000);
        
       
        
    
        
   
         
        // Add further test steps as needed
        
      myAccount ac = new myAccount(driver);
      
      Thread.sleep(3000);
      ac.enterCreateEmailAddress("teswtrad3@gmail.com");
      Thread.sleep(2000);
      ac.clickSubmitCreate();
      Thread.sleep(3000);
      
      
      CreateAnAccountpage cs = new CreateAnAccountpage(driver);
      cs.clickcheckbox();
      Thread.sleep(2000);
      cs.sendFirstname();
      Thread.sleep(2000);
      cs.sendlastname();
      Thread.sleep(2000);
      cs.sendpassword();
      Thread.sleep(2000);
      cs.senddays();
      Thread.sleep(2000);
      cs.sendmonths();
      Thread.sleep(2000);
      cs.sendyears();
      Thread.sleep(2000);
      cs.clicksubmitbutton();
      Thread.sleep(4000);
      
      Registereduser reg= new Registereduser(driver);
    String useername =  reg.validateregisteruser();
    
    Assert.assertEquals("Abhishek Behalpande", useername);
      
      
    }
    @Test 
    public void verifylogin() throws IOException, InterruptedException {
    	
    	indexPage px = new indexPage(driver) ;
    	px.clickOnSignIn();
    	logger.info("clicked on sign in link");
    	Thread.sleep(2000);
    	
    	myAccount mc = new myAccount(driver) ;
    	mc.enterEmailAddress("test17011999@gmail.com");
    	mc.enterPassword("Abhishek@123");
    	Thread.sleep(2000);
    	mc.clickSignIn();
    	Thread.sleep(2000);
    	
    	  Registereduser reg= new Registereduser(driver);
    	    String useername =  reg.validateregisteruser();
    	    
    	    if(useername.equals("Abhishek Behalpande")) {
    	    	
    	    	logger.info("verifylogin - passed");
    	    	
    	    	Assert.assertTrue(true);
    	    }else {
    	    	logger.info("verifylogin - failed");
    	    	captureScreenShot(driver,"verifylogin");
    	    	Assert.assertTrue(false);
    	    }
    		
    }
    
    
    	    @Test
    		public void VerifySignOut() throws IOException, InterruptedException 
    		{

    			logger.info("***************TestCase Verify Sign out starts*****************"); 

    			indexPage pg = new indexPage(driver);

    			pg.clickOnSignIn();
    			logger.info("Clicked on sign in link");
    			Thread.sleep(2000);

    			myAccount myAcpg = new myAccount(driver);

    			myAcpg.enterEmailAddress("test17011999@gmail.com");
    			logger.info("Entered email address");

    			myAcpg.enterPassword("Abhishek@123");
    			logger.info("Entered password");
    			Thread.sleep(2000);

    			myAcpg.clickSignIn();
    			logger.info("Clicked on sign in link..");


    			Registereduser regUser = new Registereduser(driver);
    			regUser.clicknonsignout();;

    			if(pg.getPageTitle().equals("Login - My Shop"))
    			{
    				logger.info("VerifySignOut - Passed");
    				Assert.assertTrue(true);
    			}

    			else
    			{
    				logger.info("VerifySignOut - Failed");
    				captureScreenShot(driver,"VerifySignOut");
    				Assert.assertTrue(false);
    			}

    		
    			logger.info("***************TestCase Verify Sign out ends*****************"); 

    		}

 
    
    
    
    
    
    
    }
    
    
 
