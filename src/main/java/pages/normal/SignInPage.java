package pages.normal;

 

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.pages.ZohoBasePage;
import base.pages.ZohoPage;
import constants.Constants;

public class SignInPage extends ZohoBasePage {
      
  
	
	@FindBy(css=Constants.EMAIL_TEXTFIELD)
	WebElement email;
	
	@FindBy(css=Constants.NEXT_BUTTON)
	WebElement nextButton;
	
	@FindBy(css=Constants.PASSWORD_FIELD)
	WebElement pwdField;
	
 
	
	public ZohoPage enterDetails(String uname, String pwd) {
		log("Enter the email");
		email.sendKeys(uname);
		log("Clicking on the next button");
	    nextButton.click();
	    WebDriverWait wait = new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(pwdField));
	    log("Enter the pwd");
	     pwdField.sendKeys(pwd);
	 	log("Clicking on the next button");
	     nextButton.click();
	     return new LandingPage();
	  
	 
	    
	}
	
	/*
	
	public LandingPage enterDetails(String uname, String pwd) {
		
		email.sendKeys(uname);
	    nextButton.click();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(pwdField));
	    
	     pwdField.sendKeys(pwd);
	     nextButton.click();
	       return new LandingPage(driver);
	    //return PageFactory.initElements(driver, LandingPage.class);
	 
	    
	}
	
	*/
	
}
