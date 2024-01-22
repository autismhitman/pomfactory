package weblayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import base.pages.ZohoPage;
import session.ZohoTestSession;

public interface WebConnector extends ZohoWebConnector {
	// driver based commands

	void launchBrowser(String browser);

	void navigate(String url);

	void quit();

	ZohoTestSession getSession();

	WebDriver getCurrentDriver();

	boolean isStopExecution();

	void setStopExecution(boolean stopExecution);

	void assertAll();

	SoftAssert getSoftAssert();

	void setSoftAssert(SoftAssert softAssert);

	void fail(String message);
	ZohoPage validateText( By locator, String expectedText);
	ZohoPage validateELementPresence( By locator);
}
