package weblayer;

 
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import base.pages.ZohoPage;
import session.ZohoTestSession;

public abstract class AbstractZohoValidationDriver implements  WebConnector {

	WebDriver driver; 
	boolean stopExecution;
	SoftAssert softAssert = new SoftAssert();
	
	public boolean isStopExecution() {
		return stopExecution;
	}

	public void setStopExecution(boolean stopExecution) {
		this.stopExecution = stopExecution;
	}

	@Override
	public ZohoPage validateTitle(String expectedTitle)  {
		
		if(!expectedTitle.equals(driver.getTitle())) {
			
			softAssert.fail("Title mismatched");
			
			if(isStopExecution())  
				softAssert.assertAll();
			 
		}
		 
	    return getSession().getCurrentPage();
		 
	}
	
	public void assertAll() {
		
		//take screenshot
		softAssert.assertAll();
	}
 
	public void fail(String msg) {
		
		getSession().failTest(msg);//extent fail;
		softAssert.fail(msg); //testng fail
		
		if(stopExecution)  
			assertAll();
	 
	}
	 
	public SoftAssert getSoftAssert() {
		return softAssert;
	}

	public void setSoftAssert(SoftAssert softAssert) {
		this.softAssert = softAssert;
	}

	public ZohoPage validateText( By locator, String expectedText) {
		
		String actualText = "ABC" ;//driver.findElement(locator).getText().trim();
		if(!expectedText.equals(actualText)){
			
			fail("Text Mistmatched " + actualText);
			
			//if(isStopExecution())  
			//softAssert.assertAll();
			 
		}
		 
	    return getSession().getCurrentPage();
	    
	} 

	@Override
	public ZohoPage validateELementPresence( By locator) {
		
		if(!isElementPresent(locator))
			fail("Element not found "+ locator);
		
	      return getSession().getCurrentPage();
 
	}
	
	public boolean isElementPresent(By locator) {
		 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		}
		catch(TimeoutException e) {
		 
			log("Element not found "+locator);
			return false;
		}
	 
		log("Element found successfully "+locator);
		return true;
		
	}
	
	
	public  ZohoTestSession getSession() {
		
		return ( ZohoTestSession) Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}
	
		public void log( String msg) {
		
		getSession().log(msg);
	}
}
