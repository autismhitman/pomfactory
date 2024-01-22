package listener;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import session.ZohoTestSession;
import weblayer.WebConnector;

public class ZohoEventListener implements WebDriverListener {
//how do you validate objects	
   
    public void beforeFindElement(WebDriver driver, By locator) {
   	 
    	if(getSession().isExecuteListener()) {
    		
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    		try {
    			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    			wait.until(ExpectedConditions.elementToBeClickable(locator));
    		}catch(TimeoutException e) {
    			getDriver().fail("Element not found - "+locator);
    			getDriver().assertAll();
    		}
    		
    	}
    	
    	
    }

	public WebConnector getDriver() {
		return getSession().getCon();
	}
	
	public ZohoTestSession getSession() {
		return (ZohoTestSession)Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}

	 /* sample o/p
  
		Before finding by By.cssSelector: .signupcontainer>a:nth-child(1)
		Before finding driver ChromeDriver: chrome on windows (f40401085761441dee372df01969c0f9)
		Before finding by By.cssSelector: #login_id
		Before finding driver ChromeDriver: chrome on windows (f40401085761441dee372df01969c0f9)
		Before finding by By.cssSelector: #nextbtn span
		Before finding driver ChromeDriver: chrome on windows (f40401085761441dee372df01969c0f9)
		Before finding by By.cssSelector: #password
		Before finding driver ChromeDriver: chrome on windows (f40401085761441dee372df01969c0f9)
		Before finding by By.cssSelector: #password
		Before finding driver ChromeDriver: chrome on windows (f40401085761441dee372df01969c0f9)
		Before finding by By.cssSelector: #nextbtn span
		Before finding driver ChromeDriver: chrome on windows (f40401085761441dee372df01969c0f9)
		FAILED: validationsTests.LoginTest.loginTest
 
	  */

}
