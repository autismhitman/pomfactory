package suite.login;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import base.pages.ZohoPage;
import constants.Constants;
import pages.normal.LaunchPage;
import session.ZohoTestSession;
import util.DataUtil;
import util.TestDataProvider;
import util.Xls_Reader;

public class LoginTest extends BaseTest{
	
	
	
	
	@Test(dataProviderClass=TestDataProvider.class,dataProvider="getData")
	public void loginTest(Hashtable<String, String> data) {
	
		
	   // ZohoTestSession session = new ZohoTestSession();//webconnector is init
		
		if(!new DataUtil().isRunnable(testName, xls) || data.get("runmode").equals("N")) {
			
		     session.skipTest("The runmode is N"); //skip in reports
			 throw  new SkipException("The runmode is N");//skip in testng
			
		}
		                   //  session
	    				   //   .init("LoginTest")  /store session in testcontext, object of home page/
		
		ZohoPage page	=   new LaunchPage()
	    					.openBrowser(data.get("browser"))
	    					.gotoHomePage()
	    					.validator(false).validateTitle("Zoho | Cloud Software Suite for Businesses") 
	    					.validator(false).validateText(Constants.TEXTCONTENT_FIELD_LOCATOR,"ABC" ) 
	    					.clickonSignin() 
	    					.validator(false).validateELementPresence(Constants.EMAIL_TEXTFIELD_LOCATOR)
	                        .enterDetails(data.get("username"), data.get("password")) ;
	                         
	                    session.end();
         
	   }
	
 
}


