package base.pages;

import weblayer.WebConnector;

public interface ZohoNormal {

	ZohoPage gotoHomePage();
	ZohoPage  clickonSignin();
	ZohoPage enterDetails(String uname, String pwd);
	WebConnector validator(boolean stopExecution);
}
