package com.springboot.mybatis.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mybatis.domain.Next_Emp;
import com.springboot.mybatis.mapper.NextEmpMapper;
import com.springboot.mybatis.utility.EmailUtility;

@RestController
@RequestMapping("/api")
public class NextEmpController {

	
	NextEmpMapper nextEmpMapper;
	
	@Autowired
	public NextEmpController(NextEmpMapper theNextEmpMapper)
	{
		this.nextEmpMapper=theNextEmpMapper;
	}
	
	@GetMapping("/students")
	public List<Next_Emp> getStudents()
	{
		return nextEmpMapper.getNextEmps();
	}
	
	@GetMapping("/students/{id}")
	public Next_Emp getStudent(@PathVariable int id)
	{
		return nextEmpMapper.getNextEmp(id);
	}
	
	@PostMapping("/students")
	public Next_Emp save(@RequestBody Next_Emp theStudent)
	{	
		//System.out.println(theStudent.toString());
		nextEmpMapper.addNextEmp(theStudent);
		return theStudent;
	}
	
	@GetMapping("/sendEmail")
	public void sendEmail()
	{
		List<Next_Emp> employee_list=nextEmpMapper.getNextEmp_Birth();
		if(employee_list!=null)
		{
			for(Next_Emp emp:employee_list)
			{
				SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");  
			    String strDate = formatter.format(emp.getBirth_date()); 
			    EmailUtility.sendBirthdayWishEmail(emp.getFirst_name(),emp.getEmail());
			}
		}	
	}
}
