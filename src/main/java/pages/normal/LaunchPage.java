package pages.normal;

import base.pages.ZohoBasePage;
import base.pages.ZohoPage;

public class LaunchPage extends ZohoBasePage {
	
	

    public ZohoPage openBrowser(String browser) {
    	log("Launch the broswer");
    	getDriver().launchBrowser(browser);
	    return this;
    }
    
	public ZohoPage gotoHomePage() {
		log("Navigate to the home page -https://zoho.com ");
		getDriver().navigate("https://zoho.com");
		return new HomePage();
	}
	
	
}
