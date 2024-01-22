package base.pages;

import session.ZohoTestSession;
import weblayer.WebConnector;

public interface ZohoPage  extends ZohoSessionPage, ZohoNormal {

	//normal browser operations
	ZohoPage openBrowser(String browser);
	void quit();
	void getTotalWindows();
	ZohoTestSession getSession();
	
	//normal pages zoho based
	ZohoPage  clickonSignin();
	ZohoPage enterDetails(String uname, String pwd);
	WebConnector validator(boolean stopExecution);
 	ZohoPage gotoHomePage();
 	void log( String msg);
	
	//session based
 	void createDeal();
 	void logout();
	
}
