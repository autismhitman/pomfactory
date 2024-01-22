package validationsTests;

import util.Xls_Reader;

public class Rough1 {

	
	
	
	public static void main(String[] args) {
		 
		Xls_Reader read = new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");
		
 
		System.out.println(isRunnable("LoginTest", read));
		
		
		
	}
	
	public static boolean isRunnable(String testName,  Xls_Reader xls ) {
		
		int rows = xls.getRowCount("TestStatus");
		
		for(int rNum= 2; rNum<rows; rNum++) {
			
			String testCaseName =xls.getCellData("TestStatus", "TCID", rNum);
			
			if( testCaseName.equals(testName)) {
				
				String runmode  =xls.getCellData("TestStatus", "Runmode", rNum);
				if(runmode.equals("Y")) {
					return true;
				}
				else {
					return false;
				}
			}
	
		}
		return false;
	}

}
