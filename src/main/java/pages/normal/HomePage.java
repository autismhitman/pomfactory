package pages.normal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.pages.ZohoBasePage;
import base.pages.ZohoPage;
import constants.Constants;

public class HomePage extends ZohoBasePage {
	
	
	@FindBy(css = Constants.SIGNIN_BUTTON)  
    WebElement signInbutton;
 
		
	
	public ZohoPage clickonSignin() {
		log("Clicing on the signin button");
		    signInbutton.click();        
		    return new SignInPage();
		 
	 }
	
	
	 

	 
	
 
	/*
	 
	public SignInPage clickonSignin() {
		
		signIn.click();
		 return new SignInPage(driver);
		//return PageFactory.initElements(driver, SignInPage.class);
	 }

 */

}
