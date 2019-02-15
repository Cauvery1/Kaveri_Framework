package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.OrderBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

public class RetailDAO {
Properties properties; 
	
	public RetailDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<OrderBean> getOrders(){
		String sql = properties.getProperty("get.orders"); 
		
		GetConnection gc  = new GetConnection(); 
		List<OrderBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<OrderBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				OrderBean temp = new OrderBean(); 
				temp.setOrderid(gc.rs1.getString(1));
				temp.setCustomervalue(gc.rs1.getString(2));
				temp.setFirstname(gc.rs1.getString(3));
				temp.setLastname(gc.rs1.getString(4));
				temp.setEmail(gc.rs1.getString(5));
				temp.setPhone(gc.rs1.getString(6));
				temp.setProd(gc.rs1.getString(7));
				temp.setModel(gc.rs1.getString(8));
				

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new RetailDAO().getOrders().forEach(System.out :: println);
	}
	

}
