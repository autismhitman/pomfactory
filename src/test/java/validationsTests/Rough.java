package validationsTests;

import java.util.Hashtable;

import util.Xls_Reader;

public class Rough {

	public static void main(String[] args) {
	 		
		String testName ="CreateLeadTest";
		String sheetName ="TestCases";
		
		Xls_Reader read = new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");
		int testStartRowNum = 1;
	    
		while(!read.getCellData(sheetName, 0, testStartRowNum).equals(testName)) {
			
			testStartRowNum++;
		}
          
		System.out.println("starting rowNum is : "+ testStartRowNum);
		
		int colRowNum = testStartRowNum +1;
		int totalCols =  0;
		while(!read.getCellData(sheetName, totalCols, colRowNum).equals("")) {
			
			totalCols++;
		}
		
		System.out.println("Total Columns : " + totalCols);
	
		int dataStartRowNum = colRowNum+1;
		int totalRows =0;
		while(!read.getCellData(sheetName, 0, dataStartRowNum+totalRows).equals("")) {
			totalRows++;
		}
		
		System.out.println("Total Rows : " + totalRows);
		Object[][] testdata = new Object[totalRows][1];
		Hashtable<String,String > table = null;
		int i=0;
		for ( int rNum=dataStartRowNum; rNum<dataStartRowNum+totalRows; rNum++) {
			 
			table = new Hashtable<String,String >();
			for ( int cNum= 0; cNum< totalCols; cNum++) {
				
				String key  = read.getCellData(sheetName, cNum, colRowNum);
				String value= read.getCellData(sheetName, cNum, rNum);
		        table.put(key, value);
			 	System.out.print(key +"--"+ value+"--");
			}
			    testdata[i][0]= table;
			    i++;
			    System.out.println();
		}
		
		
		
	}

}
