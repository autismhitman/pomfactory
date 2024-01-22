package base;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import session.ZohoTestSession;
import util.Xls_Reader;

public class BaseTest {
	
	  public ZohoTestSession session;
	  public String testName=null; 
	  public Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");
	
	
	@BeforeMethod
	public void init(ITestResult result) {
        
		testName = result.getMethod().getMethodName().toUpperCase();
		System.out.println(testName);
		session = new ZohoTestSession();//webconnector is init
		session.init(testName);
	}
	
	
	 @AfterMethod
	   public void tearDown() {
		   
		    session.generateReport();
	   }

}
