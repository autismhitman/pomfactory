package weblayer;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import base.pages.ZohoPage;

public interface ZohoWebConnector  {

	void logout();

	ZohoPage validateTitle(String expectedTitle) ;

	ZohoPage validateText( By locator, String expectedText);
	
	ZohoPage validateELementPresence( By locator);

	void launchBrowser(String browser);

	void navigate(String url);

	void quit();
		void log( String msg);  
}
//interface by default have the public methods