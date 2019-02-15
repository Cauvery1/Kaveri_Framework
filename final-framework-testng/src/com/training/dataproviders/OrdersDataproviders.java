package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.bean.OrderBean;
import com.training.dao.ELearningDAO;
import com.training.dao.RetailDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class OrdersDataproviders {
	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<OrderBean> list = new RetailDAO().getOrders(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(OrderBean temp : list){
			Object[]  obj = new Object[8]; 
			obj[0] = temp.getOrderid(); 
			obj[1] = temp.getCustomervalue();
			obj[2] = temp.getFirstname();
			obj[3] = temp.getLastname();
			obj[4] = temp.getEmail();
			obj[5] = temp.getPhone();
			obj[6] = temp.getProd();
			obj[7] = temp.getModel();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\IBM_ADMIN\\Desktop\\Project\\ExcelFile\\TestData.xlsx"; 
		String sheetName="RTTC_085";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
