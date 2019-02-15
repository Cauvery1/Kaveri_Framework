package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;


import com.training.readexcel.ApachePOIExcelRead;


public class ProductReturnDataproviders {

	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\IBM_ADMIN\\Desktop\\Project\\ExcelFile\\TestData.xlsx"; 
		String sheetName="RTTC_082";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	

}
