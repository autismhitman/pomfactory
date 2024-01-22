package util;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
	@DataProvider
	public static  Object[][] getData(Method m){
		 
		    System.out.println("Got data for "+ m.getName());
		    Object[][] data = new DataUtil().getData(m.getName(), new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx"));
		    return data;
	 }

}
