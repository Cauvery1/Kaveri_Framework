package com.training.dataproviders;

import org.testng.annotations.DataProvider;

import com.training.readexcel.ApachePOIExcelRead;

public class ProductReturnInvalidDataProviders {
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\IBM_ADMIN\\Desktop\\Project\\ExcelFile\\TestData.xlsx"; 
		String sheetName="RTTC_083";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}

}
