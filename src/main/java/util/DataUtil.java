package util;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;

public class DataUtil {
 
	 
	  public Object[][] getData(String testName, Xls_Reader xls){
		  
		    
		   // String testName ="LoginTest";
			String sheetName ="TestCases";
			
			//Xls_Reader read = new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");
			int testStartRowNum = 1;
		    
			while(!xls.getCellData(sheetName, 0, testStartRowNum).equalsIgnoreCase(testName)) {
				
				testStartRowNum++;
			}
	          
			System.out.println("starting rowNum is : "+ testStartRowNum);
			
			int colRowNum = testStartRowNum +1;
			int totalCols =  0;
			while(!xls.getCellData(sheetName, totalCols, colRowNum).equals("")) {
				
				totalCols++;
			}
			
			System.out.println("Total Columns : " + totalCols);
		
			int dataStartRowNum = colRowNum+1;
			int totalRows =0;
			while(!xls.getCellData(sheetName, 0, dataStartRowNum+totalRows).equals("")) {
				totalRows++;
			}
			
			System.out.println("Total Rows : " + totalRows);
			Object[][] testdata = new Object[totalRows][1];
			Hashtable<String,String > table = null;
			int i=0;
			for ( int rNum=dataStartRowNum; rNum<dataStartRowNum+totalRows; rNum++) {
				 
				table = new Hashtable<String,String >();
				for ( int cNum= 0; cNum< totalCols; cNum++) {
					
					String key  = xls.getCellData(sheetName, cNum, colRowNum);
					String value= xls.getCellData(sheetName, cNum, rNum);
			        table.put(key, value);
				 	System.out.print(key +"--"+ value+"--");
				}
				    testdata[i][0]= table;
				    i++;
				    System.out.println();
			}
			return testdata;
	  }
	  
	  
	  public boolean isRunnable(String testName,  Xls_Reader xls ) {
			
			int rows = xls.getRowCount("TestStatus");
			
			for(int rNum= 2; rNum<rows; rNum++) {
				
				String testCaseName =xls.getCellData("TestStatus", "TCID", rNum);
				
				if( testCaseName.equalsIgnoreCase(testName)) {
					
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
