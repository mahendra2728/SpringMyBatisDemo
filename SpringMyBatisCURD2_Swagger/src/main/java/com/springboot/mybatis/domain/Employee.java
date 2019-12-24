package com.springboot.mybatis.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(value=Include.NON_NULL)
public class Employee {

	private int employee_id;
	private String employee_fname;
	private String employee_lname;
	private String employee_address;
	private String department;
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_fname() {
		return employee_fname;
	}
	public void setEmployee_fname(String employee_fname) {
		this.employee_fname = employee_fname;
	}
	public String getEmployee_lname() {
		return employee_lname;
	}
	public void setEmployee_lname(String employee_lname) {
		this.employee_lname = employee_lname;
	}
	public String getEmployee_address() {
		return employee_address;
	}
	public void setEmployee_address(String employee_address) {
		this.employee_address = employee_address;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee Data : ["
				+ "employee_id=" + employee_id + ", "
				+ "employee_fname=" + employee_fname + ", "
			    + "employee_lname="+ employee_lname + ", "
			    + "employee_address=" +employee_address + ", "
			    + "department=" + department + "]";
	}
	public Employee(int employee_id, String employee_fname, String employee_lname, String employee_address,
			String department) {
		super();
		this.employee_id = employee_id;
		this.employee_fname = employee_fname;
		this.employee_lname = employee_lname;
		this.employee_address = employee_address;
		this.department = department;
	}
	public Employee() {
		super();
	}
}
