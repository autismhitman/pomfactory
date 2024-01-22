package base.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import session.ZohoTestSession;
import weblayer.WebConnector;

 

public class ZohoBasePage implements ZohoPage {
	
	 
	public ZohoBasePage () {
		 PageFactory.initElements(getCurrentDriver(),  this);
		 getSession().setCurrentPage(this);
	 }
	
		
	public ZohoTestSession getSession() {
		
		return (ZohoTestSession) Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}
	

	@Override
	public ZohoPage openBrowser(String browser) {
	 
		 return null;
	}
	
 
	public WebConnector getDriver() {
	 
		return getSession().getCon();
	}

	
	 public WebDriver getCurrentDriver() {
		  
	 	 return getSession().getCon().getCurrentDriver() ;
	   }
	 
	 public void log( String msg) {
		 getSession().log(msg);
		 
	 }
	 
	 
	@Override
	public void quit() {
 
		
	}

	@Override
	public void getTotalWindows() {
	 
		
	}
    
	@Override
	public ZohoPage clickonSignin() {
		 
		return null;
	}

	@Override
	public ZohoPage enterDetails(String uname, String pwd) {
		 
		return null;
	}

	@Override
	public WebConnector validator(boolean stopExecution) {
		
		getSession().getCon().setStopExecution(stopExecution);
		return getSession().getCon(); 
	}

	@Override
	public void createDeal() {
	 
		
	}

	@Override
	public void logout() {
		 
		
	}

 
	public void waitForPageToLoad(){
		JavascriptExecutor js = (JavascriptExecutor)getCurrentDriver();
		int i=1;
		// check for pageload 100% - 20 secs
		while(i!=10){
		String state = (String)js.executeScript("return document.readyState;");
		System.out.println(state);

		if(state.equals("complete"))
			break;
		else
			wait(2);

		i++;
		}
		// check for jquery/ajax status - 20 secs
		i=1;
		while(i!=10){
	
			Long d= (Long) js.executeScript("return jQuery.active;");
			System.out.println(d);
			if(d.longValue() == 0 )
			 	break;
			else
				 wait(2);
			 i++;
				
			}
		
		}
  
	public void wait(int time) {
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ZohoPage gotoHomePage() {
		// TODO Auto-generated method stub
		return null;
	}
}
