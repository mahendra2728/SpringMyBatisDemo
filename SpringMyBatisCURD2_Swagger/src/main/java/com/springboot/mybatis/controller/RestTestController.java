package com.springboot.mybatis.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mybatis.domain.Employee;
import com.springboot.mybatis.mapper.EmployeeMapper;

@RestController
@RequestMapping("/rest/api")   // localhost:7200/SpringMyBatisCURD/rest/api/allemps
public class RestTestController {
	
	private EmployeeMapper empMapper;


	public RestTestController(EmployeeMapper empMapper) {
        this.empMapper = empMapper;
    }
	
	@GetMapping("/allemps")
    public List<Employee> getAll() {
        return empMapper.findAll();
    }
	@PostMapping("/addEmployee")
    private ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        empMapper.insert(employee);
        if(employee==null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<Employee>(employee,HttpStatus.OK);
    }

    @GetMapping("/update")
    private List<Employee> update() {

    	Employee emps = new Employee();
    	emps.setEmployee_fname("Test_B");
    	emps.setEmployee_lname("TestL_B");
    	emps.setEmployee_address("UK");
    	emps.setDepartment("WWE");

        empMapper.insert(emps);

        return empMapper.findAll();
    }
    
    @RequestMapping(value = "/deleteEmp/{employee_id}", method = RequestMethod.DELETE)
    private ResponseEntity<Object> deleteEmployee(@PathVariable("employee_id") int employee_id)
    {
    	System.out.println("employee_id : "+employee_id);
    	boolean flag=false;
    	flag=empMapper.deleteEmployee(employee_id);
    	if(flag)
    	    return new ResponseEntity<Object>("SUCCESS",HttpStatus.OK);
		else
			return new ResponseEntity<>("BAD REQUEST",HttpStatus.BAD_REQUEST);
    }
    
    @RequestMapping(value="updateEmp", method = RequestMethod.PUT)
    private ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
    {
    	empMapper.updateEmployee(employee);
    	if(employee!=null)
    	    return new ResponseEntity<Employee>(HttpStatus.OK);
		else
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value="selectEmp/{employee_id}", method = RequestMethod.GET)
    private ResponseEntity<Employee> selectEmployee(@PathVariable("employee_id") int employee_id)
    {
    	Employee emp=empMapper.selectEmployee(employee_id);
    	if(emp!=null)
    	    return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		else
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
    }
    
    
    @RequestMapping(value="selectEmpname/{employee_id}", method = RequestMethod.GET)
    private ResponseEntity<Employee> selectEmployeeName(@PathVariable("employee_id") int employee_id)
    {
    	Employee emp=empMapper.selectEmployeeFname(employee_id);
    	if(emp!=null)
    	    return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		else
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
    }
    
    @RequestMapping(value="/testAPI", method = RequestMethod.GET)
   public ResponseEntity<String> getMessage()
   {
    	try
    	{
    	  String respond=getTestName();
       	  return new ResponseEntity<String>(respond,HttpStatus.OK);
    	}
    	finally
    	{
    		getTestName2();
    	}
    	
   }

    public String getTestName()
    {
    	return "Hey  Mahendra First Execution";
    }
    public String getTestName2()
    {
    	System.out.println("called sucessfully....");
    	return "Hey  Mahendra First Execution";
    }
}
