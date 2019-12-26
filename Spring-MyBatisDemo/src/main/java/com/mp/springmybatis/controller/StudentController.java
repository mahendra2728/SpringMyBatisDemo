package com.mp.springmybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mp.springmybatis.dao.StudentMapper;
import com.mp.springmybatis.model.Student;

@Controller
public class StudentController {
	
	@Autowired
	StudentMapper theStudentmapper;
	
	@RequestMapping("/")
	public ModelAndView index()
	{
		ModelAndView mv=new ModelAndView("student-list");
		//System.out.println(theStudentmapper.getAllStudents());
		mv.addObject("students",theStudentmapper.getAllStudents());
		return mv;
	}
	
	
	@RequestMapping("/showAddStudentForm")
	public ModelAndView viewAddStudentForm()
	{
		ModelAndView mv=new ModelAndView("add-student");
		mv.addObject("student",new Student());
		
		return mv;
	}
	
	@RequestMapping("/saveStudent")
	public String addStudent(@ModelAttribute("student") Student student)
	{
		System.out.println(student);
		
		if(student.getId()==null) {
			//save operation
			theStudentmapper.saveStudent(student);
		}
		else {
			//update operation
			theStudentmapper.updateStudent(student);
		}
		return "redirect:/";
	}
	
	
	@RequestMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("studentId") Integer studentId)
	{
		System.out.println("Id is : "+studentId);
		theStudentmapper.deleteStudent(studentId);
		return "redirect:/";
	}
	
	
	@RequestMapping("/editStudent")
	public ModelAndView editStudent(@RequestParam("studentId") Integer studentId)
	{
		ModelAndView mv=new ModelAndView("add-student");
		Student theStudent=theStudentmapper.getStudent(studentId);
		mv.addObject("student",theStudent);
		
		return mv;
	}

}
