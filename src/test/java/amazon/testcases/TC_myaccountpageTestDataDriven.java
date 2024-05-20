package amazon.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import amazon.pageobject.CreateAnAccountpage;
import amazon.pageobject.Registereduser;
import amazon.pageobject.indexPage;
import amazon.pageobject.myAccount;
import amazon.utilities.ReadExcelfile;

public class TC_myaccountpageTestDataDriven extends BaseClass {
    
    indexPage pg;

    @Test(enabled=false)
    public void verifiedRegistrationandlogin() throws InterruptedException {
        pg = new indexPage(driver);
        pg.clickOnSignIn();
        logger.info("Clicked on sign in link");

        // Add further test steps as needed
        myAccount ac = new myAccount(driver);
        ac.enterCreateEmailAddress("teswtrad3@gmail.com");
        ac.clickSubmitCreate();

        CreateAnAccountpage cs = new CreateAnAccountpage(driver);
        cs.clickcheckbox();
        cs.sendFirstname();
        cs.sendlastname();
        cs.sendpassword();
        cs.senddays();
        cs.sendmonths();
        cs.sendyears();
        cs.clicksubmitbutton();

        Registereduser reg= new Registereduser(driver);
        String username =  reg.validateregisteruser();

        Assert.assertEquals(username, "Abhishek Behalpande", "Username validation failed");
    }

@Test(dataProvider = "LoginDataProvider")
	
	public void VerifyLogin(String userEmail, String userPwd, String expectedUsername) throws IOException 
	{

		logger.info("***************TestCase VerifyLogin starts*****************"); 


		indexPage pg = new indexPage(driver);

		pg.clickOnSignIn();
		logger.info("Clicked on sign in link");

		myAccount myAcpg = new myAccount(driver);

		myAcpg.enterEmailAddress(userEmail);
		logger.info("Entered email address");
		
		myAcpg.enterPassword(userPwd);
		logger.info("Entered password");

		myAcpg.clickSignIn();
		logger.info("Clicked on sign in link..");

		Registereduser regUser = new Registereduser(driver);
		String userName = regUser.validateregisteruser();
		
		
		if(userName.equals(expectedUsername))
		{
			logger.info("VerifyLogin - Passed");
			Assert.assertTrue(true);
			
			regUser.clicknonsignout();
			
		}
		else
		{
			logger.info("VerifyLogin - Failed");
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);

		} 
		
		 
		logger.info("***************TestCase Verify login ends*****************"); 


	}

	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider() {
	    String fileName = System.getProperty("user.dir") + "\\testdata\\mystorepro.xlsx";
	    System.out.println("File path: " + fileName); // Debugging

	    int ttlRows = ReadExcelfile.getRowCount(fileName, "LoginTestData");
	    int ttlColumns = ReadExcelfile.getColCount(fileName, "LoginTestData");

	    // Check if the Excel file contains any data
	    if (ttlRows <= 1 || ttlColumns <= 0) {
	        throw new RuntimeException("No data found in the Excel file");
	    }

	    // Initialize the data array with the correct size
	    String data[][] = new String[ttlRows][ttlColumns];
	    
	    // Populate the data array with values from the Excel file
	    for (int i = 0; i < ttlRows; i++) {
	        for (int j = 0; j < ttlColumns; j++) {
	            data[i][j] = ReadExcelfile.getCellValue(fileName, "LoginTestData", i + 1, j);
	        }
	    }

	    return data;
	}

}
