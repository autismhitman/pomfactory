package session;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.pages.ZohoPage;
import pages.normal.HomePage;
import pages.normal.LaunchPage;
import reports.ExtentManager;
import weblayer.WebConnector;
import weblayer.ZohoDriver;

public class ZohoTestSession {
	
	
	WebConnector con ;
	ZohoPage currentPage;
	ExtentReports reports;
	ExtentTest test;
	boolean executeListener ;
	


	public boolean isExecuteListener() {
		return executeListener;
	}

	public void setExecuteListener(boolean executeListener) {
		this.executeListener = executeListener;
	}

	public ZohoTestSession () {
		
		con = new ZohoDriver();
	}
	
	public void init(String testName) {
		
		if(Reporter.getCurrentTestResult().getTestContext().getAttribute("session")==null)  
			
			Reporter.getCurrentTestResult().getTestContext().setAttribute("session", this);
		
		reports = ExtentManager.getReports();
		test = reports.createTest(testName);
		 
		//ZohoPage page = new HomePage();
		
		//return new LaunchPage();
	}
	
	public WebConnector getCon() {
		return con;
		
	}
	
	public ZohoPage getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(ZohoPage currentPage) {
		this.currentPage = currentPage;
	}

	public void end() {
		
		 
		getCon().assertAll();
		
	}
	
	public void generateReport() {
		if(reports!=null)
		reports.flush();
	}
	
	public void log( String msg) {
		
		test.log(Status.INFO, msg);
	}
     
	public void failTest(String msg) {
		
		takescreenshot();
        test.log(Status.FAIL, msg);
		
	}
	
	public void skipTest(String msg) {
		
		 
        test.log(Status.SKIP, msg);
		
	}
	
	public void takescreenshot() {
		
		Date d = new Date();
		String screenshotFile = d.toString().replaceAll(" ", "_").replaceAll(":", "_") + ".png";
		File src = ((TakesScreenshot) getCon().getCurrentDriver()).getScreenshotAs(OutputType.FILE);

		try {

			FileUtils.copyFile(src, new File(ExtentManager.screenshotPath + "//" + screenshotFile));
			test.log(Status.INFO, "screenshot-> "
					+ test.addScreenCaptureFromPath(ExtentManager.screenshotPath + "//" + screenshotFile));
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
}
