package com.training.bean;

public class OrderBean {
	private String orderid;
	private String customervalue;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private String prod;
	private String model;
	
	public OrderBean() {}
	public OrderBean(String orderid,String customervalue,String firstname,String lastname,String email,String phone,String prod,String model) {
		super();
		this.orderid=orderid;
		this.customervalue=customervalue;
		this.firstname=firstname;
		this.lastname=lastname;
		this.email=email;
		this.phone=phone;
		this.prod=prod;
		this.model=model;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getCustomervalue() {
		return customervalue;
	}
	public void setCustomervalue(String customervalue) {
		this.customervalue = customervalue;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getProd() {
		return prod;
	}
	public void setProd(String prod) {
		this.prod = prod;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	
}
