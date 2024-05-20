package amazon.testcases;



	
 

	import java.io.IOException;

	import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
	import org.testng.annotations.Test;

import amazon.pageobject.Registereduser;
import amazon.pageobject.Searchresultpage;
import amazon.pageobject.indexPage;
import amazon.pageobject.myAccount;
import amazon.pageobject.orderaddresspage;
import amazon.pageobject.orderconfirmationpage;
import amazon.pageobject.orderpaymentpage;
import amazon.pageobject.ordershippingpage;
import amazon.pageobject.orderusummarrypage;
import amazon.pageobject.productpage;

	 



	public class TC_productpage extends BaseClass  {

		@Test(enabled=true)
		public void VerifySearchProduct() throws IOException, InterruptedException
		{
			 
			logger.info("\n***************TestCase Search Product started*****************"); 

			//Sign in 
			indexPage indexPg = new indexPage(driver);
			indexPg.clickOnSignIn();
			Thread.sleep(2000);


			//Enter account details- email and password
			myAccount pg = new myAccount(driver);
			pg.enterEmailAddress("test17011999@gmail.com");

			logger.info("User Email and Password entered.");
			pg.enterPassword("Abhishek@123");
			Thread.sleep(2000);

			pg.clickSignIn();
			logger.info("Sign In link clicked");

			//Enter searchkey in search box
			Registereduser productPg = new Registereduser(driver);
			productPg.EnterDataInSearchBox();
			Thread.sleep(2000);
			productPg.ClickOnSearchButton();

			// Get Name of Searched Product
			Searchresultpage resultPg = new Searchresultpage(driver);

			String SearchResultProductname=resultPg.getSearchResultProductName();


			//Verify that correct Product is displaying after search

			if(SearchResultProductname.contains("Dress"))
			{
				logger.info("Search Product testcase - Passed"); 
				Assert.assertTrue(true);

				productPg.clicknonsignout();

			}
			else
			{
				logger.info("Search Product testcase - Failed");
				captureScreenShot(driver,"VerifySearchProduct");
				Assert.assertTrue(false);

			} 

			logger.info("***************TestCase Search Product ends*****************"); 

		}


		@Test(enabled = true)
		public void VerifyBuyProduct() throws IOException, InterruptedException
		{

			logger.info("\n***************TestCase Buy Product started*****************"); 

			/*	driver.get(url);
			logger.info("Url opened");*/

			//Sign in 
			indexPage indexPg = new indexPage(driver);
			indexPg.clickOnSignIn();
			Thread.sleep(2000);


			//Enter account details- email and password
			myAccount pg = new myAccount(driver);
			pg.enterEmailAddress("test17011999@gmail.com");

			logger.info("User Email and Password entered.");
			pg.enterPassword("Abhishek@123");
			Thread.sleep(2000);
			pg.clickSignIn();
			logger.info("Sign In link clicked");

			Registereduser prodCatPg = new Registereduser(driver);
			prodCatPg.EnterDataInSearchBox();
			logger.info("T-shirt entered in search box");
			Thread.sleep(2000);

			prodCatPg.ClickOnSearchButton();
			logger.info("clicked on search button");
			Thread.sleep(2000);
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript( "window.scroll(0,600)" );
			Thread.sleep(2000);

			Searchresultpage searchResultPg = new Searchresultpage(driver);
			searchResultPg.ClickOnMoreLink();
			Thread.sleep(2000);
			logger.info("Clicked on more button");

			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//
			
			JavascriptExecutor js2 = (JavascriptExecutor)driver;
			js2.executeScript( "window.scroll(0,600)" );


			productpage prodPg = new productpage(driver);
		

			prodPg.selectsizedress();
			Thread.sleep(2000);
			logger.info("size M entered");
			
			prodPg.selectquantitydress();
			Thread.sleep(2000);
			logger.info("quantity 2 entereed");

			 

			prodPg.clickaddtocartdress();
			Thread.sleep(2000);
			logger.info("Clicked on proceed to checkout on product page");
			
			prodPg.clickproceedtocheckout();
			Thread.sleep(2000);


			orderusummarrypage orderSumPg = new orderusummarrypage(driver);
			orderSumPg.cickOnProceedToCheckout(); 
			Thread.sleep(2000);
			logger.info("Clicked on proceed to checkout on order summary page");

			orderaddresspage orderAddPg = new orderaddresspage(driver);
			orderAddPg.clickproceedbutton();
			Thread.sleep(2000);
			logger.info("Clicked on proceed to checkout on order address page");

			ordershippingpage orderShippingPg = new ordershippingpage(driver);
			orderShippingPg.clicktermcheckbox();
			Thread.sleep(2000);
			logger.info("selecged term of service check box");

			orderShippingPg.clickproceedbutton();
			Thread.sleep(2000);
			logger.info("Clicked on proceed to checkout on order shipping page");

			orderpaymentpage orderPaymentPg = new orderpaymentpage(driver);
			logger.info(orderPaymentPg.getPageTitle());
			Thread.sleep(2000);

			orderPaymentPg.clickOnPayByCheque();
			Thread.sleep(2000);
			logger.info("Clicked on pay by cheque");

			orderconfirmationpage orderConfirmPg = new orderconfirmationpage(driver);
			orderConfirmPg.cickOnConfirmOrder();
			Thread.sleep(2000);

			logger.info("Clicked on confirmed order");

			String sucessMsg = orderConfirmPg.getOrderSucessMessage();

			//	Assert.assertEquals(sucessMsg, "Your order on My Store is complete.");

			if(sucessMsg.equals("Your order on My Shop is complete."))
			{
				logger.info("VerifyBuyProduct - Passed"); 
				Assert.assertTrue(true);

				orderConfirmPg.clickOnSignOut();

			}
			else
			{
				logger.info("VerifyBuyProduct - Failed");
				captureScreenShot(driver,"VerifyBuyProduct");
				Assert.assertTrue(false);

			} 

			logger.info("***************TestCase BuyProduct ends*****************"); 

		}


//		@Test(  )
//		public void verifyAddToWishlistWithoutLogin() throws IOException
//		{
//			logger.info("\n***************TestCase verifyAddToWishlistWithoutLogin started*****************"); 
//
//			indexPage indexPage = new indexPage(driver);
//			indexPage.clickOnTShirtMenu();
//
//			productpage prodPage = new productpage(driver);
//			prodPage.mouseOverOnTshirtProduct();
//
//			prodPage.clickOnAddToWishList();
//
//			String actualAlertMsg = prodPage.getTextOfAlertForWishList();
//			String expectedAlertMsg = "You must be logged in to manage your wishlist.";
//
//			if(actualAlertMsg.equals(expectedAlertMsg))
//			{
//				logger.info("verifyAddToWishlistWithoutLogin - passed"); 
//				Assert.assertTrue(true);
//			}
//			else
//			{
////				logger.info("verifyAddToWishlistWithoutLogin - failed"); 
////				captureScreenShot(driver,"verifyAddToWishlistWithoutLogin");
////				Assert.assertTrue(false);
////			}
//
//		}
	}
 